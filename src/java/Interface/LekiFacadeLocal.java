/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Leki;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface LekiFacadeLocal {

    void create(Leki leki);

    void edit(Leki leki);

    void remove(Leki leki);

    Leki find(Object id);

    List<Leki> findAll();

    List<Leki> findRange(int[] range);

    int count();
    
}
