/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Pacjent;
import Facade.PacjentFacade;
import Interface.PacjentFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lukasz
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {

    private String username, pass;

    @EJB
    PacjentFacadeLocal pacjentEJB = new PacjentFacade();

    private Pacjent pacjent;

    public LoginController() {
    }

    public String logIn() {
        Pacjent pacjent;
        try {
            pacjent = pacjentEJB.findByLogin(this.username);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Zły login", null));
            return null;
        }

        if (pacjent != null) {
            if (pacjent.getHaslo().equals(this.pass)) {
                this.pacjent = pacjent;
                return "index.xhtml?faces-redirect-true";
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("loginForm:haslo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Złe hasło", null));
                return null;
            }
        } else {
            return null;
        }
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public boolean isLogged(){
    return pacjent!=null;}
    
    public String logout(){
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "index.xhtml?faces-redirect=true";}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
 
    
    
}
