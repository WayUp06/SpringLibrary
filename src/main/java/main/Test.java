package main;

import DAO.BookDAO;
import Service.UserService;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            UserService userService = new UserService();
            double d = userService.getUserAverageAge();
            double ds = userService.getUserAverageAge();
            System.out.println(ds);
            System.out.println(d + " issss");
            System.out.println("test");
            BookDAO bookDAO = new BookDAO();
            System.out.println(bookDAO.getAverageBookReadingPeriod("Book1"));
            session.getTransaction().commit();
            session.close();
        }
        catch(Throwable e){ e.printStackTrace();}
    }

}
