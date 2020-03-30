package main;

import DAO.BookDAO;
import DAO.UsageDAO;
import DAO.UserDAO;
import Entity.BookExample;
import Entity.Usage;
import Service.UserService;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class Test {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
