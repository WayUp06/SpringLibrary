package DAO;


import Entity.Book;
import Entity.Usage;
import main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO extends ElementDAOImp<Book> {
    private Class<BookDAO> elementClass = BookDAO.class;

    public BookDAO(Class<Book> elementClass) {
        super(elementClass);
    }

    public BookDAO() {
        super();
    }

    /**
     * @return true if there is at least one available book example in library, otherwise return false
     */
    public boolean checkAvailability(String name){
        Session session = null;
        ArrayList <String> list = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select be.existence from Book b " +
                    " inner join BookExample be on be.book_ID = b.book_ID " +
                    "where be.existence = 'Yes' and b.name = :name");
            query.setParameter("name",name);
            list = (ArrayList<String>) query.list();
        } finally{
            if((session != null) && (session.isOpen())) session.close();
        }
        return !list.isEmpty();

    }

    /**
     * @return Count of usages of this book
     */
    public Long getCountOfBookUsage(String name){
        Session session = null;
        Long count;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select count(u.usage_ID) from " +
                    " Book  b inner join BookExample be on b.book_ID = be.book_ID " +
                    "inner join Usage u on be.bookExample_ID = u.bookExample_ID where b.name = :name");
            query.setParameter("name", name);
            count = (Long)query.uniqueResult();
        }finally{
            if((session != null) && session.isOpen()) session.close();
        }
        return  count;
    }


    /**
     * @param name - name of book
     * @return average count of days needed to read a book
     */

    public int getAverageBookReadingPeriod(String name){
        Session session = null;
        int sum = 0;
        int count = 0;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            System.out.println("1");
            Query query = session.createQuery("Select u.usage_ID from " +
                    " Book b inner join BookExample be on b.book_ID = be.book_ID " +
                    "inner join Usage u on u.bookExample_ID=be.bookExample_ID " +
                    "where b.name=:name");
            query.setParameter("name",name);
            System.out.println("2");
            List<Integer> list = (List<Integer>) query.list();
            UsageDAO usageDAO = new UsageDAO(Usage.class);
            System.out.println("3");
            for(int i:list) {
                System.out.println("4");
                Usage usage = usageDAO.get(i);//.get();
                System.out.println("5");
                LocalDate take = usage.getTakeDate();
                System.out.println("6");
                Optional<LocalDate> ret = usage.getReturnDate();
                System.out.println("7");
                if(ret.isPresent()){
                    count++;
                    System.out.println("8");
                    sum += ChronoUnit.DAYS.between(take,ret.orElse(take));
                    System.out.println("9");
                }
            }
        }finally{
            if((session!=null) && session.isOpen()) session.close();
        }
        int result = sum/count;
        if(result <= 1) return 1;
        return result;
    }

    /**
     *
     * @param start - date in format YYYY-MM-DD, inclusive
     * @param end - date in format YYYY-MM-DD, inclusive
     * @return list with 2 Strings: first - the most popular book, second - the most unpopular
     */
    public ArrayList<String> getMostPopularAndUnpopularBookByPeriod(String start,String end){
        Session session = null;
        ArrayList<String> list ;
        ArrayList<String> result = new ArrayList<>();
        String res;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select b.name from Book b " +
                    "inner join BookExample be on b.book_ID=be.book_ID" +
                    " inner join Usage u on u.bookExample_ID=be.bookExample_ID " +
                    " where u.takeDate >= :start and u.takeDate<= :end " +
                    "group by b.book_ID " +
                    "order by count(u.usage_ID) desc");
            LocalDate s = LocalDate.parse(start);
            LocalDate e = LocalDate.parse(end);
            query.setParameter("start",s);
            query.setParameter("end", e);
            list = (ArrayList<String>) query.list();
            result.add(list.get(0));
            result.add(list.get(list.size()-1));
        } finally{
            if((session != null) && session.isOpen()) session.close();
        }
        return result;


    }

    /**
     *
     * @param name - book name
     * @return list of Strings format Example (BookExample_ID) was taken (how many times) times
     * doesn't return count of usages of books that were NOT used
     */
    public ArrayList<String> getCountOfBookUsageByExamples(String name){
        Session session = null;
        ArrayList<String> list = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select concat('Example ',be.bookExample_ID," +
                    "' was taken ', count(u.usage_ID),' time(s)' ) from " +
                    " Usage u inner join BookExample be on be.bookExample_ID=u.bookExample_ID " +
                    " inner join Book b on b.book_ID = be.book_ID where b.name=:name " +
                    " group by be.bookExample_ID " +
                    " order by be.bookExample_ID asc");
            query.setParameter("name",name);
            list = (ArrayList<String>) query.list();
        }finally{
            if((session != null) && session.isOpen()) session.close();
        }
        return list;


    }


}

