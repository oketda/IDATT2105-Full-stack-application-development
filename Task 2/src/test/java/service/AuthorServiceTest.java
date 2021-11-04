package service;

import herman.task2.Task2.dao.AddressDao;
import herman.task2.Task2.dao.AuthorDao;
import herman.task2.Task2.model.Address;
import herman.task2.Task2.model.Author;
import herman.task2.Task2.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    AuthorService service;

    @Mock
    AuthorDao repo;

    @Mock
    AddressDao addressRepo;

    @BeforeEach
    public void setUp() throws SQLException {
        Author neededForCreate = new Author();
        neededForCreate.setId(1);
        neededForCreate.setAge(21);
        neededForCreate.setFirstName("Herman");
        neededForCreate.setLastName("Aagaard");

        Mockito.lenient().when(repo.getAuthor(0)).thenReturn("id: 1, Name: Test, Age: test alder");
        Mockito.lenient().when(repo.createAuthor(new Author())).thenReturn("New author created");
        Mockito.lenient().when(repo.deleteAuthor(0)).thenReturn("Author deleted");
        Mockito.lenient().when(addressRepo.createAddress(new Address())).thenReturn("New address created");
        Mockito.lenient().when(addressRepo.deleteAddress(0)).thenReturn("Address deleted");
    }

    @Test
    void createAuthor() throws SQLException {
        try {
            repo.createAuthor(new Author());
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void getAuthors() throws SQLException {
        try {
            repo.getAuthors();
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void getAuthor() throws SQLException {
        try {
            repo.getAuthor(0);
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void updateAuthor() throws SQLException {
        try{
            repo.updateAuthor(new Author(), 0);
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void deleteAuthor() throws SQLException {
        try{
            repo.deleteAuthor(0);
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void getAddresses() throws SQLException {
        try {
            addressRepo.getAddresses();
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void createAddress() throws SQLException {
        try {
           addressRepo.createAddress(new Address());
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }

    @Test
    void deleteAddress() throws SQLException {
        try{
            addressRepo.deleteAddress(0);
        }catch (IllegalArgumentException e){
            System.out.println("Should not be here");
        }
    }


}
