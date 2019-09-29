/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Yesid
 */
@Entity
@Table
public class Cliente implements Serializable {

    @Id
    private int id_cliente;
    @Column
    private String nombre;
    @Column
    private String username;
    @Column
    private String pass;
    @Column
    private int rol;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String username, String pass, int rol) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.username = username;
        this.pass = pass;
        this.rol = rol;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

}
