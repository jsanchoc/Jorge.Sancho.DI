import { Injectable, inject } from '@angular/core';
import { Database, ref, push, set, listVal, remove, update } from '@angular/fire/database';
import { Auth } from '@angular/fire/auth';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root',
})
export class CarritoGestor {
  private db = inject(Database);
  private auth = inject(Auth);

  // 1. Añadir al carrito (con cantidad por defecto)
  agregarAlCarrito(producto: Producto) {
    const user = this.auth.currentUser;
    if (user) {
      const carritoRef = ref(this.db, `carritos/${user.uid}`);
      const nuevoItemRef = push(carritoRef);
      // Le añadimos la propiedad 'cantidad' a 1
      return set(nuevoItemRef, { ...producto, cantidad: 1 });
    }
    return Promise.reject('No logueado');
  }

  // 2. Obtener los productos
  getCarrito() {
    const user = this.auth.currentUser;
    const carritoRef = ref(this.db, `carritos/${user?.uid}`);
    // Usamos 'id_en_carrito' para guardar la clave única de Firebase
    return listVal<any>(carritoRef, { keyField: 'id_en_carrito' });
  }

  // 3. Vaciar todo (para cuando se finaliza la compra)
  vaciarCarrito() {
    const user = this.auth.currentUser;
    const carritoRef = ref(this.db, `carritos/${user?.uid}`);
    return remove(carritoRef);
  }

  // 4. NUEVO: Borrar un solo producto
  eliminarItem(idItemCarrito: string) {
    const user = this.auth.currentUser;
    if (user) {
      const itemRef = ref(this.db, `carritos/${user.uid}/${idItemCarrito}`);
      return remove(itemRef);
    }
    return Promise.resolve();
  }

  // 5. NUEVO: Actualizar la cantidad (+ o -)
  actualizarCantidad(idItemCarrito: string, nuevaCantidad: number) {
    const user = this.auth.currentUser;
    if (user && nuevaCantidad > 0) {
      const itemRef = ref(this.db, `carritos/${user.uid}/${idItemCarrito}`);
      return update(itemRef, { cantidad: nuevaCantidad });
    }
    return Promise.resolve();
  }
}
