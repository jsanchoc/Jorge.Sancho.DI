import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { RouterOutlet, RouterLinkWithHref, Router } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [FormsModule, RouterOutlet, RouterLinkWithHref, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  constructor(private gestorRutas: Router) {}
  navegar() {
    this.gestorRutas.navigate(['tareas']);
  }
}
