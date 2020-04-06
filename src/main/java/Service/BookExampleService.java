package Service;

import DAO.BookExampleDAO;
import Entity.BookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class BookExampleService {

    //private BookExampleDAO bookExampleDAO = new BookExampleDAO(BookExample.class);

    @Autowired
    BookExampleDAO bookExampleDAO;

    public BookExampleService() {
    }

    public void add(BookExample bookExample) {
        bookExampleDAO.add(bookExample);
    }

    public boolean update(BookExample bookExample) {
            bookExampleDAO.update(bookExample);
            return true;
      }

    public BookExample get(int id) {
        return bookExampleDAO.get(id);
    }

    public Collection<BookExample> getAll() {
        return bookExampleDAO.getAll();
    }

    public void delete(BookExample bookExample) {
        bookExampleDAO.delete(bookExample);
    }

    public Long getBookExamplesCountDuringIndependence() {
        return bookExampleDAO.getBookExamplesCountDuringIndependence();
    }

    public List<Long> getBookExampleInfoByBookName(String name) {
        return bookExampleDAO.getBookExampleInfoByBookName(name);
    }


}
