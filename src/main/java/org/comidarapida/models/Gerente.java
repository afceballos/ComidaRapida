package org.comidarapida.models;

import java.util.Date;

public class Gerente {
    private int id;
    private String nombre;
    private String usuario;
    private String contrasena;

    public Gerente(int id, String nombre, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        return (this.usuario.equals(usuario) && this.contrasena.equals(contrasena));
    }

    public void agregarProductoSucursal(Sucursal sucursal, Producto producto, int cantidad) {
        sucursal.agregarProducto(producto, cantidad);
    }

    public void modificarProductoSucursal(Sucursal sucursal, Producto producto, int cantidad) {
        sucursal.modificarProducto(producto, cantidad);
    }

    public void eliminarProductoSucursal(Sucursal sucursal, Producto producto) {
        sucursal.eliminarProducto(producto);
    }

    public void generarReporteVentasSucursal(Sucursal sucursal, Date fechaInicio, Date fechaFin) {
        sucursal.generarReporteVentas(fechaInicio, fechaFin);
    }

//    public void compararVentasSucursal(Sucursal sucursal, Sucursal otraSucursal, Date fechaInicio, Date fechaFin) {
//        double ventasSucursal = sucursal.generarReporteVentas(fechaInicio, fechaFin);
//        double ventasOtraSucursal = otraSucursal.generarReporteVentas(fechaInicio, fechaFin);
//        System.out.println("Ventas de " + sucursal.getCiudad() + ": $" + ventasSucursal);
//        System.out.println("Ventas de " + otraSucursal.getCiudad() + ": $" + ventasOtraSucursal);
//        if (ventasSucursal > ventasOtraSucursal) {
//            System.out.println(sucursal.getCiudad() + " tuvo mayor cantidad de ventas.");
//        } else if (ventasSucursal < ventasOtraSucursal) {
//            System.out.println(otraSucursal.getCiudad() + " tuvo mayor cantidad de ventas.");
//        } else {
//            System.out.println("Ambas sucursales tuvieron la misma cantidad de ventas.");
//        }
//    }
}

