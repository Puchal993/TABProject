/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Pacjent;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface PacjentFacadeLocal {

    void create(Pacjent pacjent);

    void edit(Pacjent pacjent);

    void remove(Pacjent pacjent);

    Pacjent find(Object id);

    List<Pacjent> findAll();

    List<Pacjent> findRange(int[] range);

    int count();

    public Pacjent findByLogin(String username);

    public void addPatient(Date date, int tel, long pesel, String... s);

  
    
}
