import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Tarea } from '../../model/tarea';
import { TareasGestor } from '../../services/tareas-gestor';
import { ImagenesPipe } from '../pipes/imagenes-pipes';

@Component({
  selector: 'app-list',
  imports: [CommonModule, ImagenesPipe],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  listaTareas: Tarea[] = [];

  constructor(private gestor: TareasGestor) {
    this.listaTareas = this.gestor.getAllTareas();
  }
}
