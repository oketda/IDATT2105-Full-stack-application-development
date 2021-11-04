package herman.task2.Task2.service;

import herman.task2.Task2.dao.AuthorDao;
import herman.task2.Task2.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AuthorBookService {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    public String createAuthorBook(int authorId, int bookId) throws SQLException {
        return bookDao.addAuthor(authorId, bookId);
    }

    public String findBookByAuthor(int id) throws SQLException {
        return bookDao.findBookByAuthor(id);
    }

    public String deleteBookAuthor(int authorId, int bookId) throws SQLException {
        return bookDao.deleteBookAuthor(authorId, bookId);
    }
}
