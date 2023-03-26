package main.java.laborator3.candies;

import main.java.laborator3.candies.CandyBox;

public class Heidi extends CandyBox {
    private float side;

    public Heidi() {
    }

    public Heidi(String flavor, String origin, float side) {
        super(flavor, origin);
        this.side = side;
    }

    @Override
    public float getVolume() {
        return (float) Math.pow(this.side, 3);
    }

    @Override
    public String toString() {
        return "The " + this.flavor + " flavour from " + this.origin + " has volume " + this.getVolume() + ".";
    }

    void printHeidiDim() {
        System.out.println("side = " + this.side);
    }
}
