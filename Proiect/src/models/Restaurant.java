package models;

public class Restaurant {
    private static int idCounter = 0;
    private int id;
    private String name;
    private Address address;
    private Double rating;

    public Restaurant() {}

    public Restaurant(String name, Address address, Double rating) {
        this.id = ++idCounter;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant {" +
                "name=" + name +
                ", address=" + address +
                ", rating=" + rating +
                '}';
    }
}
