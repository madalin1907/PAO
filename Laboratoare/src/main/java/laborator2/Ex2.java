package main.java.laborator2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        /* Cititi de la tastatura 2 valori: numele si varsta
           Afisati numele
           Daca varsta este impara, afisati toate nr impare <= varsta
           Daca varsta este para, afisati toate nr pare <= varsta
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();

        System.out.println("Introduceti varsta: ");
        int varsta = scanner.nextInt();

        System.out.println("Numele introdus este: " + nume);

        if (varsta % 2 == 0) {
            for (int i = 0; i <= varsta; i += 2) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 1; i <= varsta; i += 2) {
                System.out.print(i + " ");
            }
        }
    }
}
