/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBAccess;
import Model.Specjalizacja;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lukasz
 */
public class PacjentDAO {

    public void add(int tel, long pesel, String... s) {
        try {

            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call add_patient(?,?,?,?,?,?,?,?)");
            cs.setString(1, s[0]);
            cs.setString(2, s[1]);
            cs.setString(3, s[2]);
            cs.setString(4, s[3]);
            cs.setString(5, s[4]);
            cs.setInt(6, tel);
            cs.setLong(7, pesel);
            cs.setString(8, s[5]);
            cs.execute();
            conn.close();
        } catch (Exception e) {
        }
    }

    public boolean checkLogin(String login) {
        try {
         
            System.out.println("TRY");
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("{?=call check_login(?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, login);
            cs.execute();

            int x = cs.getInt(1);
            System.out.println(x);
            if (x == 0) {
                conn.close();
                return true;
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
            String query = "select id from pacjent where login=" + sb.toString();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public boolean isPassCorect(int id, String pass) {
        String query = "select id from pacjent where haslo='" + pass
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
}
