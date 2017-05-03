/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DB.DBAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lukasz
 */
public class AdminDAO {

   

    public boolean isPassCorect(int id, String pass) {
        String query = "select id from admin where haslo='" + pass
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
            String query = "select id from admin where login=" + sb.toString();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

}
