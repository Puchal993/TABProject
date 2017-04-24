/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Opinia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface OpiniaFacadeLocal {

    void create(Opinia opinia);

    void edit(Opinia opinia);

    void remove(Opinia opinia);

    Opinia find(Object id);

    List<Opinia> findAll();

    List<Opinia> findRange(int[] range);

    int count();
    
}
