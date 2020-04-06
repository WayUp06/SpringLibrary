package DAO;

import Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserDAO extends ElementDAOImp<User> {
    public UserDAO(Class<User> elementClass) {
        super(elementClass);
    }

    public UserDAO() {
    }

    @Autowired
    SessionFactory sessionFactory;

    /**
     * @return average age of all users
     */
    public double getUserAverageAge() {
        double result;
        Query query = sessionFactory.getCurrentSession().createQuery("select avg(age) from User ");
        result = (double) query.uniqueResult();
        return result;
    }


    /**
     * @param id - user id
     * @return return list of books that were taken and returned by this user
     */
    public ArrayList<String> getBooksUsedByUser(int id) {
        ArrayList<String> list;
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct b.name FROM " +
                "Book b inner join BookExample be on b.book_ID = be.book_ID inner join" +
                " Usage u on be.bookExample_ID=u.bookExample_ID where u.user_ID = :id");
        query.setParameter("id", id);
        list = (ArrayList<String>) query.list();
        return list;
    }


    /**
     * @param id - user id
     * @return list of books that were taken by user and not yet returned
     */
    public ArrayList<String> getBooksUsingByUser(int id) {
        ArrayList<String> list;
        Query query = sessionFactory.getCurrentSession().createQuery("select distinct b.name FROM " +
                "Book b inner join BookExample be on b.book_ID = be.book_ID inner join" +
                " Usage u on be.bookExample_ID=u.bookExample_ID where u.user_ID = :id and u.returnDate is null ");
        query.setParameter("id", id);
        list = (ArrayList<String>) query.list();
        return list;
    }


    /**
     * @return P(years)Y(months)M(days)D
     */
    public Period getPeriodOfLibraryUsing(int id) {
        Period p = null;
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        LocalDate reg = user.getRegisteredDate();
        Optional<LocalDate> dereg = user.getDeregisteredDate();
        LocalDate deregistered = dereg.orElse(LocalDate.now());
        p = Period.between(reg, deregistered);
        return p;
    }


    /**
     * @param name - book name
     * @return average age between all users that took this book
     */
    public double getUserAverageAgeByBook(String name) {
        double res = 0;
        Query query = sessionFactory.getCurrentSession().createQuery("Select avg(ur.age) from User ur" +
                " inner join Usage ug on ug.user_ID=ur.user_ID " +
                " inner join BookExample be on be.bookExample_ID=ug.bookExample_ID " +
                " inner join Book b on b.book_ID=be.book_ID " +
                " where b.name =:name");
        query.setParameter("name", name);
        res = (double) query.uniqueResult();
        return res;
    }


    /**
     * @param name    - author name
     * @param surname - author surname
     * @return average age between all users that took books of this author
     */
    public double getUserAverageAgeByAuthor(String name, String surname) {
        double res = 0;
        Query query = sessionFactory.getCurrentSession().createQuery("Select avg(ur.age) from User ur" +
                " inner join Usage ug on ug.user_ID=ur.user_ID " +
                " inner join BookExample be on be.bookExample_ID=ug.bookExample_ID " +
                " inner join Book b on b.book_ID=be.book_ID " +
                " inner join Author a on b.author_ID=a.author_ID" +
                " where a.name =:name and a.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        res = (double) query.uniqueResult();
        return res;
    }


    /**
     * @param t - max count of days user can keep book
     * @return list each element like : (UserName) (UserAge)
     */
    public ArrayList<String> getDebtorsInPast(long t) {
        ArrayList<String> result = new ArrayList<>();
        Query query = sessionFactory.getCurrentSession().createQuery("select ur.user_ID, ug.takeDate, ug.returnDate  FROM Usage ug" +
                " inner join User ur on ug.user_ID=ur.user_ID " +
                "where  ug.returnDate is not null");
        ArrayList<Object[]> usagesusers = (ArrayList<Object[]>) query.list();
        ArrayList<Integer> userID = new ArrayList<>();
        //usersID - list of user ids that are debtors

        for (Object[] obj : usagesusers) {
            int id = (int) obj[0];
            LocalDate take = (LocalDate) obj[1];
            LocalDate ret = (LocalDate) obj[2];
            long days = ChronoUnit.DAYS.between(take, ret);
            if ((days > t) && (!userID.contains(id))) userID.add(id);
        }
        for (int id : userID) {
            query = sessionFactory.getCurrentSession().createQuery("select concat(u.name, ' ', u.age) from  User u" +
                    " where u.user_ID = :id");
            query.setParameter("id", id);
            result.add(String.valueOf(query.uniqueResult()));
        }
        return result;
    }


    /**
     * @param t - max count of days user can keep book
     * @return list each element like : (UserName) (UserAge)
     */
    public ArrayList<String> getTodayDebtors(long t) {
        ArrayList<String> result = new ArrayList<>();
        Query query = sessionFactory.getCurrentSession().createQuery("select ur.user_ID, ug.takeDate, ug.returnDate  FROM Usage ug" +
                " inner join User ur on ug.user_ID=ur.user_ID " +
                "where  ug.returnDate is null");
        ArrayList<Object[]> usagesusers = (ArrayList<Object[]>) query.list();
        ArrayList<Integer> userID = new ArrayList<>();
        //usersID - list of user ids that are debtors

        for (Object[] obj : usagesusers) {
            int id = (int) obj[0];
            LocalDate take = (LocalDate) obj[1];
            Optional<Object> ret = Optional.ofNullable(obj[2]);
            LocalDate r = (LocalDate) ret.orElse(LocalDate.now());
            long days = ChronoUnit.DAYS.between(take, r);
            if ((days > t) && (!userID.contains(id))) userID.add(id);
        }
        for (int id : userID) {
            query = sessionFactory.getCurrentSession().createQuery("select concat(u.name, ' ', u.age) from  User u" +
                    " where u.user_ID = :id");
            query.setParameter("id", id);
            result.add(String.valueOf(query.uniqueResult()));
        }
        return result;
    }
}
