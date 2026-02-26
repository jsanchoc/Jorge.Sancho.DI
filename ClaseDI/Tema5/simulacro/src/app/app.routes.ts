import { Routes } from '@angular/router';
import { Add } from './components/add/add';
import { List } from './components/list/list';

export const routes: Routes = [
  { path: 'agregar', component: Add },
  { path: 'listar', component: List },
  { path: '', redirectTo: 'listar', pathMatch: 'full' }, // Ruta por defecto
];
