package models;

public class Drink extends Product{
    private boolean isAlcoholic;
    private Integer volume; // in milliliters

    public Drink() {}

    public Drink(String name, Double price, String description, boolean isAlcoholic, Integer volume) {
        super(name, price, description);
        this.isAlcoholic = isAlcoholic;
        this.volume = volume;
    }

    public boolean isIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Drink {" + super.toString() + ", isAlcoholic=" + isAlcoholic + ", volume=" + volume + "ml}";
    }
}
