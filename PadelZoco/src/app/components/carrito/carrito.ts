import { Component, inject, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarritoGestor } from '../../services/carrito-gestor';
import { PedidosGestor } from '../../services/pedidos-gestor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carrito.html',
})
export class Carrito implements OnInit {
  items: any[] = [];
  private carritoService = inject(CarritoGestor);
  private pedidosService = inject(PedidosGestor);
  private cdr = inject(ChangeDetectorRef); // <-- Nuestro chivato para Angular

  ngOnInit() {
    this.carritoService.getCarrito().subscribe({
      next: (res) => {
        console.log('🛒 Datos del carrito desde Firebase:', res); // Para comprobar en la consola (F12)
        this.items = res || [];
        this.cdr.detectChanges(); // <-- Le decimos a la vista: "¡Actualízate, han llegado cosas!"
      },
      error: (err) => {
        console.error('Error al cargar el carrito:', err);
      },
    });
  }

  get total() {
    return this.items.reduce((acc, item) => acc + item.precio * (item.cantidad || 1), 0);
  }

  aumentar(item: any) {
    const nuevaCantidad = (item.cantidad || 1) + 1;
    this.carritoService.actualizarCantidad(item.id_en_carrito, nuevaCantidad);
  }

  disminuir(item: any) {
    const cantidadActual = item.cantidad || 1;
    if (cantidadActual > 1) {
      this.carritoService.actualizarCantidad(item.id_en_carrito, cantidadActual - 1);
    } else {
      this.eliminar(item);
    }
  }

  eliminar(item: any) {
    Swal.fire({
      title: '¿Eliminar producto?',
      text: `Se borrará ${item.nombre} de tu carrito.`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, borrar',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.carritoService.eliminarItem(item.id_en_carrito);
      }
    });
  }

  finalizarCompra() {
    if (this.items.length === 0) return;

    // 1. Primero creamos el pedido en Firebase
    this.pedidosService
      .crearPedido(this.items, this.total)
      .then(() => {
        // 2. Si se crea bien, vaciamos el carrito
        this.carritoService.vaciarCarrito().then(() => {
          Swal.fire({
            title: '¡Pedido Confirmado!',
            text: 'Tu compra se ha realizado con éxito.',
            icon: 'success',
            confirmButtonColor: '#3085d6',
          });
        });
      })
      .catch(() => {
        Swal.fire('Error', 'Hubo un problema al tramitar el pedido', 'error');
      });
  }
}
