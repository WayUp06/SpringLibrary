package Servlet.Author;

import Entity.Book;
import Service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetBooksOfCoauthor")
public class GetBooksOfCoauthor extends HttpServlet {

    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        authorService = new AuthorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("coauthor_name");
            String surname = req.getParameter("coauthor_surname");

            List<Book> books = authorService.getBooksOfCoauthor(name, surname);
            ArrayList <String> list = new ArrayList<>();
            for(Book book:books){
                list.add("title: " + book.getName() + " main author: " + book.getAuthor().getName() + " " + book.getAuthor().getSurname());
            }
            String result = name + " " + surname + " was coauthor in this books:" + String.join(", ", list);
            req.setAttribute("books_of_coauthor", result);
            req.getRequestDispatcher("/Pages/Author.jsp").include(req, resp);
        } finally{}
    }
}
