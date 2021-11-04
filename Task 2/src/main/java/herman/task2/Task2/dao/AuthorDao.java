package herman.task2.Task2.dao;

import herman.task2.Task2.model.Author;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AuthorDao {

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

    public String getAuthors() throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from author");
        String result = "";

        while (rs.next()){
            result += "id: " + rs.getInt(1) + ", first name: " + rs.getString(2) + ", last name: " +
                    rs.getString(3) + ", age: " + rs.getInt(4) + "\n";
        }
        con.close();
        return result;
    }

    public String getAuthor(int id) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM author WHERE author_id = " + id);
        String result = "";

        while (rs.next()){
            result += "id: " + rs.getInt(1) + ", first name: " + rs.getString(2) + ", last name: " +
                    rs.getString(3) + ", age: " + rs.getInt(4);
        }
        con.close();

        return result;
    }

    public String createAuthor(Author author) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO author " + "VALUES (" + author.getId() + ", '" + author.getFirstName() + "', '" +
                        author.getLastName() + "', " + author.getAge() + ", " + null + ")");
        con.close();

        return "Author successfully added to database";
    }

    public String updateAuthor(Author authorObject, int id) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement(
                "update author set first_name = ?, last_name = ?, age = ? where author_id = " + id);
        preparedStatement.setString(1, authorObject.getFirstName());
        preparedStatement.setString(2, authorObject.getLastName());
        preparedStatement.setInt(3, authorObject.getAge());

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Author updated succesfully. " + authorObject.getLastName();
    }

    public String deleteAuthor(int id) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM author WHERE author_id = " + id);

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Author with id " + id + " was Successfully deleted";
    }
}
