package Servlet.Author;

import Service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/GetBooksOfAuthor")
public class GetBooksOfAuthor extends HttpServlet {

    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        authorService = new AuthorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("author_name");
            String surname = req.getParameter("author_surname");

            ArrayList<String> list = (ArrayList<String>) authorService.getBooksOfAuthor(name, surname);
            String books = name + " " + surname + " wrote this books: ";
            String l = String.join(", ", list);
            books += l;
            req.setAttribute("books_of_author",books);
            req.getRequestDispatcher("/Pages/Author.jsp").include(req, resp);
        } finally {

        }
    }
}
