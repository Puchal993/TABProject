/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.AbstractFacade;
import Interface.GrupyLekowFacadeLocal;
import Entity.GrupyLekow;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lukasz
 */
@Stateless
public class GrupyLekowFacade extends AbstractFacade<GrupyLekow> implements GrupyLekowFacadeLocal {

    @PersistenceContext(unitName = "TABProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupyLekowFacade() {
        super(GrupyLekow.class);
    }
    
}
