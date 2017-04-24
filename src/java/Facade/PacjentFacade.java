/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.PacjentFacadeLocal;
import Interface.AbstractFacade;
import Entity.Pacjent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukasz
 */
@Stateless
public class PacjentFacade extends AbstractFacade<Pacjent> implements PacjentFacadeLocal {

    @PersistenceContext(unitName = "TABProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacjentFacade() {
        super(Pacjent.class);
    }

    @Override
    public Pacjent findByLogin(String username) {
        Query query = em.createNamedQuery("Pacjent.findByLogin");
        query.setParameter("login", username);
        return (Pacjent) query.getSingleResult();
    }
    
}
