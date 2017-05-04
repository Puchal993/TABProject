/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LekarzDAO;
import DAO.SpecjalizacjaDAO;
import DAO.VisitDAO;
import Model.Lekarz;
import Model.Visit;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lukasz
 */
@Named(value = "patientController")
@SessionScoped
public class PatientController implements Serializable {

    private int current, specId, visit;
    private Map<Integer, String> specMAP;
    private List<Lekarz> list;
    private List<Visit> myVisit;
    private String dat;
    private Visit visitD;

    public String visitDetail(int id) {
        for (Visit v : myVisit) {
            if (v.getId() == id) {
                visitD = new Visit();
                visitD = v;
            }
        }
        return "visitDetail.xhtml?faces-redirect=true";
    }

    public String bookVisit(int id) {
        VisitDAO visitDAO = new VisitDAO();
        visitDAO.add(current, id, dat);
        return "loggedUser.xhtml?faces-redirect=true";
    }

    public String chosseSpec() {
        LekarzDAO lekarzDAO = new LekarzDAO();
        list = lekarzDAO.getAllSpec(specId);
        return "bookVisit.xhtml?faces-redirect=true";
    }

    public List<Visit> getMyVisit() {
        VisitDAO visitDAO = new VisitDAO();
        myVisit = visitDAO.getVisit(current);
        return myVisit;
    }

    public void setMyVisit(List<Visit> myVisit) {
        this.myVisit = myVisit;
    }

    public Map<Integer, String> getSpecMAP() {
        SpecjalizacjaDAO specjalizacjaDAO = new SpecjalizacjaDAO();
        specMAP = specjalizacjaDAO.getAll();
        return specMAP;
    }

    public List<Lekarz> getList() {
        return list;
    }

    public void setList(List<Lekarz> list) {
        this.list = list;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public void setSpecMAP(Map<Integer, String> specMAP) {
        this.specMAP = specMAP;
    }

    public PatientController() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public Visit getVisitD() {
        return visitD;
    }

    public void setVisitD(Visit visitD) {
        this.visitD = visitD;
    }
    
    

}
