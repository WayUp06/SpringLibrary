package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Period;

@WebServlet("/getPeriodOfLibraryUsing")
public class GetPeriodOfLibraryUsing extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id3"));
        Period p = userService.getPeriodOfLibraryUsing(id);
        String s = "This user is using library for " + p.getYears() + " years " +
                    p.getMonths() + " months " + p.getDays() + " days";
        req.setAttribute("using_period",s);
        req.getRequestDispatcher("/Pages/User.jsp").include(req, resp);
    }
}
