/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBAccess;
import Model.Visit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class VisitDAO {

    public void add(int idP, int idL, String data) {
        try {

            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call addvisit(?,?,?)");
            cs.setInt(1, idL);
            cs.setInt(2, idP);
            cs.setString(3, data);
            cs.execute();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void addDiagnose(int idW, String diagnose) {
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call adddiagnose(?,?)");
            cs.setInt(1, idW);
            cs.setString(2, diagnose);
            cs.execute();
            conn.close();

        } catch (Exception e) {
        }
    }

    public List<Visit> getVisit(int idP) {
        List<Visit> list = new ArrayList<>();
        Visit v;
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();
            String query = "select * from wizyta where pacjent=" + idP + "and diagnoza is not null";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                v = new Visit();
                v.setId(rs.getInt(1));
                v.setIdL(rs.getInt(2));
                v.setIdP(rs.getInt(3));
                v.setDat(rs.getDate(4));
                v.setDiagnose(rs.getString(5));
                list.add(v);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public List<Visit> getDVisit(int id) {
        List<Visit> list = new ArrayList<>();
        Visit v;
        try {
            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();
            String query = "select * from wizyta where lekarz=" + id + "and diagnoza is null";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                v = new Visit();
                v.setId(rs.getInt(1));
                v.setIdL(rs.getInt(2));
                v.setIdP(rs.getInt(3));
                v.setDat(rs.getDate(4));
                v.setDiagnose(rs.getString(5));
                list.add(v);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
