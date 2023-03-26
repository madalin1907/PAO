package main.java.laborator3.candies;

public class Main {
    public static void main(String[] args) {
        CandyBox a = new CandyBox("Strawberry", "Romania");
        System.out.println(a);

        Lindt b = new Lindt("Strawberry", "Romania", 1, 2, 3);
        System.out.print(b + " Dimensions: " );
        b.printLindtDim();

        Milka c = new Milka("Strawberry", "Romania", 1, 2);
        System.out.print(c + " Dimensions: ");
        c.printMilkaDim();

        Heidi d = new Heidi("Strawberry", "Romania", 3);
        System.out.print(d + " Dimensions: " );
        d.printHeidiDim();

        // exercitiul 3
        System.out.println("\nExercitiul 3: ");
        CandyBox[] boxes = {a, b, c, d};
        for (int i = 0; i < boxes.length - 1; i++) {
            System.out.print(boxes[i].origin + " " + boxes[i].flavor);
            System.out.print(boxes[i].equals(boxes[i + 1]) ? " is equal to " : " is not equal to ");
            System.out.println(boxes[i + 1].origin + " " + boxes[i + 1].flavor);
        }


        // exercitiul 4
        System.out.println("\nExercitiul 4:");

        CandyBox e = new Lindt("Strawberry", "Greece", 1, 2, 3);
        CandyBox f = new Lindt("Orange", "Greece", 1, 2, 3);
        CandyBox g = new Lindt("Strawberry", "Romania", 1, 2, 5);

        CandyBox[] boxes2 = {a, b, c, d, e, f, g};
        CandyBag candyBag = new CandyBag(boxes2);
        Lindt[] lindtBags = candyBag.getLindtBags();
        int lindtLength = lindtBags.length;

        for (int i = 0; i < lindtLength - 1; i++) {
            for (int j = i + 1; j < lindtLength; j++) {
                System.out.print(lindtBags[i].origin + " " + lindtBags[i].flavor);
                System.out.print(lindtBags[i].equals(lindtBags[j]) ? " is equal to " : " is not equal to ");
                System.out.println(lindtBags[j].origin + " " + lindtBags[j].flavor);
            }
        }
    }
}

