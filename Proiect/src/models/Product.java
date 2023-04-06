package models;

public class Product {
    private static int idCounter = 0;
    private int id;
    protected String name;
    protected Double price;
    protected String description;

    public Product() {}

    public Product(String name, Double price, String description) {
        this.id = ++idCounter;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", price=" + price +
                "RON, description=\"" + description +
                '\"';
    }
}
