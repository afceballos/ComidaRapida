package org.comidarapida.enums;

import org.comidarapida.models.Usuarios;

public enum Rol {

    EMPLEADO(1, "Empleado"),
    GERENTE(2, "Gerente");

    Rol(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public static Rol getById(int id){
        for (Rol rols: Rol.values()){
            if (rols.id == id){
                return rols;
            }
        }
        return EMPLEADO;
    }

    private int id;
    private String nombre;

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
}
