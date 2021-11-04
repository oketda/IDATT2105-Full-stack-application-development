package herman.task2.Task2.model;

public class Address {

    int id;
    String street;
    String streetNr;
    int postalCode;
    String city;

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city){ this.city = city;}

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() { return city; }
}
