package DAO;

import Entity.BookExample;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookExampleDAO extends ElementDAOImp<BookExample> {
    public BookExampleDAO(Class<BookExample> elementClass) {
        super(elementClass);
    }

    public BookExampleDAO() {
    }

    @Autowired
    SessionFactory sessionFactory;

    /**
     * @return count of book examples published after 1991, exclusive
     */
    public Long getBookExamplesCountDuringIndependence() {
        Long count;
        Query query = sessionFactory.getCurrentSession().createQuery("Select count(year) as result From BookExample " +
                " where year > 1991 ");
        count = (Long) query.uniqueResult();
        if (count != null) return count;
        return 0L;
    }


    /**
     * @return List(count of all examples, count of available examples, count of examples in usage)
     */

    public List<Long> getBookExampleInfoByBookName(String name) {
        ArrayList<Long> list = new ArrayList<>();
        Query query = sessionFactory.getCurrentSession().createQuery("select count(be.bookExample_ID) from BookExample be where " +
                " be.book_ID = (select b.book_ID from Book b where b.name = :name)");
        query.setParameter("name", name);
        long all = (long) query.uniqueResult();
        query = sessionFactory.getCurrentSession().createQuery("select count(be.bookExample_ID) from BookExample be where " +
                " be.existence = 'Yes' and " +
                "be.book_ID = (select b.book_ID from Book b where b.name = :name)");
        query.setParameter("name", name);
        long available = (long) query.uniqueResult();
        list.add(all);
        list.add(available);
        list.add(all - available);
        return list;
    }
}
