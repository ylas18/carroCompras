/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Entity.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

    public ControllerClie() {
    }

}
