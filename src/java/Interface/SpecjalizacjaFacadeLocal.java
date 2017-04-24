/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Specjalizacja;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface SpecjalizacjaFacadeLocal {

    void create(Specjalizacja specjalizacja);

    void edit(Specjalizacja specjalizacja);

    void remove(Specjalizacja specjalizacja);

    Specjalizacja find(Object id);

    List<Specjalizacja> findAll();

    List<Specjalizacja> findRange(int[] range);

    int count();
    
}
