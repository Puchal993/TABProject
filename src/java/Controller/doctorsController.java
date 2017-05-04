/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LekarzDAO;
import DAO.SpecjalizacjaDAO;
import Model.Lekarz;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Lukasz
 */
@Named(value = "doctorsController")
@RequestScoped
public class doctorsController {

    private List<Lekarz> list;
    private Map<Integer, String> specMAP;

    public doctorsController() {
        LekarzDAO lekarzDAO = new LekarzDAO();
        SpecjalizacjaDAO specjalizacjaDAO = new SpecjalizacjaDAO();
        list = lekarzDAO.getWorking();
        specMAP = specjalizacjaDAO.getAll();
    }

    public List<Lekarz> getList() {
        return list;
    }

    public String docSpec(int i) {

        return specMAP.get(i);
    }

}
