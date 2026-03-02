import { Injectable, inject } from '@angular/core';
import { Database, ref, push, set, listVal, objectVal } from '@angular/fire/database'; // <-- Añadimos objectVal
import { Auth } from '@angular/fire/auth';

@Injectable({
  providedIn: 'root',
})
export class PedidosGestor {
  private db = inject(Database);
  private auth = inject(Auth);

  crearPedido(items: any[], total: number) {
    const user = this.auth.currentUser;
    if (user) {
      const pedido = {
        fecha: new Date().toISOString(),
        productos: items,
        total: total,
        estado: 'Completado',
      };
      const pedidosRef = ref(this.db, `pedidos/${user.uid}`);
      const nuevoPedidoRef = push(pedidosRef);
      return set(nuevoPedidoRef, pedido);
    }
    return Promise.reject('Debes estar logueado');
  }

  getPedidos() {
    const user = this.auth.currentUser;
    const pedidosRef = ref(this.db, `pedidos/${user?.uid}`);
    return listVal<any>(pedidosRef, { keyField: 'id_pedido' });
  }

  // 👇 NUEVA FUNCIÓN PARA EL ADMIN 👇
  getAllPedidosAdmin() {
    const pedidosRef = ref(this.db, 'pedidos');
    // objectVal nos trae todo el JSON entero con todos los clientes
    return objectVal<any>(pedidosRef);
  }
}
