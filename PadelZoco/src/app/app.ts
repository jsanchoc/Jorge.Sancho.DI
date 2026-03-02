import { Component, inject } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive, Router } from '@angular/router';
import { Auth, signOut } from '@angular/fire/auth';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive], // <-- Importante para que funcione la navegación
  templateUrl: './app.html',
  styleUrl: './app.css', // O .scss si usas SASS
})
export class App {
  private auth = inject(Auth);
  private router = inject(Router);

  cerrarSesion() {
    Swal.fire({
      title: '¿Cerrar sesión?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: 'Sí, salir',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        signOut(this.auth).then(() => {
          this.router.navigate(['/login']);
        });
      }
    });
  }
}
