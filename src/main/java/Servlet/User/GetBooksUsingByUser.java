package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/getBooksUsingByUser")
public class GetBooksUsingByUser extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id2"));
        ArrayList<String> list = userService.getBooksUsingByUser(id);
        String s;
        if(list.size() != 0) s = "This user is currently using " + String.join(", ", list);
        else  s = "This user is currently using no books.";
        req.setAttribute("books_using",s);
        req.getRequestDispatcher("/Pages/User.jsp").include(req, resp);

    }
}
