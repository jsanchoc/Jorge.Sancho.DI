import { Component, inject, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductosGestor } from '../../services/productos-gestor';
import { PedidosGestor } from '../../services/pedidos-gestor'; // <-- Importamos los pedidos
import { Producto } from '../../model/producto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin.html',
})
export class Admin implements OnInit {
  listaProductos: Producto[] = [];
  listaPedidosTotales: any[] = []; // <-- Aquí guardaremos todos los pedidos

  productoActual: Producto = {
    nombre: '',
    categoria: 'Palas',
    precio: 0,
    stock: 0,
    descripcion: '',
    imagen: '',
  };
  modoEdicion: boolean = false;

  private gestorProductos = inject(ProductosGestor);
  private gestorPedidos = inject(PedidosGestor); // <-- Inyectamos el servicio
  private cdr = inject(ChangeDetectorRef);

  ngOnInit() {
    this.cargarProductos();
    this.cargarPedidosGlobales(); // <-- Cargamos los pedidos al entrar
  }

  cargarProductos() {
    this.gestorProductos.getAllProductos().subscribe((data) => {
      this.listaProductos = data || [];
      this.cdr.detectChanges();
    });
  }

  // 👇 NUEVA FUNCIÓN QUE ORDENA TODOS LOS PEDIDOS 👇
  cargarPedidosGlobales() {
    this.gestorPedidos.getAllPedidosAdmin().subscribe((data) => {
      const pedidosAplanados: any[] = [];

      if (data) {
        // Recorremos cada cliente
        Object.keys(data).forEach((idUsuario) => {
          const pedidosDelUsuario = data[idUsuario];

          // Recorremos cada pedido de ese cliente
          Object.keys(pedidosDelUsuario).forEach((idPedido) => {
            pedidosAplanados.push({
              id_pedido: idPedido,
              id_cliente: idUsuario,
              ...pedidosDelUsuario[idPedido],
            });
          });
        });
      }

      // Los ordenamos por fecha (los más nuevos primero)
      this.listaPedidosTotales = pedidosAplanados.sort(
        (a, b) => new Date(b.fecha).getTime() - new Date(a.fecha).getTime(),
      );
      this.cdr.detectChanges();
    });
  }

  editarProducto(p: Producto) {
    this.productoActual = { ...p };
    this.modoEdicion = true;
  }

  nuevoProducto() {
    this.productoActual = {
      nombre: '',
      categoria: 'Palas',
      precio: 0,
      stock: 0,
      descripcion: '',
      imagen: '',
    };
    this.modoEdicion = false;
  }

  guardarProducto() {
    if (!this.productoActual.nombre || this.productoActual.precio <= 0) {
      Swal.fire('Faltan datos', 'Pon un nombre y un precio válido', 'warning');
      return;
    }

    if (this.modoEdicion && this.productoActual.id) {
      this.gestorProductos
        .actualizarProducto(this.productoActual.id, this.productoActual)
        .then(() => {
          Swal.fire({
            title: '¡Actualizado!',
            icon: 'success',
            timer: 1500,
            showConfirmButton: false,
          });
          this.nuevoProducto();
        });
    } else {
      this.gestorProductos.crearProducto(this.productoActual).then(() => {
        Swal.fire({ title: '¡Creado!', icon: 'success', timer: 1500, showConfirmButton: false });
        this.nuevoProducto();
      });
    }
  }

  eliminarProducto(p: Producto) {
    Swal.fire({
      title: '¿Borrar producto?',
      text: `Vas a eliminar ${p.nombre} para siempre.`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, borrar',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed && p.id) {
        this.gestorProductos.eliminarProducto(p.id).then(() => {
          Swal.fire({ title: 'Borrado', icon: 'success', timer: 1500, showConfirmButton: false });
        });
      }
    });
  }
}
