/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.PrzepisaneLeki;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface PrzepisaneLekiFacadeLocal {

    void create(PrzepisaneLeki przepisaneLeki);

    void edit(PrzepisaneLeki przepisaneLeki);

    void remove(PrzepisaneLeki przepisaneLeki);

    PrzepisaneLeki find(Object id);

    List<PrzepisaneLeki> findAll();

    List<PrzepisaneLeki> findRange(int[] range);

    int count();
    
}
