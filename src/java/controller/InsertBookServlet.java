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
import java.sql.Date;
import java.util.List;


@WebServlet(urlPatterns = {"/insertBook"})
public class InsertBookServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xName, xAuthor, xPublisher, sId, sAgeLimit, sNumberPage, sPublicationDate, sCategoryId, sAvailable;
        boolean xAvailable;
        Date xPublicationDate = null;
        int xId, xAgeLimit, xNumberPage, xCategoryId;
        Category xCategory;

        sId = request.getParameter("1").trim();
        xId = Integer.parseInt(sId);
        BookDAO u = new BookDAO();
        Book x = u.getBook(xId);
        if (x != null) {
            pr.print("<h3> The id " + xId + " already exists!");
            request.getRequestDispatcher("insert_book.jsp").include(request, response);
            return;
        }
        xName = request.getParameter("2").trim();
        sCategoryId = request.getParameter("3");
        xCategoryId = Integer.parseInt(sCategoryId);
        sAgeLimit = request.getParameter("4");
        xAgeLimit = Integer.parseInt(sAgeLimit);
        sNumberPage = request.getParameter("5");
        xNumberPage = Integer.parseInt(sNumberPage);
        xAuthor = request.getParameter("6").trim();
        xPublisher = request.getParameter("7").trim();
        sPublicationDate = request.getParameter("8");
        xPublicationDate = Date.valueOf(sPublicationDate);
        x = new Book(xId, xName, xCategoryId, xAgeLimit, xNumberPage, xAuthor, xPublisher, xPublicationDate, true);
        u.insert(x);
        List<Book> lst = u.getAll();
        request.setAttribute("book", lst);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}
