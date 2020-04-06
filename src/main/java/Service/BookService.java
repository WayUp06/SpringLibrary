package Service;

import DAO.BookDAO;
import Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class BookService {

    //private BookDAO bookDAO = new BookDAO(Book.class);

    @Autowired
    BookDAO bookDAO;

    public BookService() {
    }

    public void add(Book book) {
        bookDAO.add(book);
    }

    public boolean update(Book book) {
            bookDAO.update(book);
            return true;
    }

    public Book get(int id) {
        return bookDAO.get(id);
    }

    public Collection<Book> getAll() {
        return bookDAO.getAll();
    }

    public void delete(Book book) {
        bookDAO.delete(book);
    }

    public boolean checkBookAvailability(String name) {
        return bookDAO.checkAvailability(name);
    }

    public Long getCountOfBookUsage(String name) {
        return bookDAO.getCountOfBookUsage(name);
    }

    public int getAverageBookReadingPeriod(String name) {
        return bookDAO.getAverageBookReadingPeriod(name);
    }

    public ArrayList<String> getMostPopularAndUnpopularBookByPeriod(String start, String end) {
        return bookDAO.getMostPopularAndUnpopularBookByPeriod(start, end);
    }

    public ArrayList<String> getCountOfBookUsageByExamples(String name) {
        return bookDAO.getCountOfBookUsageByExamples(name);
    }

}
