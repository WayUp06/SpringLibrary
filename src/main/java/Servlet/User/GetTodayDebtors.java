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

@WebServlet("/getTodayDebtors")
public class GetTodayDebtors extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long t = Long.parseLong(req.getParameter("t2"));
        ArrayList<String> list = userService.getTodayDebtors(t);
        String s = "Today's debtors are: " + String.join(", ",list);
        req.setAttribute("todays_debtors", s);
        req.getRequestDispatcher("/Pages/User.jsp").include(req, resp);
    }
}
