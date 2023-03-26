package main.java.laborator3.arrays;

public class Test {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(2);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Expected value: 1.0, Actual value: " + list.get(0));
        System.out.println("Expected value: 2.0, Actual value: " + list.get(1));
        System.out.println("Expected value: 3.0, Actual value: " + list.get(2));

        System.out.println("\n" + list);
        System.out.println("List size: " + list.size() + "\n");

        list.add(4);
        System.out.println(list.remove(2));
        list.add(5);
        System.out.println(list + "\n");

        list.add(6);
        System.out.println(list);
        System.out.println("List contains value 6: " + list.contains(6));

    }
}
