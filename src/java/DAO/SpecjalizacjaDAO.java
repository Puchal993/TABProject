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
import java.util.ArrayList;
import java.util.List;
import Model.Specjalizacja;

/**
 *
 * @author Lukasz
 */
public class SpecjalizacjaDAO {

    public List<Specjalizacja> getAll() {
        List<Specjalizacja> list = new ArrayList<>();
        Specjalizacja spec ;
        try {

            Connection conn = DriverManager.getConnection(DBAccess.getURL(), DBAccess.getLOGIN(), DBAccess.getPASS());
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from specjalizacja");
            while (rs.next()) {
                spec = new Specjalizacja();
                spec.setId(rs.getInt(1));
                spec.setNazwa(rs.getString(2));
                list.add(spec);
            }
            conn.close();
        } catch (Exception e) {
        }

        return list;
    }
}
