/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AdminDAO;
import DAO.LekarzDAO;
import DAO.PacjentDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lukasz
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String username, pass;
    private final int NO_USER = -1;
    private int currentUser = -1;

    public LoginController() {
    }

    public String log() {
        PacjentDAO pacjentDAO = new PacjentDAO();
        LekarzDAO lekarzDAO = new LekarzDAO();
        AdminDAO adminDAO = new AdminDAO();

        currentUser = pacjentDAO.findByLogin(username);
        if (currentUser == NO_USER) {
            currentUser = lekarzDAO.findByLogin(username);
        }
        if (currentUser == NO_USER) {
            currentUser = adminDAO.findByLogin(username);
        }
        if (currentUser != -1) {
            if (pacjentDAO.isPassCorect(currentUser, pass)) {

                return "loggedUser.xhtml?faces-redirect=true";

            }
            if (lekarzDAO.isPassCorect(currentUser, pass)) {
                return "llog.xhtml?faces-redirect=true";
            }
            if (adminDAO.isPassCorect(currentUser, pass)) {
                return "ladmin.xhtml?faces-redirect=true";
            }
        }
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Zły login lub hasło", null));
        return null;
    }

    public String logIn() {
        //     Pacjent pacjent;
        try {
            // pacjent = pacjentEJB.findByLogin(this.username);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("loginForm:login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Zły login", null));
            return null;
        }

        /* if (pacjent != null) {
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
        this.pass = pass;*/
        return null;
    }

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

    public int getCurrentUser() {
        return currentUser;
    }

}
