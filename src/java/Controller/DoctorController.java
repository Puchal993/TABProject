/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VisitDAO;
import Model.Visit;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Lukasz
 */
@Named(value = "doctorController")
@SessionScoped
public class DoctorController implements Serializable {
    
    private int current, diagnosed;
    private List<Visit> listV;
    private String diagnose;
    
    public String start(int idP) {
        diagnosed = idP;
        return "diagnose.xhtml?faces-redirect=true";
    }
    
    public String end() {
        VisitDAO visitDAO = new VisitDAO();
        visitDAO.addDiagnose(diagnosed, diagnose);
        return "doctorPanel.xhtml?faces-redirect=true";
    }
    
    public String getDiagnose() {
        return diagnose;
    }
    
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
    
    public int getCurrent() {
        return current;
    }
    
    public void setCurrent(int current) {
        this.current = current;
    }
    
    public List<Visit> getListV() {
        VisitDAO visitDAO = new VisitDAO();
        listV = visitDAO.getDVisit(current);
        return listV;
    }
    
    public void setListV(List<Visit> listV) {
        this.listV = listV;
    }
    
    public int getDiagnosed() {
        return diagnosed;
    }
    
    public void setDiagnosed(int diagnosed) {
        this.diagnosed = diagnosed;
    }

    /**
     * Creates a new instance of DoctorController
     */
    public DoctorController() {
        
    }
    
}
