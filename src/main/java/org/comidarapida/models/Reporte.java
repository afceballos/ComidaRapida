package org.comidarapida.models;

import java.time.LocalDate;

public class Reporte {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Sucursal sucursal;
    private String tipo; // puede ser "ventas" o "gastos"
    private double cantidad;

    // Constructor
    public Reporte(int id, LocalDate fechaInicio, LocalDate fechaFin, Sucursal sucursal, String tipo, double cantidad) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sucursal = sucursal;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}

