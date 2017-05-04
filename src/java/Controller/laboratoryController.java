/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Typ_badaniaDAO;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Lukasz
 */
@Named(value = "laboratoryController")
@RequestScoped
public class laboratoryController {

    private Map<Integer, String> map;

    public laboratoryController() {
        Typ_badaniaDAO typ_badaniaDAO = new Typ_badaniaDAO();
        map = typ_badaniaDAO.getAll();
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    
}
