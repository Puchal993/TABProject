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
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class VisitDAO {

    public void add(int idP, int idL, String data) {
        try {

            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            CallableStatement cs = conn.prepareCall("call add_visit(?,?,?)");
            cs.setInt(1, idL);
            cs.setInt(2, idP);
            cs.setString(3, data);
            cs.execute();
            conn.close();
        } catch (Exception e) {
        }
    }

    public List<Visit> getVisit(int idP) {
        return null;

    }
}
