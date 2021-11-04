package herman.task2.Task2.service;

import herman.task2.Task2.dao.AddressDao;
import herman.task2.Task2.dao.AuthorDao;
import herman.task2.Task2.model.Address;
import herman.task2.Task2.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private AddressDao addressDao;

    public String getAuthors() throws SQLException {
        return authorDao.getAuthors();
    }

    public String createAuthor(Author author) throws SQLException {
        return authorDao.createAuthor(author);
    }

    public String updateAuthor(Author author, int id) throws SQLException {
        return authorDao.updateAuthor(author, id);
    }

    public String getAuthor(int id) throws SQLException {
        return authorDao.getAuthor(id);
    }

    public String deleteAuthor(int id) throws SQLException {
        return authorDao.deleteAuthor(id);
    }

    public String getAddresses() throws SQLException {

        return addressDao.getAddresses();
    }

    public String createAddress(Address address) throws SQLException {
        return addressDao.createAddress(address);
    }

    public String deleteAddress(int id) throws SQLException {
        return addressDao.deleteAddress(id);
    }
}
