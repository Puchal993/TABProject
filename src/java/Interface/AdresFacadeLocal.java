/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Adres;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface AdresFacadeLocal {

    void create(Adres adres);

    void edit(Adres adres);

    void remove(Adres adres);

    Adres find(Object id);

    List<Adres> findAll();

    List<Adres> findRange(int[] range);

    int count();
    
}
