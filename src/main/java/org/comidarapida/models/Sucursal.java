package org.comidarapida.models;

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

