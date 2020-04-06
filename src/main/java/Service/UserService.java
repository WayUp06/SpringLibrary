package Service;

import DAO.UserDAO;
import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserService {

    //private UserDAO userDAO = new UserDAO(User.class);

    @Autowired
    UserDAO userDAO;

    public UserService() {
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public boolean update(User user) {
        userDAO.update(user);
        return true;
    }

    public User get(int id) {
        return userDAO.get(id);
    }

    public Collection<User> getAll() {
        return userDAO.getAll();
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public double getUserAverageAge() {
        return userDAO.getUserAverageAge();
    }

    public ArrayList<String> getBooksUsedByUser(int id) {
        return userDAO.getBooksUsedByUser(id);
    }

    public ArrayList<String> getBooksUsingByUser(int id) {
        return userDAO.getBooksUsingByUser(id);
    }

    public Period getPeriodOfLibraryUsing(int id) {
        return userDAO.getPeriodOfLibraryUsing(id);
    }

    public double getUserAverageAgeByBook(String name) {
        return userDAO.getUserAverageAgeByBook(name);
    }

    public double getUserAverageAgeByAuthor(String name, String surname) {
        return userDAO.getUserAverageAgeByAuthor(name, surname);
    }

    public ArrayList<String> getDebtorsInPast(long t) {
        return userDAO.getDebtorsInPast(t);
    }

    public ArrayList<String> getTodayDebtors(long t) {
        return userDAO.getTodayDebtors(t);
    }


}
