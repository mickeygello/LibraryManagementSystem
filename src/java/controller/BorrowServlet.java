/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;
import dal.*;
import java.sql.Date;

/**
 *
 * @author user
 */
@WebServlet(name = "BorrowServlet", urlPatterns = {"/borrow"})
public class BorrowServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BorrowServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BorrowServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
        String username = request.getParameter("1");
        String password = request.getParameter("2");
        int bookId = Integer.parseInt(request.getParameter("3"));
        int period = Integer.parseInt(request.getParameter("4"));
        
        AccountDAO a = new AccountDAO();
        BorrowDAO b = new BorrowDAO();
        BookDAO bd = new BookDAO();
        List<Account> list = a.getAll();
        boolean isOk = false;
        for (Account acc : list) {
            if (acc.getUsername().equalsIgnoreCase(username) && acc.getPassword().equalsIgnoreCase(password)) {
                isOk = true;
                break;
            }
        }
        if (!isOk) {
            pr.print("<h2 align=\"center\" style=\"color:red;\">USERNAME OR PASSWORD INVALID</h2>");
            return;
        }
        if(bd.searchById(bookId).isAvailable()) {
            b.insert(a.searchByUserName(username).getId(), bookId, Date.valueOf(java.time.LocalDate.now().toString()), period);
            bd.changeStatus(bookId, bd.searchById(bookId));
            List<Book> book = bd.getAll();
            request.setAttribute("book", book);
            request.getRequestDispatcher("bookList.jsp").forward(request, response);
        } else {
            pr.print("<h2 align=\"center\" style=\"color:red;\">BOOK IS UNAVAILABLE</h2>");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
