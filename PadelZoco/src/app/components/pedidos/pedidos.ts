import { Component, inject, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PedidosGestor } from '../../services/pedidos-gestor';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pedidos.html',
})
export class Pedidos implements OnInit {
  listaPedidos: any[] = [];
  cargando: boolean = true;

  private pedidosService = inject(PedidosGestor);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit() {
    this.pedidosService.getPedidos().subscribe({
      next: (data) => {
        // Le damos la vuelta a la lista para ver los más nuevos primero
        this.listaPedidos = (data || []).reverse();
        this.cargando = false;
        this.cdr.detectChanges();
      },
      error: (e) => {
        console.error('Error al cargar pedidos', e);
        this.cargando = false;
        this.cdr.detectChanges();
      },
    });
  }
}
