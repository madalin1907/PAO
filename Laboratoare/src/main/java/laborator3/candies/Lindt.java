package main.java.laborator3.candies;

import main.java.laborator3.candies.CandyBox;

public class Lindt extends CandyBox {
private float length;
    private float width;
    private float height;

    public Lindt() {
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return "The " + this.flavor + " flavour from " + this.origin + " has volume " + this.getVolume() + ".";
    }

    void printLindtDim() {
        System.out.println("length = " + this.length + " width = " + this.width + " height = " + this.height);
    }
    
}
