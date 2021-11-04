package herman.task2.Task2.web;

import herman.task2.Task2.model.Address;
import herman.task2.Task2.model.Author;
import herman.task2.Task2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public String getAuthors() throws SQLException {
        return authorService.getAuthors();
    }

    @PostMapping
    public String createAuthor(@RequestBody Author author) throws SQLException {
        return authorService.createAuthor(author);
    }

    @PostMapping("/{id}")
    public String updateAuthor(@RequestBody Author author, @PathVariable int id) throws SQLException {
        return authorService.updateAuthor(author, id);
    }

    @GetMapping("/{id}")
    public String findAuthor(@PathVariable int id) throws SQLException { return authorService.getAuthor(id); }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id) throws SQLException { return authorService.deleteAuthor(id); }

    @GetMapping("/addresses")
    public String getAddresses() throws SQLException { return authorService.getAddresses();}

    @PostMapping("/addresses")
    public String createAddress(@RequestBody Address address) throws SQLException { return authorService.createAddress(address);}

    @DeleteMapping("/Addresses/{id}")
    public String deleteAddress(@PathVariable int id) throws SQLException { return authorService.deleteAddress(id);}
}
