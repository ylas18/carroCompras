/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Bean.ProductoFacadeLocal;
import a.com.Entity.Cliente;
import a.com.Entity.Producto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Bean en cual se encarga de la session del Cliente
 *
 * @author Yesid
 */
@Named(value = "controllerClie")
@SessionScoped
public class ControllerClie implements Serializable {

    /**
     * Objeto persona el cual se usa para la validacion del usuario en el
     * sistema
     */
    private Cliente clie;
    private int cant;
    private List<Producto> listaProductos;
    private ControllerProductoSession productoSession;

    private Producto seleccionarProducto;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;

    @PostConstruct
    public void init() {
        clie = new Cliente();

        // productoDto = new ProductoDto();
    }

    public void listar(String valor) throws Exception {
        System.out.println("Entre al metodo listar");
        System.out.println(valor);
        try {
            if (valor.equals("F")) {
                System.out.println("entre a medio");

                listaProductos = productoFacadeLocal.findAll();
                System.out.println("Entre");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    private boolean isPostBack() {
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        System.out.println(rpta);
        return rpta;
    }

    /**
     * Metodo que valida la session del Cliente. Si esta activa o inactiva
     *
     * @return Retorna un String que lleva el nombre de la pagina a la cual se
     * redirige el sistema
     */
    public String validarSession() {
        String redireccion = "cliente";
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        try {
            clie = (Cliente) session.getAttribute("usuario");
            System.out.println("entro al cliente");

        } catch (Exception e) {
        }

        if (clie == null) {
            try {
                ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ControllerClie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(redireccion);
        return redireccion;
    }

    /**
     * Metodo el cual se encarga de destruir la session y redirigir
     *
     * @return Retorna un String con el nombre de la pagina a la caul se va a
     * redirigir
     */
    public String cerrarSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        System.out.println("Session terminada");
        return "index";

    }

    public void anadirCarrito() {

    }

    public ControllerClie() {
    }

    public Cliente getClie() {
        return clie;
    }

    public void setClie(Cliente clie) {
        this.clie = clie;
    }

    public ProductoFacadeLocal getProductoFacadeLocal() {
        return productoFacadeLocal;
    }

    public void setProductoFacadeLocal(ProductoFacadeLocal productoFacadeLocal) {
        this.productoFacadeLocal = productoFacadeLocal;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Producto getSeleccionarProducto() {
        return seleccionarProducto;
    }

    public void setSeleccionarProducto(Producto seleccionarProducto) {
        this.seleccionarProducto = seleccionarProducto;
    }

}
