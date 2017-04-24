/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.TypBadania;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface TypBadaniaFacadeLocal {

    void create(TypBadania typBadania);

    void edit(TypBadania typBadania);

    void remove(TypBadania typBadania);

    TypBadania find(Object id);

    List<TypBadania> findAll();

    List<TypBadania> findRange(int[] range);

    int count();
    
}
