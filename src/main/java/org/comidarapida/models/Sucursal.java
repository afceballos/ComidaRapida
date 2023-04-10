package org.comidarapida.models;

import org.comidarapida.view.loginController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Sucursal {
    private int id;
    private String ciudad;
    private String pais;
    private Gerente gerente;
    private List<Empleado> empleados;
    private Map<Producto, Integer> inventario;

    public Sucursal(int id, String ciudad, String pais, Gerente gerente, List<Empleado> empleados, Map<Producto, Integer> inventario) {
        this.id = id;
        this.ciudad = ciudad;
        this.pais = pais;
        this.gerente = gerente;
        this.empleados = empleados;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public Map<Producto, Integer> getInventario() {
        return inventario;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (inventario.containsKey(producto)) {
            inventario.put(producto, inventario.get(producto) + cantidad);
            try {
                Connection connection = loginController.conectar();
                String query = "INSERT INTO Producto (nombre, precio, sucursal) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, producto.getNombre());
                statement.setDouble(2, producto.getPrecio());
                statement.setInt(3, producto.getSucursal().getId());
                statement.executeUpdate();
                loginController.desconectar();
                System.out.println("Producto " + producto.getNombre() + " agregada a la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al agregar el producto a la base de datos: " + e.getMessage());
            }
        } else {
            inventario.put(producto, cantidad);
        }
    }

    public void modificarProducto(Producto producto, int cantidad) {
        if (inventario.containsKey(producto)) {
            inventario.put(producto, cantidad);
        }
    }

    public void eliminarProducto(Producto producto) {
        inventario.remove(producto);
        try {
            Connection conexion = loginController.conectar();
            String query = "DELETE FROM productos WHERE nombre=?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, producto.getNombre());
            statement.executeUpdate();
            loginController.desconectar();
            System.out.println("Producto " + producto.getNombre() + " eliminado de la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto de la base de datos: " + e.getMessage());
        }
    }

    public Reporte generarReporteVentas(Date fechaInicio, Date fechaFin) {
        // Lógica para generar el reporte de ventas en el rango de fechas determinado
        return null;
    }

    public Reporte compararVentas(Sucursal otraSucursal, Date fechaInicio, Date fechaFin) {
        // Lógica para comparar las ventas de la sucursal actual con las de otra sucursal en el rango de fechas determinado
        return null;
    }

}

