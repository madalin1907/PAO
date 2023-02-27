package main.java.laborator1;

public class Exemplu4 {
    public static void main(String[] args) {
        System.out.println(5 % 4);

        int a = 5;
        int b = 6;
        System.out.println(a == b);

        boolean c = 5 == 5;
        System.out.println(c);

        int d = (a == b) ? 100 : (c == true ? 500 : 0);
        System.out.println(d);
    }
}
