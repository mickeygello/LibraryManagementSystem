package dal;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date; // Date only

public class AccountDAO extends MyDAO {

    public List<Account> getAll() {
        List<Account> list = new ArrayList<Account>();
        xSql = "select * from Account";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email;
            Date dob;
            boolean gender, admin;
            Account a = null;
            while (rs.next()) {
                id = rs.getInt(1);
                username = rs.getString(2);
                password = rs.getString(3);
                firstName = rs.getString(4);
                lastName = rs.getString(5);
                citizenshipIdentity = rs.getString(6);
                dob = rs.getDate(7);
                gender = rs.getBoolean(8);
                address = rs.getString(9);
                phoneNumber = rs.getString(10);
                email = rs.getString(11);
                admin = rs.getBoolean(12);
                a = new Account(id, username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email, dob, gender, admin);
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account searchByUserName(String xUserName) {
        Account x = null;
        xSql = "select * from Account WHERE username like '" + xUserName + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email;
            Date dob;
            boolean gender, admin;
            if (rs.next()) {
                id = rs.getInt(1);
                username = rs.getString(2);
                password = rs.getString(3);
                firstName = rs.getString(4);
                lastName = rs.getString(5);
                citizenshipIdentity = rs.getString(6);
                dob = rs.getDate(7);
                gender = rs.getBoolean(8);
                address = rs.getString(9);
                phoneNumber = rs.getString(10);
                email = rs.getString(11);
                admin = rs.getBoolean(12);
                x = new Account(id, username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email, dob, gender, admin);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void insert(int id, Account x) {
        xSql = "insert into Account (id,username, password, firstName, lastName, citizenshipIdentity, DOB, gender,address,phoneNumber,email, admin) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getId());
            ps.setString(2, x.getUsername());
            ps.setString(3, x.getPassword());
            ps.setString(4, x.getFirstName());
            ps.setString(5, x.getLastName());
            ps.setString(6, x.getCitizenshipIdentity());
            ps.setDate(7, (Date) x.getDob());
            ps.setBoolean(8, x.isGender());
            ps.setString(9, x.getAddress());
            ps.setString(10, x.getPhoneNumber());
            ps.setString(11, x.getEmail());
            ps.setBoolean(12, x.isAdmin());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account searchById(int xId) {
        Account x = null;
        xSql = "select * from Account WHERE id = " + xId;

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email;
            Date dob;
            boolean gender, admin;
            Account a = null;
            if (rs.next()) {
                id = rs.getInt(1);
                username = rs.getString(2);
                password = rs.getString(3);
                firstName = rs.getString(4);
                lastName = rs.getString(5);
                citizenshipIdentity = rs.getString(6);
                dob = rs.getDate(7);
                gender = rs.getBoolean(8);
                address = rs.getString(9);
                phoneNumber = rs.getString(10);
                email = rs.getString(11);
                admin = rs.getBoolean(12);
                x = new Account(id, username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email, dob, gender, admin);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void delete(String xUserName) {
        xSql = "delete from Account where username=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUserName);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String username, Account x) {
        xSql = "update account \n"
                + "set password = ?, firstName = ?, lastName = ?, citizenshipIdentity = ?, dob = ?, gender = ?, \n"
                + "address = ?, phoneNumber = ?, email = ?, admin = ?\n"
                + "where username = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getPassword());
            ps.setString(2, x.getFirstName());
            ps.setString(3, x.getLastName());
            ps.setString(4, x.getCitizenshipIdentity());
            ps.setDate(5, (Date) x.getDob());
            ps.setBoolean(6, x.isGender());
            ps.setString(7, x.getAddress());
            ps.setString(8, x.getPhoneNumber());
            ps.setString(9, x.getEmail());
            ps.setBoolean(10, x.isAdmin());
            ps.setString(11, username);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        a.insert(3, new Account(3, "user2", "user2", "user2", "user2", "user2", "user2", "user2", "user2", Date.valueOf("2000-01-01"), true, true));
        List<Account> list = a.getAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
        }
//        System.out.println(a.searchById(2).getUsername());
    }
}
