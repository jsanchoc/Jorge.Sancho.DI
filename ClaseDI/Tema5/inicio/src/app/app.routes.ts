import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Hobbies } from './components/hobbies/hobbies';
import { Tareas } from './components/tareas/tareas';

export const routes: Routes = [
  { path: '**', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'hobbies', component: Hobbies },
  { path: 'tareas', component: Tareas },
];
