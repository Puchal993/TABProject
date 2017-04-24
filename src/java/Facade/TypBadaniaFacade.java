/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.TypBadaniaFacadeLocal;
import Interface.AbstractFacade;
import Entity.TypBadania;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lukasz
 */
@Stateless
public class TypBadaniaFacade extends AbstractFacade<TypBadania> implements TypBadaniaFacadeLocal {

    @PersistenceContext(unitName = "TABProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypBadaniaFacade() {
        super(TypBadania.class);
    }
    
}
