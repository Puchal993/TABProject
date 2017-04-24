/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.AbstractFacade;
import Interface.PrzepisaneLekiFacadeLocal;
import Entity.PrzepisaneLeki;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lukasz
 */
@Stateless
public class PrzepisaneLekiFacade extends AbstractFacade<PrzepisaneLeki> implements PrzepisaneLekiFacadeLocal {

    @PersistenceContext(unitName = "TABProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrzepisaneLekiFacade() {
        super(PrzepisaneLeki.class);
    }
    
}
