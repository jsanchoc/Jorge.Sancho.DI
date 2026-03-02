import { Injectable, inject } from '@angular/core';
import {
  Auth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  signOut,
} from '@angular/fire/auth';

@Injectable({
  providedIn: 'root',
})
export class AuthGestor {
  private auth = inject(Auth);

  // Función para registrarse
  registro(email: string, pass: string) {
    return createUserWithEmailAndPassword(this.auth, email, pass);
  }

  // Función para iniciar sesión
  login(email: string, pass: string) {
    return signInWithEmailAndPassword(this.auth, email, pass);
  }

  // Función para cerrar sesión
  logout() {
    return signOut(this.auth);
  }
}
