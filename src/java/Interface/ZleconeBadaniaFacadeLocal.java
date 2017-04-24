/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.ZleconeBadania;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukasz
 */
@Local
public interface ZleconeBadaniaFacadeLocal {

    void create(ZleconeBadania zleconeBadania);

    void edit(ZleconeBadania zleconeBadania);

    void remove(ZleconeBadania zleconeBadania);

    ZleconeBadania find(Object id);

    List<ZleconeBadania> findAll();

    List<ZleconeBadania> findRange(int[] range);

    int count();
    
}
