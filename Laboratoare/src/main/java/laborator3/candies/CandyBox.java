package main.java.laborator3.candies;

import java.util.Objects;

public class CandyBox {
    protected String flavor;
    protected String origin;

    public CandyBox() {
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    public String toString() {
        return "The " + this.flavor + " flavour is from " + this.origin + ".";
    }

    boolean equals(CandyBox other) {
        return Objects.equals(this.flavor, other.flavor) && Objects.equals(this.origin, other.origin);
    }

}
