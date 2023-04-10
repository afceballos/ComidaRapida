package org.comidarapida.models;

import org.comidarapida.enums.Rol;

public class Usuarios {

    private String name, username, password;
    private Rol rol;

    public Usuarios(String name, String username, String password, Rol rol) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}
