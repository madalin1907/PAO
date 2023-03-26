package main.java.laborator3.candies;

public class CandyBag {
    private CandyBox[] candyBoxes;

    public CandyBag() {
    }

    public CandyBag(CandyBox[] candyBoxes) {
        this.candyBoxes = candyBoxes;
    }

    public Lindt[] getLindtBags() {
        int count = 0;
        for (CandyBox candyBox : this.candyBoxes) {
            if (candyBox instanceof Lindt) {
                ++count;
            }
        }

        Lindt[] lindtBags = new Lindt[count];
        int index = 0;
        for (CandyBox candyBox : this.candyBoxes) {
            if (candyBox instanceof Lindt) {
                lindtBags[index] = (Lindt) candyBox;
                index++;
            }
        }

        return lindtBags;
    }


}
