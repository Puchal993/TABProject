/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Interface.PacjentFacadeLocal;
import Interface.AbstractFacade;
import Entity.Pacjent;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

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

    public void addPatient(Date date, int tel, long pesel, String... s) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("add_patient");
        query.registerStoredProcedureParameter("imie", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nazwisko", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("login", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("haslo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("telefon", int.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("pesel", long.class, ParameterMode.IN);

         query.registerStoredProcedureParameter("data_urodzenia", String.class, ParameterMode.IN);
        query.setParameter("imie", s[0]);
        query.setParameter("nazwisko", s[1]);
        query.setParameter("login", s[2]);
        query.setParameter("haslo", s[3]);
        query.setParameter("email", s[4]);
        query.setParameter("telefon", tel);
        query.setParameter("pesel", pesel);
         query.setParameter("data_urodzenia", s[5]);
        query.execute();
    }

}
