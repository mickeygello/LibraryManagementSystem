package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dal.*;
import java.sql.Date;
import model.*;

/**
 *
 * @author user
 */
@WebServlet(name = "UpdateAccountServlet", urlPatterns = {"/acc_update"})
public class UpdateAccountServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateAccountServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAccountServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String username = request.getParameter("1");
        AccountDAO u = new AccountDAO();
        Account x = u.searchByUserName(username);
        if(x==null) {
            pr.println("<h2 align=\"center\" style=\"color:red;\" > ACCOUNT IS NOT FOUND!! </h2>");
           request.getRequestDispatcher("acc_update.jsp").include(request, response);
        }
        else {
           request.setAttribute("x", x);
           request.getRequestDispatcher("update_acc.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email;
        String xdob;
        Date dob = null;
        boolean gender, admin;
        username = request.getParameter("1").trim();
        password = request.getParameter("2").trim();
        firstName = request.getParameter("3").trim();
        lastName = request.getParameter("4").trim();
        citizenshipIdentity = request.getParameter("5").trim();
        xdob = request.getParameter("6").trim();
        dob = Date.valueOf(xdob);
        gender = request.getParameter("7").trim().equals("male");
        address = request.getParameter("8");
        phoneNumber = request.getParameter("9");
        email = request.getParameter("10"); 
        admin = false;
        Account x = new Account(username, password, firstName, lastName, citizenshipIdentity, address, phoneNumber, email, dob, gender, admin);
        AccountDAO u = new AccountDAO();
        u.update(username,x);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
