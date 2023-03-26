package main.java.laborator2;

import java.util.Arrays;

public class Ex3 {
    public static void main (String[] args) {
        int [] ar1;
        int ar2 [], i3, ar3[][], i4[];

        int[] array1 = {1, 3, 5, 7};
        int[] array2 = new int[6];
        int[] array3 = new int[] {1, 3, 5, 7};
        int[] array4 = array2;

        System.out.println(array4);

        System.out.println("\ncomparatie referinte: " + (array1 == array3));
        System.out.println("comparatie continut: " + Arrays.compare(array1, array3));
        System.out.println("comparatie obiecte: " + Arrays.equals(array1, array3));

        System.out.print("\narray1: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.print("\narray4: ");
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
        }

    }
}
