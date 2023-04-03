/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author user
 */
public class Borrow {
    int id;
    String username, bookname;
    Date borrowDate, returnDate;
    boolean returnSatus;

    public Borrow() {
    }

    public Borrow(int id, String username, String name, Date borrowDate, Date returnDate, boolean returnSatus) {
        this.id = id;
        this.username = username;
        this.bookname = name;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returnSatus = returnSatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookname) {
        this.bookname = bookname;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturnSatus() {
        return returnSatus;
    }

    public void setReturnSatus(boolean returnSatus) {
        this.returnSatus = returnSatus;
    }
    
    
}
