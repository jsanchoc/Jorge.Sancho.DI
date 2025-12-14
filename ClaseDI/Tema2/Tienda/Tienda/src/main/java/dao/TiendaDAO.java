package dao;

import modelo.Producto;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaDAO {


    public Usuario validarLogin(String correo, String password) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setPassword(rs.getString("password"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al validar login: " + e.getMessage());
        }
        return usuario;
    }

    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }
        return lista;
    }
}