package org.comidarapida.models;

import java.util.Date;

public class Venta {
    private int id;
    private Empleado empleado;
    private Producto producto;
    private Date fecha;
    private int cantidad;
    private double precioTotal;

    public Venta(int id, Empleado empleado, Producto producto, Date fecha, int cantidad, double precioTotal) {
        this.id = id;
        this.empleado = empleado;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Venta [id=" + id + ", empleado=" + empleado + ", producto=" + producto + ", fecha=" + fecha
                + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal + "]";
    }
}

