package herman.task2.Task2.dao;

import herman.task2.Task2.model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BookDao {

    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql.stud.iie.ntnu.no:3306/hermata?user=hermata&password=NGliwoCk");
            return con;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getBooks() throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from book");
        String result = "";

        while (rs.next()){
            result += "id: " + rs.getInt(1) + ", title: " + rs.getString(2) + "\n";
        }
        con.close();
        return result;
    }

    public String getBook(int id) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE book_id = " + id);
        String result = "";

        while (rs.next()){
            result += "id: " + rs.getInt(1) + ", title: " + rs.getString(2);
        }
        con.close();

        return result;
    }

    public String createBook(Book book) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO book " + "VALUES (" + book.getId() + ", '" + book.getTitle() + "')");
        con.close();

        return "Book successfully added to database";
    }

    public String updateBook(Book book, int id) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("update book set title = ? where book_id = ?");
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setInt(2, id);

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Book updated succesfully.";
    }

    public String deleteBook(int id) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM book WHERE book_id = " + id);

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Book with id " + id + " was Successfully deleted";
    }

    public String addAuthor(int authorId, int bookId) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO author_book VALUES(" + authorId + ", " + bookId + ")");

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Author was added to book";
    }

    public String findBookByAuthor(int authorId) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT book_id from author_book WHERE author_id = " + authorId);
        String result = "Books written by author with id: " + authorId + ":\n";

        while (rs.next()){
            result += getBook(rs.getInt(1)) + "\n";
        }
        con.close();

        return result;
    }

    public String deleteBookAuthor(int authorId, int bookId) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM author_book WHERE author_id = " + authorId +
                " AND book_id = " + bookId);

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "bookAuthor was successfully deleted.";
    }
}
