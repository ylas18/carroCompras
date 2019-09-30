/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Entity.Producto;
import a.com.Entity.Venta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yesid
 */
@Named(value = "controllerVentaSession")
@SessionScoped
public class ControllerVentaSession implements Serializable {
    
    private Producto producto = new Producto();
    private int cantidad;
    private List<Venta> listaVenta = new ArrayList();
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public List<Venta> getListaVenta() {
        return listaVenta;
    }
    
    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }
    
    public void AgregarAlCarrito() {
        Venta venta = new Venta();
        venta.setCantidad(cantidad);
        venta.setIdProducto(producto);
        this.listaVenta.add(venta);
        System.out.println("ENtre a agregar");
        
    }
    
    public ControllerVentaSession() {
        
    }
    
}
