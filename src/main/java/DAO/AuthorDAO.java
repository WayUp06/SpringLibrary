package DAO;

import Entity.Author;
import Entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@ComponentScan("main")
@Repository
public class AuthorDAO extends ElementDAOImp<Author> {
    public AuthorDAO(Class<Author> elementClass) {
        super(elementClass);
    }

    @Autowired
    SessionFactory sessionFactory;


    /**
     * @param name    - name of author
     * @param surname - surname of author
     * @return list of book names of this author
     */
    public List<String> getBooksOfAuthor(String name, String surname) {
        ArrayList<String> list;
        Query query = sessionFactory.getCurrentSession().createQuery("select b.name From Book  b " +
                "where b.author_ID = (select author_ID from Author  where name = :name and surname =:surname)");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        list = (ArrayList<String>) query.list();
        return list;
    }


    /**
     * @return set of books with this coauthor
     */
    public List<Book> getBooksOfCoauthor(String name, String surname) {
        List<Book> b;
        Query query = sessionFactory.getCurrentSession().createQuery("from Author  a where a.name =:name and a.surname =:surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        Author a = (Author) query.uniqueResult();
        b = a.getBooks();
        return b;
    }
}
