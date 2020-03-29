package main;

import DAO.BookDAO;
import DAO.UsageDAO;
import DAO.UserDAO;
import Entity.Usage;
import Service.UserService;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class Test {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            BookDAO b = new BookDAO();
            System.out.println((b.getAverageBookReadingPeriod("Book1")));
            //UserService userService = new UserService();
            //BookDAO bookDAO = new BookDAO();
            //System.out.println("total result: " + bookDAO.getAverageBookReadingPeriod("Book1"));
            /*double d = userService.getUserAverageAge();
            double ds = userService.getUserAverageAge();
            System.out.println(ds);
            System.out.println(d + " issss");
            System.out.println("test");
            BookDAO bookDAO = new BookDAO();
            System.out.println(bookDAO.getAverageBookReadingPeriod("Book1"));*/
            //UserDAO u = new UserDAO();
            //ArrayList<String> a = u.getTodayDebtors(1);
            //for(String s:a) System.out.println(s);
            session.getTransaction().commit();
            session.close();
        }
        catch(Throwable e){ e.printStackTrace();}
    }

}
