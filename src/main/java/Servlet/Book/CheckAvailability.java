package Servlet.Book;

import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkAvailability")
public class CheckAvailability extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Boolean b = bookService.checkBookAvailability(name);
        String book_availability;
        if (b) book_availability = "This book is available.";
        else book_availability = "This book isn't available.";
        req.setAttribute("book_availability", book_availability);
        req.getRequestDispatcher("/Pages/Book.jsp").include(req, resp);
    }
}
