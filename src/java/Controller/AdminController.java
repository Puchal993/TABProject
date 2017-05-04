/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LekarzDAO;
import DAO.SpecjalizacjaDAO;
import Model.Lekarz;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lukasz
 */
@Named(value = "adminController")
@RequestScoped
public class AdminController {

    private String name, lastname, login, pass, email, data,controll;
    private long pesel, pwz;
    private int tel, spec = -1;
    private List<Lekarz> list,listW;
   // private Map<Integer, Lekarz> map;
    private Map<Integer, String> specMAP;
    private final String DELETE="ZWOLNIJ";
    
    LekarzDAO lekarzDAO = new LekarzDAO();

    public List<Lekarz> getAll() {
        
        return list;
    }

    public String docSpec(int i){
    
    return specMAP.get(i);}
    
    public void fire(int i){
         LocalDate ld = LocalDate.now();
        
       

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
       
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        lekarzDAO.fire(i, dtf.format(ld));
        listW = lekarzDAO.getWorking();
    }
    
    public Map<Integer, String> getSpecMAP() {

        return specMAP;
    }

    public void setSpecMAP(Map<Integer, String> specMAP) {
        this.specMAP = specMAP;
    }

    public int getSpec() {
        return spec;
    }

    public void setSpec(int spec) {
        this.spec = spec;
    }

    

    public void addDoctor() {

        if (spec != -1) {
            lekarzDAO.add(spec, tel, pesel, pwz, name, lastname, login, pass, email, data);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dodano lekarza " + name + " " + lastname, null));
            spec = -1;
            tel = 0;
            pesel = 0;
            pwz = 0;
            name = lastname = login = pass = email = data = null;

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Musisz wybrać specjalizację", null));
        }
    }

    public AdminController() {
        SpecjalizacjaDAO specDAO = new SpecjalizacjaDAO();
        specMAP = specDAO.getAll();
        list = lekarzDAO.getAll();
        listW = lekarzDAO.getWorking();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public long getPwz() {
        return pwz;
    }

    public void setPwz(long pwz) {
        this.pwz = pwz;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public List<Lekarz> getList() {
        return list;
    }

    public void setList(List<Lekarz> list) {
        this.list = list;
    }

    public List<Lekarz> getListW() {
        return listW;
    }

    public void setListW(List<Lekarz> listW) {
        this.listW = listW;
    }

    public LekarzDAO getLekarzDAO() {
        return lekarzDAO;
    }

    public void setLekarzDAO(LekarzDAO lekarzDAO) {
        this.lekarzDAO = lekarzDAO;
    }

    public String getDELETE() {
        return DELETE;
    }

    public void setControll(String controll) {
        this.controll = controll;
    }
    
    
    
}
