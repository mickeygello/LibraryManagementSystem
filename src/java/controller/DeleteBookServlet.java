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

import model.*;
import dal.*;
import java.util.List;

@WebServlet(name = "DeleteBookServlet", urlPatterns = {"/book_delete"})
public class DeleteBookServlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteBookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        PrintWriter out = response.getWriter();
        String sId = request.getParameter("1");
        int xId = Integer.parseInt(sId);
        
        BookDAO u = new BookDAO();
        Book x = u.searchById(xId);
        if (x == null) {
            out.println("<h2 align=\"center\" style=\"color:red;\" > ACCOUNT IS NOT FOUND!! </h2>");
            request.getRequestDispatcher("book_delete.jsp").include(request, response);
        }
        u.delete(xId);
        List<Book> lst = u.getAll();
        request.setAttribute("book", lst);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}
