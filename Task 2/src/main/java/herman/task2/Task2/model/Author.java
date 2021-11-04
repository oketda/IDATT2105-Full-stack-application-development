package herman.task2.Task2.model;



public class Author {

    int id;
    String firstName;
    String lastName;
    int age;
    Address address;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) { this.age = age; }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() { return age; }

    public Address getAddress() {
        return address;
    }
}
