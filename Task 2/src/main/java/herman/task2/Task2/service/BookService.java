package herman.task2.Task2.service;

import herman.task2.Task2.dao.BookDao;
import herman.task2.Task2.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public String getBooks() throws SQLException {
        return bookDao.getBooks();
    }

    public String createBook(Book book) throws SQLException { return bookDao.createBook(book); }

    public String updateBook(Book book, int id) throws SQLException { return bookDao.updateBook(book, id); }

    public String findBook(int id) throws SQLException {
        return bookDao.getBook(id);
    }

    public String deleteBook(int id) throws SQLException {
        return bookDao.deleteBook(id);
    }
}
