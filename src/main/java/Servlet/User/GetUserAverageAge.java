package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUserAverageAge")
public class GetUserAverageAge extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService u = new UserService();
        double d = u.getUserAverageAge();
        PrintWriter writer = null;
        writer = resp.getWriter();
        //double d = userService.getUserAverageAge();
        writer.println("<html> <body>");
        writer.println("Average age is " +d);
        writer.println("</body> </html> ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            writer = resp.getWriter();
            double d = userService.getUserAverageAge();
            writer.println("<html> <body>");
            writer.println("Average age is " + d);
            writer.println("</body> </html> ");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
