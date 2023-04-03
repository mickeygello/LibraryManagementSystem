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
public class BookDAO extends MyDAO {

    public List<Book> getAll() {
        List<Book> list = new ArrayList<Book>();
        xSql = "select * from Book";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Book b = null;
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int categoryId = rs.getInt(3);
                int ageLimit = rs.getInt(4);
                int numberPage = rs.getInt(5);
                String author = rs.getString(6);
                String publisher = rs.getString(7);
                Date publicationDate = rs.getDate(8);
                boolean available = rs.getBoolean(9);
                b = new Book(id, name, categoryId, ageLimit, numberPage, author, publisher, publicationDate, available);
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Book getBook(int xId) {
        Book x = null;
        xSql = "select * from Book where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xId);
            rs = ps.executeQuery();
            int xCategoryId, xAgeLimit, xNumberPage;
            String xName, xAuthor, xPublisher;
            Date xPublicationDate;
            boolean xAvailable;
            if (rs.next()) {
                xCategoryId = rs.getInt("3");
                xAgeLimit = rs.getInt("4");
                xNumberPage = rs.getInt("5");
                xName = rs.getString("2");
                xAuthor = rs.getString("6");
                xPublisher = rs.getString("7");
                xPublicationDate = rs.getDate("8");
                xAvailable = rs.getBoolean("9");
                x = new Book(xId, xName, xCategoryId, xAgeLimit, xNumberPage, xAuthor, xPublisher, xPublicationDate, xAvailable);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void insert(Book x) {
        xSql = "insert into Book(id, name, categoryId, ageLimit, numberPage, author, publicationDate, publisher, available) "
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getId());
            ps.setString(2, x.getName());
            ps.setInt(3, x.getCategoryId());
            ps.setInt(4, x.getAgeLimit());
            ps.setInt(5, x.getNumberPage());
            ps.setString(6, x.getAuthor());
            ps.setDate(7, (Date) x.getPublicationDate());
            ps.setString(8, x.getPublisher());
            ps.setBoolean(9, x.isAvailable());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int xId) {
        xSql = "delete from Book where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xId);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book searchById(int xId) {
        Book x = null;
        xSql = "select * from Book WHERE id = " + xId;
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            String name, author, publisher;
            Date publicationDate;
            int id, categoryId, ageLimit, numberPage;
            boolean available;
            if (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                categoryId = rs.getInt(3);
                ageLimit = rs.getInt(4);
                numberPage = rs.getInt(5);
                author = rs.getString(6);
                publisher = rs.getString(7);
                publicationDate = rs.getDate(8);
                available = rs.getBoolean(9);
                x = new Book(id, name, categoryId, ageLimit, numberPage, author, publisher, publicationDate, available);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public List<Book> search(String xBookName) {
        List<Book> list = new ArrayList<>();
        xSql = "select * from Book WHERE name like '%" + xBookName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String name, author, publisher;
            int id, category, ageLimit, numberPage;
            Date publicationDate;
            boolean available;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                category = rs.getInt(3);
                ageLimit = rs.getInt(4);
                numberPage = rs.getInt(5);
                author = rs.getString(6);
                publisher = rs.getString(7);
                publicationDate = rs.getDate(8);
                available = rs.getBoolean(9);
                Book x = new Book(id, name, category, ageLimit, numberPage, author, publisher, publicationDate, available);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(int id, Book x) {
        xSql = "update book \n"
                + "set name = ?, categoryId = ?, ageLimit = ?, numberPage = ?, author = ?, publisher = ?, \n"
                + "publicationDate = ?, available = ?\n"
                + "where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setInt(2, x.getCategoryId());
            ps.setInt(3, x.getAgeLimit());
            ps.setInt(4, x.getNumberPage());
            ps.setString(5, x.getAuthor());
            ps.setString(6, x.getPublisher());
            ps.setDate(7, (Date) x.getPublicationDate());
            ps.setBoolean(8, x.isAvailable());
            ps.setInt(9, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void changeStatus(int id, Book x) {
        xSql = "update book set available = ? where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setBoolean(1, !x.isAvailable());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
        BookDAO b = new BookDAO();
        List<Book> list = b.getAll();
//        for (Book book : list) {
//            System.out.println(book.isAvailable());
//        }
//        System.out.println(b.searchById(2).isAvailable());
//        b.changeStatus(2, b.searchById(2));
//        System.out.println(b.searchById(2).isAvailable());
        
        
    }
}
