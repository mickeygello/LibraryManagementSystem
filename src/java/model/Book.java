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
public class Book {
    int id, categoryId, ageLimit, numberPage;
    String name, author, publisher;
    Date publicationDate;
    boolean available;

    public Book() {
    }

    public Book(int id, String name, int categoryId, int ageLimit, int numberPage, String author, String publisher, Date publicationDate, boolean available) {
        this.id = id;
        this.categoryId = categoryId;
        this.ageLimit = ageLimit;
        this.numberPage = numberPage;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
}
