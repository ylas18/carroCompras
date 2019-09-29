/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Dto;

/**
 *
 * @author Yesid
 */
public class ClienteDto {

    private int id_cliente;
    private String nombre;
    private String username;
    private String pass;
    private int rol;

    public ClienteDto() {
    }

    public ClienteDto(int id_cliente, String nombre, String username, String pass, int rol) {
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
