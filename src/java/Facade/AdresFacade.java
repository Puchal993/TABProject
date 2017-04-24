/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.AbstractFacade;
import Interface.AdresFacadeLocal;
import Entity.Adres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lukasz
 */
@Stateless
public class AdresFacade extends AbstractFacade<Adres> implements AdresFacadeLocal {

    @PersistenceContext(unitName = "TABProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdresFacade() {
        super(Adres.class);
    }
    
}
