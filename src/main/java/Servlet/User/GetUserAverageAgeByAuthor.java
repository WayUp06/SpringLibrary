package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUserAverageAgeByAuthor")
public class GetUserAverageAgeByAuthor extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("aan");
        String surname = req.getParameter("aas");
        double d = userService.getUserAverageAgeByAuthor(name,surname);
        String s = "Average age by this author is " + d;
        req.setAttribute("avg_age_author",s);
        req.getRequestDispatcher("/Pages/User.jsp").include(req, resp);

    }
}
