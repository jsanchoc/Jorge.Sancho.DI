import { Component, inject, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Producto } from '../../model/producto';
import { ProductosGestor } from '../../services/productos-gestor';
import { CarritoGestor } from '../../services/carrito-gestor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './list.html',
})
export class List implements OnInit {
  listaProductos: Producto[] = [];
  cargando: boolean = true;

  // Filtros
  filtroNombre: string = '';
  filtroCategoria: string = ''; // <-- Añadido de nuevo

  private gestor = inject(ProductosGestor);
  private carritoService = inject(CarritoGestor);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit() {
    this.gestor.getAllProductos().subscribe({
      next: (data) => {
        this.listaProductos = data || [];
        this.cargando = false;
        this.cdr.detectChanges();
      },
      error: (e) => {
        console.error('Error cargando productos', e);
        this.cargando = false;
        this.cdr.detectChanges();
      },
    });
  }

  // Ahora filtra por nombre Y por categoría
  get productosVisibles() {
    return this.listaProductos.filter((p) => {
      const nombre = p.nombre ? p.nombre.toLowerCase() : '';
      const coincideNombre = nombre.includes(this.filtroNombre.toLowerCase());
      const coincideCat = this.filtroCategoria === '' || p.categoria === this.filtroCategoria;
      return coincideNombre && coincideCat;
    });
  }

  agregarAlCarrito(p: Producto) {
    if (p.stock <= 0) {
      Swal.fire('Agotado', 'Este producto no tiene stock actualmente', 'warning');
      return;
    }

    this.carritoService
      .agregarAlCarrito(p)
      .then(() => {
        Swal.fire({
          title: '¡Añadido!',
          text: `${p.nombre} añadido al carrito`,
          icon: 'success',
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 1500,
        });
      })
      .catch(() => {
        Swal.fire('Error', 'Debes iniciar sesión para comprar', 'error');
      });
  }
}
