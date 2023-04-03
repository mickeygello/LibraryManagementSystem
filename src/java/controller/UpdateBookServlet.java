/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
 * @author TUF GAMING
 */
@WebServlet(name = "UpdateBookServlet", urlPatterns = {"/book_update"})
public class UpdateBookServlet extends HttpServlet{
    
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
        String sId = request.getParameter("1");
        int xId = Integer.parseInt(sId);
        BookDAO u = new BookDAO();
        Book x = u.searchById(xId);
        if(x==null) {
            pr.println("<h2 align=\"center\" style=\"color:red;\" > BOOK IS NOT FOUND!! </h2>");
           request.getRequestDispatcher("book_update.jsp").include(request, response);
        }
        else {
           request.setAttribute("x", x);
           request.getRequestDispatcher("update_book.jsp").forward(request, response);
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
        String sId ,xName, xAuthor, xPublisher, sCategoryId, sAgeLimit, sNumberPage;
        int xCategoryId, xAgeLimit, xNumberPage, xId;
        String sPublicationDate;
        Date xPublicationDate = null;
        boolean available;
        
        sId = request.getParameter("1");
        xId = Integer.parseInt(sId);
        
        xName = request.getParameter("2").trim();
        
        sCategoryId = request.getParameter("3").trim(); 
        xCategoryId = Integer.parseInt(sCategoryId);
        
        sAgeLimit = request.getParameter("4").trim();
        xAgeLimit = Integer.parseInt(sAgeLimit);
        
        sNumberPage = request.getParameter("5");
        xNumberPage = Integer.parseInt(sNumberPage);
        
        xAuthor = request.getParameter("6");
        
        xPublisher = request.getParameter("7");
        
        sPublicationDate = request.getParameter("8").trim();
        xPublicationDate = Date.valueOf(sPublicationDate);
        
        available = request.getParameter("9").trim().equals("true");
        
        Book x = new Book(xId, xName, xCategoryId, xAgeLimit, xNumberPage, xAuthor, xPublisher, xPublicationDate, available);
        BookDAO u = new BookDAO();
        u.update(xId,x);
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
