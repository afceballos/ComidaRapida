package org.comidarapida.models;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private Sucursal sucursal;

    public Producto(int id, String nombre, double precio, Sucursal sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", sucursal=" + sucursal +
                '}';
    }
}

