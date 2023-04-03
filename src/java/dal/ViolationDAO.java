/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class ViolationDAO extends MyDAO{
    
    public List<Violation> getAll() {
        List<Violation> list = new ArrayList<>();
        xSql = "select * from Violation";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Violation c = null;
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                c = new Violation(id, name);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(int bid, int vid) {
        xSql = "insert into Violation_Borrow (bid,vid) values (?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, bid);
            ps.setInt(2, vid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ViolationDAO c = new ViolationDAO();
        c.insert(1, 2);
    }
}
