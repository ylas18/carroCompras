/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Bean;

import a.com.Entity.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yesid
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {
    @PersistenceContext(unitName = "a.com_carroCompras-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
}
