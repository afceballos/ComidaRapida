package org.comidarapida.models;

public class Empleado {
    private int id;
    private String nombre;
    private Sucursal sucursal;
    private String rol;

    public Empleado(int id, String nombre, Sucursal sucursal, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.rol = rol;
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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sucursal=" + sucursal +
                ", rol='" + rol + '\'' +
                '}';
    }
}

