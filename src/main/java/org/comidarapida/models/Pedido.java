package org.comidarapida.models;

import java.util.Date;

public class Pedido {
    private int id;
    private Empleado empleado;
    private Producto producto;
    private Date fecha;
    private int cantidad;
    private String estado;

    public Pedido(int id, Empleado empleado, Producto producto, Date fecha, int cantidad, String estado) {
        this.id = id;
        this.empleado = empleado;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", empleado=" + empleado + ", producto=" + producto + ", fecha=" + fecha
                + ", cantidad=" + cantidad + ", estado=" + estado + "]";
    }
}

