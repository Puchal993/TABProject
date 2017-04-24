/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Wizyta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface WizytaFacadeLocal {

    void create(Wizyta wizyta);

    void edit(Wizyta wizyta);

    void remove(Wizyta wizyta);

    Wizyta find(Object id);

    List<Wizyta> findAll();

    List<Wizyta> findRange(int[] range);

    int count();
    
}
