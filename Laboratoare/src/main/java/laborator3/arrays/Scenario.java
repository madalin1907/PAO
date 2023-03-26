package main.java.laborator3.arrays;

public class Scenario {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5);

        for (int i = 0; i < 10; i++) {
            float x = (int) (Math.random() * 49) + 1;
            list.add(x);
        }

        System.out.println(list);

        for (int i = 0; i < 5; ++i) {
            float x = (int) (Math.random() * 49) + 1;
            System.out.println("Array contains value " + x + ": " + list.contains(x));
        }

        for (int i = 0; i < 5; ++i) {
            int x = (int) (Math.random() * 20);
            System.out.println("Trying to remove element at index " + x + ": " + list.remove(x));
        }
    }
}
