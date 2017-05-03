/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LekarzDAO;
import Model.Lekarz;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Lukasz
 */
@Named(value = "adminController")
@RequestScoped
public class AdminController {

    private String name, lastname, login, pass, email, data;
    private long pesel, pwz;
    private int tel;
    private List<Lekarz> list;

    LekarzDAO lekarzDAO = new LekarzDAO();

    public List<Lekarz> getAll() {
        list = lekarzDAO.getAll();
        return list;
    }

    public void addDoctor() {

    //    lekarzDAO.add(tel, pesel, pwz, name, lastname, login, pass, email, data);
    }

    public AdminController() {
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

    public LekarzDAO getLekarzDAO() {
        return lekarzDAO;
    }

    public void setLekarzDAO(LekarzDAO lekarzDAO) {
        this.lekarzDAO = lekarzDAO;
    }

}
