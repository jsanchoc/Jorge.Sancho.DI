import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthGestor } from '../../services/auth-gestor';
import { Auth, sendPasswordResetEmail } from '@angular/fire/auth';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule], // Obligatorio para los inputs
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  email: string = '';
  pass: string = '';
  isRegistro: boolean = false; // Interruptor para cambiar entre Login y Registro

  private authGestor = inject(AuthGestor);
  private router = inject(Router);
  private auth = inject(Auth);

  procesarFormulario() {
    if (!this.email || !this.pass) {
      Swal.fire('Atención', 'Rellena todos los campos', 'warning');
      return;
    }

    if (this.isRegistro) {
      // MODO REGISTRO
      this.authGestor
        .registro(this.email, this.pass)
        .then(() => {
          Swal.fire('¡Genial!', 'Cuenta creada con éxito', 'success');
          // Al registrarse, lo mandamos al catálogo (que crearemos luego)
          this.router.navigate(['/listar']);
        })
        .catch((error) =>
          Swal.fire(
            'Error',
            'No se pudo crear la cuenta (la contraseña debe tener al menos 6 caracteres)',
            'error',
          ),
        );
    } else {
      // MODO LOGIN
      this.authGestor
        .login(this.email, this.pass)
        .then(() => {
          Swal.fire('¡Bienvenido!', 'Has iniciado sesión correctamente', 'success');
          this.router.navigate(['/listar']);
        })
        .catch((error) => Swal.fire('Error', 'Correo o contraseña incorrectos', 'error'));
    }
  }
  recuperarContrasena() {
    Swal.fire({
      title: 'Recuperar Contraseña',
      text: 'Introduce tu correo electrónico para recibir un enlace de recuperación.',
      input: 'email',
      inputPlaceholder: 'ejemplo@correo.com',
      showCancelButton: true,
      confirmButtonText: 'Enviar enlace',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed && result.value) {
        // Firebase hace la magia aquí
        sendPasswordResetEmail(this.auth, result.value)
          .then(() => {
            Swal.fire('¡Enviado!', 'Revisa tu bandeja de entrada (y la de SPAM)', 'success');
          })
          .catch((error) => {
            console.error(error);
            Swal.fire('Error', 'No hay ninguna cuenta registrada con ese correo.', 'error');
          });
      }
    });
  }
}
