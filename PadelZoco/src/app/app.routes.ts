import { Routes } from '@angular/router';
import { List } from './components/list/list';
import { Carrito } from './components/carrito/carrito';
import { Login } from './components/login/login';
import { Pedidos } from './components/pedidos/pedidos';
import { Admin } from './components/admin/admin';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },

  { path: 'login', component: Login },
  { path: 'tienda', component: List },
  { path: 'carrito', component: Carrito },
  { path: 'pedidos', component: Pedidos },
  { path: 'admin', component: Admin },
  { path: '**', redirectTo: '/tienda' },
];
