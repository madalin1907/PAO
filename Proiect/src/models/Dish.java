package models;

import java.util.Arrays;

public class Dish extends Product{
    private String[] ingredients;
    private Integer weight; // in grams

    public Dish() {}

    public Dish(String name, Double price, String description, String[] ingredients, Integer weight) {
        super(name, price, description);
        this.ingredients = ingredients;
        this.weight = weight;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish {" + super.toString() + ", ingredients=" + Arrays.toString(ingredients) + ", weight=" + weight + "g}";
    }
}
