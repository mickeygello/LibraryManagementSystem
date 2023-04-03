package dal;

import model.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.sql.Date; // Date only

public class BorrowDAO extends MyDAO {

    public List<Borrow> getAll() {
        List<Borrow> list = new ArrayList<>();
        xSql = "select bb.id, a.username, b.name, borrowDate, returnDate, returnSatus \n"
                + "from Borrow bb, Book b, Account a where bb.bookId = b.id and a.id=bb.accId";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String username, bookname;
            Date borrowDate, returnDate;
            boolean returnSatus;
            Borrow a = null;
            while (rs.next()) {
                id = rs.getInt(1);
                username = rs.getString(2);
                bookname = rs.getString(3);
                borrowDate = rs.getDate(4);
                returnDate = rs.getDate(5);
                returnSatus = rs.getBoolean(6);
                a = new Borrow(id, username, bookname, borrowDate, returnDate, returnSatus);
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(int accId, int bookId, Date borrowDate, int timeBorrow) {
        xSql = "insert into Borrow (id, accId, bookId, borrowDate, returnDate, returnSatus) \n"
                + "values (?, ?, ?, ?, ?, ?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(borrowDate);
        c.add(Calendar.DATE, timeBorrow);
        try {
            ps = con.prepareStatement(xSql);
            BorrowDAO a = new BorrowDAO();
            int id = a.getAll().size();
            ps.setInt(1, id + 1);
            ps.setInt(2, accId);
            ps.setInt(3, bookId);
            ps.setDate(4, borrowDate);
            ps.setDate(5, Date.valueOf(dateFormat.format(c.getTime())));
            ps.setBoolean(6, false);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int search(int accId, int bookId) {
        xSql = "select * from Borrow where accid=? and bookid=? and returnSatus=0";
        Borrow a = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accId);
            ps.setInt(2, bookId);
            rs = ps.executeQuery();
            int id;
            String username, bookname;
            Date borrowDate, returnDate;
            boolean returnSatus;
            if (rs.next()) {
                id = rs.getInt(1);
                username = rs.getString(2);
                bookname = rs.getString(3);
                borrowDate = rs.getDate(4);
                returnDate = rs.getDate(5);
                returnSatus = rs.getBoolean(6);
                a = new Borrow(id, username, bookname, borrowDate, returnDate, returnSatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a.getId();
    }

    public void changeStatus(int accId, int bookId) {
        xSql = "update Borrow set returnSatus = 1 where accId=? and bookId=? and and returnSatus=0";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, accId);
            ps.setInt(2, bookId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        BorrowDAO br = new BorrowDAO();
        BookDAO b = new BookDAO();
        System.out.println(br.search(a.searchByUserName("admin").getId(), 52));
//        AccountDAO a = new AccountDAO();
//        System.out.println(bid);
    }
}
