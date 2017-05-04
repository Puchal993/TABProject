/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBAccess;
import Model.Lekarz;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lukasz
 */
public class LekarzDAO {

    public boolean isPassCorect(int id, String pass) {
        String query = "select id from lekarz where haslo='" + pass
                + "' and id=" + id;
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();
            System.out.println(query);
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                if (rs.getInt(1) == id) {
                    return true;
                }
            }

        } catch (Exception e) {
        }
        return false;
    }

    public int findByLogin(String login) {
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(login);
            sb.append("'");
            String query = "select id from lekarz where login=" + sb.toString();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public void add(int spec, int tel, long pesel, long pwz, String... s) {
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call add_doc(?,?,?,?,?,?,?,?,?,?)");

            cs.setString(1, s[0]);
            cs.setString(2, s[1]);
            cs.setString(3, s[2]);
            cs.setString(4, s[3]);
            cs.setString(5, s[4]);

            cs.setInt(6, tel);
            cs.setLong(7, pwz);
            cs.setLong(8, pesel);

            cs.setString(9, s[5]);
            cs.setInt(10, spec);
            cs.execute();
            cs.close();
        } catch (SQLException ex) {

        }
    }

    public List<Lekarz> getAll() {
        List<Lekarz> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement statement = conn.createStatement();

            String query = "select * from lekarz";
            Lekarz lekarz;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                lekarz = new Lekarz();
                lekarz.setId(rs.getInt(1));
                lekarz.setName(rs.getString(2));
                lekarz.setLastname(rs.getString(3));
                lekarz.setLogin(rs.getString(4));
                lekarz.setPass(rs.getString(5));
                lekarz.setEmail(rs.getString(6));
                lekarz.setTel(rs.getInt(7));
                lekarz.setPwz(rs.getLong(8));
                lekarz.setPesel(rs.getLong(9));
                lekarz.setScore(rs.getBigDecimal(10));
                lekarz.setDat(rs.getDate(11));
                lekarz.setDatZ(rs.getDate(12));
                lekarz.setSpec(rs.getInt(13));

                list.add(lekarz);
            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public void fire(int id, String dat) {
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call fire(?,?)");

            cs.setInt(1, id);
            cs.setString(2, dat);
            cs.execute();
            conn.close();
        } catch (Exception e) {
        }
    }

    public List<Lekarz> getWorking() {
        List<Lekarz> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement statement = conn.createStatement();

            String query = "select * from lekarz where data_zwolnienia is null";
            Lekarz lekarz;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                lekarz = new Lekarz();
                lekarz.setId(rs.getInt(1));
                lekarz.setName(rs.getString(2));
                lekarz.setLastname(rs.getString(3));
                lekarz.setLogin(rs.getString(4));
                lekarz.setPass(rs.getString(5));
                lekarz.setEmail(rs.getString(6));
                lekarz.setTel(rs.getInt(7));
                lekarz.setPwz(rs.getLong(8));
                lekarz.setPesel(rs.getLong(9));
                lekarz.setDat(rs.getDate(11));
                lekarz.setDatZ(rs.getDate(12));
                lekarz.setSpec(rs.getInt(13));
                list.add(lekarz);
            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public List<Lekarz> getAllSpec(int specId) {
        List<Lekarz> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement statement = conn.createStatement();

            String query = "select * from lekarz where data_zwolnienia is null and specjalizacja=" + specId;
            Lekarz lekarz;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                lekarz = new Lekarz();
                lekarz.setId(rs.getInt(1));
                lekarz.setName(rs.getString(2));
                lekarz.setLastname(rs.getString(3));
                lekarz.setLogin(rs.getString(4));
                lekarz.setPass(rs.getString(5));
                lekarz.setEmail(rs.getString(6));
                lekarz.setTel(rs.getInt(7));
                lekarz.setPwz(rs.getLong(8));
                lekarz.setPesel(rs.getLong(9));
                lekarz.setDat(rs.getDate(11));
                lekarz.setDatZ(rs.getDate(12));
                lekarz.setSpec(rs.getInt(13));
                list.add(lekarz);
            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
}
