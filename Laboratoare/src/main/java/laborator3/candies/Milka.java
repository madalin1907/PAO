package main.java.laborator3.candies;

import main.java.laborator3.candies.CandyBox;

public class Milka extends CandyBox {
    private float radius;
    private float height;

    public Milka() {
    }

    public Milka(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return (float) (Math.PI * Math.pow(this.radius, 2) * this.height);
    }

    @Override
    public String toString() {
        return "The " + this.flavor + " flavour from " + this.origin + " has volume " + this.getVolume() + ".";
    }

    void printMilkaDim() {
        System.out.println("radius = " + this.radius + " height = " + this.height);
    }
}
