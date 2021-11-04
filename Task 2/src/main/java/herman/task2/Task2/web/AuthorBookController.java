package herman.task2.Task2.web;

import herman.task2.Task2.model.Book;
import herman.task2.Task2.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@ RestController
@RequestMapping("/authorbooks")
public class AuthorBookController {

    @Autowired
    public AuthorBookService authorBookService;

    @PostMapping("/{authorId}/{bookId}")
    public String createAuthorBook(@PathVariable int authorId, @PathVariable int bookId) throws SQLException {
        return authorBookService.createAuthorBook(authorId, bookId);
    }

    @GetMapping("/{id}")
    public String findBookByAuthor(@PathVariable int id) throws SQLException {
        return authorBookService.findBookByAuthor(id);
    }

    @DeleteMapping("/{authorId}/{bookId}")
    public String deleteAuthorBook(@PathVariable int authorId, @PathVariable int bookId) throws SQLException {
        return authorBookService.deleteBookAuthor(authorId, bookId);
    }
}
