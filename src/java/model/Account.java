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
public class Account {
    int id;
    String username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email;
    Date dob;
    boolean gender, admin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account() {
    }

    public Account(String username, String password, String firstName, String lastName, String citizenshipIdentity, String address, String phoneNumber, String email, Date dob, boolean gender, boolean admin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenshipIdentity = citizenshipIdentity;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.admin = admin;
    }

    
    public Account(int id, String username, String password, String firstName, String lastName, String citizenshipIdentity, String address, String phoneNumber, String email, Date dob, boolean gender, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenshipIdentity = citizenshipIdentity;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.admin = admin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCitizenshipIdentity() {
        return citizenshipIdentity;
    }

    public void setCitizenshipIdentity(String citizenshipIdentity) {
        this.citizenshipIdentity = citizenshipIdentity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
