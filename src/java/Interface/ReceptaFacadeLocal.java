/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Recepta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface ReceptaFacadeLocal {

    void create(Recepta recepta);

    void edit(Recepta recepta);

    void remove(Recepta recepta);

    Recepta find(Object id);

    List<Recepta> findAll();

    List<Recepta> findRange(int[] range);

    int count();
    
}
