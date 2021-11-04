package herman.task2.Task2.model;

import herman.task2.Task2.model.Author;

import java.util.ArrayList;

public class Book {

    int id;
    String title;
    ArrayList<Author> authors = new ArrayList<>();

    public void setId(int id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setAuthors(ArrayList<Author> authors) { this.authors = authors; }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
}
