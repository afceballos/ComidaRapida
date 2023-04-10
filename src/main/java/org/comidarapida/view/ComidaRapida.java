package org.comidarapida.view;

import org.comidarapida.models.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ComidaRapida {

    private List<Sucursal> sucursals = new ArrayList<>();

    public void Program() {

        List<Producto> productos1 = new ArrayList<>();
        List<Producto> productos2 = new ArrayList<>();
        List<Sucursal> sucursales = new ArrayList<>();
        List<Empleado> empleados = new ArrayList<>();
        Map<Producto, Integer> inventario = new HashMap<>();

        Gerente gerente1 = new Gerente(1, "Gerente 1", "gerente1@example.com", "123456");
        Gerente gerente2 = new Gerente(2, "Gerente 2", "gerente2@example.com", "654321");

        // Crear datos de ejemplo
        Sucursal sucursal1 = new Sucursal(1, "Sucursal 1","Colombia" , gerente1,empleados, inventario);
        Sucursal sucursal2 = new Sucursal(1, "Sucursal 1","Colombia" , gerente2,empleados, inventario);
        addSucursal(sucursal1);
        addSucursal(sucursal2);
        /*sucursales.add(sucursal1);
        sucursales.add(sucursal2);*/


        Empleado empleado1 = new Empleado(1, "Empleado 1", sucursal1, "preparador");
        Empleado empleado2 = new Empleado(2, "Empleado 2", sucursal2, "vendedor");

        Producto producto1 = new Producto(1, "Producto 1", 100.0, sucursal1);
        Producto producto2 = new Producto(2, "Producto 2", 200.0, sucursal2);



        Bodega bodega1 = new Bodega(1, "Bodega 1", productos1);
        bodega1.agregarProducto(producto1);
        bodega1.agregarProducto(producto2);

        Bodega bodega2 = new Bodega(2, "Bodega 2", productos2);
        bodega2.agregarProducto(producto1);
        bodega2.agregarProducto(producto2);

        Pedido pedido1 = new Pedido(1, empleado1, producto1, new Date(), 10, "pendiente");
        Pedido pedido2 = new Pedido(2, empleado2, producto2, new Date(), 5, "completado");

        Venta venta1 = new Venta(1, empleado1, producto1, new Date(), 10, 1000.0);
        Venta venta2 = new Venta(2, empleado2, producto2, new Date(), 5, 1000.0);

        // Mostrar opciones para operar con las entidades
        String[] opciones = {"Sucursal", "Gerente", "Empleado", "Producto", "Bodega", "Pedido", "Venta", "Reporte"};
        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "¿Qué entidad desea operar?", "Seleccione una opción",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    // Operaciones con Sucursal
                    String[] opcionesSucursal = {"Mostrar sucursales", "Crear nueva sucursal", "Buscar sucursal por ID", "Eliminar sucursal por ID"};

                    int seleccionSucursal = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?",
                            "Seleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opcionesSucursal, opcionesSucursal[0]);

                    switch (seleccionSucursal) {
                        case 0:
                            // Mostrar todas las sucursales
                            for (Sucursal sucursal: sucursales){
                                JOptionPane.showMessageDialog(null, "Sucursales " + sucursal.getId(), "Sucursales", JOptionPane.QUESTION_MESSAGE);
                            }
                            String mensajeSucursales = "";
                            mensajeSucursales += "sucursal 1" + "\n";
                            mensajeSucursales += "sucursal 2" + "\n";


                            break;
                        case 1:
                            // Crear nueva sucursal
                            String nombreSucursal = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nueva sucursal",
                                    "Crear nueva sucursal", JOptionPane.QUESTION_MESSAGE);

                            String direccionSucursal = JOptionPane.showInputDialog(null, "Ingrese la dirección de la nueva sucursal",
                                    "Crear nueva sucursal", JOptionPane.QUESTION_MESSAGE);


//                            JOptionPane.showMessageDialog(null, "Se ha creado la siguiente sucursal:\n\n" + nuevaSucursal.toString(),
//                                    "Crear nueva sucursal", JOptionPane.INFORMATION_MESSAGE);
                            break;

                        case 2:
                            // Buscar sucursal por ID
                            int idSucursal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la sucursal a buscar",
                                    "Buscar sucursal por ID", JOptionPane.QUESTION_MESSAGE));

//                            Sucursal sucursalEncontrada = Sucursal.buscarSucursal(idSucursal);

