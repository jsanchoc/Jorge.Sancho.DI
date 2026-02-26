import { Component } from '@angular/core';
import { hobbieintf } from '../../model/hobbieintf';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-hobbies',
  imports: [FormsModule],
  templateUrl: './hobbies.html',
  styleUrl: './hobbies.css',
})
export class Hobbies {
  nombre?: string;
  nivel?: number;
  fecha?: string;
  hobbies: hobbieintf[] = [];

  guardarEnLista() {
    this.hobbies.push({ nombre: this.nombre, nivel: this.nivel, fecha: this.fecha });
  }
}

// hobbie: hobbieclass
/* 
  crear un formulario para poder incluis un hobbie dentro de una lista. 
  Un hobbie tiene como elementos un
  
  nombre (string), nivel (int), fecha (date)

  - Cada vez que se pulse el boton agregar se realiza una confirmacion
  del hobbie
  - Cada vez que agrego un hobbie se lleve a un array
  
  */
