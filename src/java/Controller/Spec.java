/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import Model.Specjalizacja;
import DAO.SpecjalizacjaDAO;

/**
 *
 * @author Lukasz
 */
@Named(value = "spec")
@RequestScoped
public class Spec {

    private Specjalizacja spec = new Specjalizacja();
    private SpecjalizacjaDAO jdbc = new SpecjalizacjaDAO();

    public List<Specjalizacja> getAll() {
        List<Specjalizacja> list = jdbc.getAll();

        return list;
    }

    
    
    public Spec() {
    }

}
