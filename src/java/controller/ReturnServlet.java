/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;

/**
 *
 * @author user
 */
@WebServlet(name = "ReturnServlet", urlPatterns = {"/return"})
public class ReturnServlet extends HttpServlet {

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
            out.println("<title>Servlet ReturnServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReturnServlet at " + request.getContextPath() + "</h1>");
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
        int bookId = Integer.parseInt(request.getParameter("2"));

        AccountDAO a = new AccountDAO();
        BorrowDAO br = new BorrowDAO();
        BookDAO b = new BookDAO();
        List<Account> list = a.getAll();
        boolean isOk = false;
        for (Account acc : list) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                isOk = true;
                break;
            }
        }
        if (!isOk) {
            pr.print("<h2 align=\"center\" style=\"color:red;\">USERNAME INVALID</h2>");
            return;
        }
        if (!b.searchById(bookId).isAvailable()) {
            br.changeStatus(a.searchByUserName(username).getId(), bookId);
            b.changeStatus(bookId, b.searchById(bookId));
        } else {
            pr.print("<h2 align=\"center\" style=\"color:red;\">BOOK IS UNAVAILABLE</h2>");
        }
        String[] vio = request.getParameterValues("3");
        if (vio != null) {
            ViolationDAO v = new ViolationDAO();
            int bid = br.search(a.searchByUserName(username).getId(), bookId);
            for (int i = 0; i < vio.length; i++) {
                int vid = Integer.parseInt(vio[i]);
                v.insert(bid, vid);
            }
        }

        List<Book> lst = b.getAll();
        request.setAttribute("book", lst);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
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
