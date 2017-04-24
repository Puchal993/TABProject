/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Pacjent;
import Facade.PacjentFacade;
import Interface.PacjentFacadeLocal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Lukasz
 */
@Named(value="registerController")
@RequestScoped
public class registerController {
    
    private String name, lastname, login, pass, email, day, month, year;
    private int tel;
    private long pesel;
    private Date date;
    private StringBuilder sb = new StringBuilder();
    
    @EJB
    PacjentFacadeLocal pacjentEJB = new PacjentFacade();
    
    public String register() {
        try {
            sb.append(year);
            sb.append("/");
            sb.append(month);
            sb.append("/");
            sb.append(day);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
            date=dateFormat.parse(sb.toString());
            
            pacjentEJB.addPatient(date, tel, pesel, name, lastname, login, pass, email,sb.toString());
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), null));
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, date.toString(), null));
            return null;
        }
        return "index.xhtml?faces-redirect-true";
    }
    
    public registerController() {
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
    
    public int getTel() {
        return tel;
    }
    
    public void setTel(int tel) {
        this.tel = tel;
    }
    
    public long getPesel() {
        return pesel;
    }
    
    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public PacjentFacadeLocal getPacjentEJB() {
        return pacjentEJB;
    }
    
    public void setPacjentEJB(PacjentFacadeLocal pacjentEJB) {
        this.pacjentEJB = pacjentEJB;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public String getMonth() {
        return month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
}
