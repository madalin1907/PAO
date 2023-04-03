package models;

public class Client extends Person{
    private static int idCounter = 0;
    private int id;
    private Address address;

    public Client() {}

    public Client(String name, String phoneNumber, String email, Address address) {
        super(name, phoneNumber, email);
        this.id = ++idCounter;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client {id=" + id + super.toString() + ", address=" + address + '}';
    }
}