//                            if (sucursalEncontrada != null) {
//                                JOptionPane.showMessageDialog(null, "La sucursal encontrada es:\n\n" + sucursalEncontrada.toString(),
//                                        "Buscar sucursal por ID", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "No se encontró ninguna sucursal con el ID ingresado",
//                                        "Buscar sucursal por ID", JOptionPane.WARNING_MESSAGE);
//                            }
                            break;

                        case 3:
                            // Eliminar sucursal por ID
                            int idSucursalEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la sucursal a eliminar",
                                    "Eliminar sucursal por ID", JOptionPane.QUESTION_MESSAGE));

//                            boolean eliminado = Sucursal.eliminarSucursal(idSucursalEliminar);

//                            if (eliminado) {
//                                JOptionPane.showMessageDialog(null, "La sucursal ha sido eliminada correctamente",
//                                        "Eliminar sucursal por ID", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "No se encontró ninguna sucursal con el ID ingresado",
//                                        "Eliminar sucursal por ID", JOptionPane.WARNING_MESSAGE);
//                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 1:
                    // Operaciones con Gerente
                    String[] opcionesGerente = {"Mostrar gerentes", "Crear nuevo gerente", "Buscar gerente por ID", "Eliminar gerente por ID"};

                    int seleccionGerente = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?",
                            "Seleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opcionesGerente, opcionesGerente[0]);

                    switch (seleccionGerente) {
                        case 0:
                            // Mostrar todos los gerentes
                            String mensajeGerentes = "";
//                            for (Gerente gerente : Gerente.listaGerentes) {
//                                mensajeGerentes += gerente.toString() + "\n";
//                            }
                            JOptionPane.showMessageDialog(null, mensajeGerentes, "Gerentes", JOptionPane.INFORMATION_MESSAGE);
                            break;

                        case 1:
                            // Crear nuevo gerente
                            String nombreGerente = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo gerente",
                                    "Crear nuevo gerente", JOptionPane.QUESTION_MESSAGE);

                            String emailGerente = JOptionPane.showInputDialog(null, "Ingrese el email del nuevo gerente",
                                    "Crear nuevo gerente", JOptionPane.QUESTION_MESSAGE);

                            Gerente nuevoGerente = new Gerente(1, nombreGerente, "usergereten", "123");
                            JOptionPane.showMessageDialog(null, "Se ha creado el siguiente gerente:\n\n" + nuevoGerente.toString(),
                                    "Crear nuevo gerente", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            // Buscar gerente por ID
                            int idGerenteBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del gerente a buscar",
                                    "Buscar gerente por ID", JOptionPane.QUESTION_MESSAGE));

                            Gerente gerenteEncontrado = null;
//                            for (Gerente gerente : Gerente.listaGerentes) {
//                                if (gerente.getId() == idGerenteBuscar) {
//                                    gerenteEncontrado = gerente;
//                                    break;
//                                }
//                            }

                            if (gerenteEncontrado == null) {
                                JOptionPane.showMessageDialog(null, "No se ha encontrado ningún gerente con el ID " + idGerenteBuscar,
                                        "Buscar gerente por ID", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha encontrado el siguiente gerente:\n\n" + gerenteEncontrado.toString(),
                                        "Buscar gerente por ID", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case 3:
                            // Eliminar gerente por ID
                            int idGerenteEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del gerente a eliminar",
                                    "Eliminar gerente por ID", JOptionPane.QUESTION_MESSAGE));

                            boolean eliminado = false;
//                            for (Gerente gerente : Gerente.listaGerentes) {
//                                if (gerente.getId() == idGerenteEliminar) {
//                                    Gerente.listaGerentes.remove(gerente);
//                                    eliminado = true;
//                                    break;
//                                }
//                            }

                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Se ha eliminado el gerente con el ID " + idGerenteEliminar,
                                        "Eliminar gerente por ID", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha encontrado ningún gerente con el ID " + idGerenteEliminar,
                                        "Eliminar gerente por ID", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        default:
                            break;
                    }

                }
            }
        }

        public void addSucursal(Sucursal sucursal){
        try {
            Connection connection = loginController.conectar();
            String query = "INSERT INTO Sucursal (ciudad, pais, gerente, empleados, inventario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, sucursal.getCiudad());
            statement.setString(2, sucursal.getPais());
            statement.setString(3, sucursal.getGerente().toString());
            statement.setString(4, sucursal.getEmpleados().toString());
            statement.setString(5, sucursal.getInventario().toString());
            statement.executeUpdate();
            loginController.desconectar();
            System.out.println("Sucursal " + sucursal.getId() + " agregada a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al agregar la sucursal a la base de datos: " + e.getMessage());
        }
        }


}

