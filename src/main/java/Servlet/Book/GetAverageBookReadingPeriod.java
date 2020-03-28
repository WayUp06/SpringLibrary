package Servlet.Book;

import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAverageBookReadingPeriod")
public class GetAverageBookReadingPeriod extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("read_name");
        int i = bookService.getAverageBookReadingPeriod(name);
        String r = "It takes " + i + " days to read this book";
        req.setAttribute("reading_period",r);
        req.getRequestDispatcher("/Pages/Book.jsp").include(req, resp);
    }
}
