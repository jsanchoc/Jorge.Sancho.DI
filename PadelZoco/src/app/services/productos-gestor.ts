import { Injectable, inject } from '@angular/core';
import { Database, ref, listVal, push, set, update, remove } from '@angular/fire/database';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root',
})
export class ProductosGestor {
  private db = inject(Database);

  // 1. Leer todo el catálogo (esta ya la tenías)
  getAllProductos() {
    const productosRef = ref(this.db, 'productos');
    return listVal<Producto>(productosRef, { keyField: 'id' });
  }

  // 2. NUEVO: Crear un producto
  crearProducto(producto: Producto) {
    const productosRef = ref(this.db, 'productos');
    const nuevoProductoRef = push(productosRef); // Genera un ID único automático
    return set(nuevoProductoRef, producto);
  }

  // 3. NUEVO: Modificar un producto existente
  actualizarProducto(id: string, producto: Producto) {
    const productoRef = ref(this.db, `productos/${id}`);
    // Le quitamos el ID al objeto antes de guardarlo para no duplicar datos
    const { id: _, ...datosLimpios } = producto as any;
    return update(productoRef, datosLimpios);
  }

  // 4. NUEVO: Borrar un producto para siempre
  eliminarProducto(id: string) {
    const productoRef = ref(this.db, `productos/${id}`);
    return remove(productoRef);
  }
}
