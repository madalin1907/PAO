package models;

public class Courier extends Person{
    private static int idCounter = 0;
    private int id;
    private Double rating;
    private String vehicle;

    public Courier() {}

    public Courier(String name, String phoneNumber, String email, Double rating, String vehicle) {
        super(name, phoneNumber, email);
        this.id = ++idCounter;
        this.rating = rating;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Courier {id=" + id + super.toString() + ", rating=" + rating + ", vehicle=" + vehicle + '}';
    }
}
