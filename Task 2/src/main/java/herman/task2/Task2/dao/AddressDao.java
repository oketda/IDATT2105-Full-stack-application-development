package herman.task2.Task2.dao;

import herman.task2.Task2.model.Address;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AddressDao {

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

    ArrayList<Address> addresses = new ArrayList<>();
    AtomicInteger addressID = new AtomicInteger(-1);

    public String getAddresses() throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from address");
        String result = "";

        while (rs.next()){
            result += "id: " + rs.getInt(1) + ", street: " + rs.getString(2) + ", street number: " +
                    rs.getString(3) + ", postal code: " + rs.getInt(4) + ", city: " + rs.getString(5) + "\n";
        }
        con.close();
        return result;
    }

    public String createAddress(Address address) throws SQLException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO address " + "VALUES (" +address.getId() + ", '" + address.getStreet() + "', '" +
                address.getStreetNr() + "', " + address.getPostalCode() + ", " + address.getCity() + ")");
        con.close();

        return "Address successfully added to database";
    }

    public String deleteAddress(int id) throws SQLException {
        Connection con = connect();
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM address WHERE address_id = " + id);

        try {
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();

        return "Address with id " + id + " was Successfully deleted";
    }
}
