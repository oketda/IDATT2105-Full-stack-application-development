package web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import herman.task2.Task2.Task2Application;
import herman.task2.Task2.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@RunWith(SpringRunner.class) // JUnit
@SpringBootTest(webEnvironment = MOCK, classes = Task2Application.class) // Spring
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void startUp(){

    }

    @Test
    public void shouldReturnFirstBook() throws Exception {
        this.mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("id: 1, title: test2"))
                .andReturn();
    }

    @Test
    public void shouldReturnSuccessfullString() throws Exception {
        Book book = new Book();
        book.setId(0);
        book.setTitle("test");
        String json = objectMapper.writeValueAsString(book);

        this.mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Book successfully added to database"))
                .andReturn();
    }

    @Test
    public void shouldUpdateAndReturnString() throws Exception {
        Book book = new Book();
        book.setId(0);
        book.setTitle("test2");
        String json = objectMapper.writeValueAsString(book);

        this.mockMvc.perform(post("/books/1")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Book updated succesfully."))
                .andReturn();
    }

    @Test
    public void shouldDeleteAndReturnString() throws Exception {

        this.mockMvc.perform(delete("/books/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book with id 10 was Successfully deleted"))
                .andReturn();
    }
}
