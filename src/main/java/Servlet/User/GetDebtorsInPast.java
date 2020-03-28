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

@WebServlet("/getDebtorsInPast")
public class GetDebtorsInPast extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long t = Long.parseLong(req.getParameter("t1"));
        ArrayList<String> list = userService.getDebtorsInPast(t);
        String s = "Debtors in past are: " + String.join(", ", list);
        req.setAttribute("past_debtors",s);
        req.getRequestDispatcher("/Pages/User.jsp").include(req, resp);

    }
}
