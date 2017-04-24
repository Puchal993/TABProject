/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Lekarz;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface LekarzFacadeLocal {

    void create(Lekarz lekarz);

    void edit(Lekarz lekarz);

    void remove(Lekarz lekarz);

    Lekarz find(Object id);

    List<Lekarz> findAll();

    List<Lekarz> findRange(int[] range);

    int count();
    
}
