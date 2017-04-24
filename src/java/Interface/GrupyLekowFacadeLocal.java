/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.GrupyLekow;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface GrupyLekowFacadeLocal {

    void create(GrupyLekow grupyLekow);

    void edit(GrupyLekow grupyLekow);

    void remove(GrupyLekow grupyLekow);

    GrupyLekow find(Object id);

    List<GrupyLekow> findAll();

    List<GrupyLekow> findRange(int[] range);

    int count();
    
}
