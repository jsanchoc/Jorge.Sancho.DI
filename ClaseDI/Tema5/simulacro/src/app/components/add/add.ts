import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';

@Component({
  selector: 'app-add',
  imports: [FormsModule],
  templateUrl: './add.html',
  styleUrl: './add.css',
})
export class Add {
  titulo?: string;
  responsable?: string;
  fecha?: string;
  prioridad?: number;

  constructor(private gestor: TareasGestor) {}

  procesarTarea() {
    let nuevaTarea: Tarea = {
      id: 0,
      titulo: this.titulo!!,
      responsable: this.responsable!!,
      fecha: this.fecha!!,
      prioridad: Number(this.prioridad)!!,
    };

    this.gestor.addTarea(nuevaTarea);

    this.titulo = '';
    this.responsable = '';
    this.fecha = '';
    this.prioridad = 0;
  }
}
