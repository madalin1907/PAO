package models;

import java.util.Arrays;

public class Order {
    private static int idCounter = 0;
    private int id;
    private Client client;
    private Restaurant restaurant;
    private Product[] products;
    private Double totalPrice;
    private String status;

    public Order() {}

    public Order(Client client, Restaurant restaurant, Product[] products, Double totalPrice, String status) {
        this.id = ++idCounter;
        this.client = client;
        this.restaurant = restaurant;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ",\n  client=" + client +
                ",\n  restaurant=" + restaurant +
                ",\n  products=" + Arrays.toString(products) +
                '}';
    }
}
