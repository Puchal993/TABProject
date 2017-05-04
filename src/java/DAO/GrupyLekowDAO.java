/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBAccess;
import Model.Specjalizacja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lukasz
 */
public class GrupyLekowDAO {
    public Map<Integer, String> getAll() {
        Map<Integer, String> map = new HashMap<>();
       
        try {

            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from grupy_lekow");
            while (rs.next()) {
                //  spec = new Specjalizacja();
                // spec.setId(rs.getInt(1));
                // spec.setNazwa(rs.getString(2));
                map.put(rs.getInt(1), rs.getString(2));
            }
            conn.close();
        } catch (Exception e) {
        }

        return map;
    }
}
