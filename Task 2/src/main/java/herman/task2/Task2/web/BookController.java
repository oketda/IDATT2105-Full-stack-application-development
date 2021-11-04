package herman.task2.Task2.web;

import herman.task2.Task2.model.Book;
import herman.task2.Task2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping
    public String getBooks() throws SQLException {

        return bookService.getBooks();
    }

    @PostMapping
    public String createBook(@RequestBody Book book) throws SQLException {
        return bookService.createBook(book);
    }

    @PostMapping("/{id}")
    public String updateBook(@RequestBody Book book, @PathVariable int id) throws SQLException {
        return bookService.updateBook(book, id);
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) throws SQLException {
        return bookService.findBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) throws SQLException {
        return bookService.deleteBook(id);
    }
}
