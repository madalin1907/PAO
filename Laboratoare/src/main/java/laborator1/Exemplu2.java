package main.java.laborator1;

public class Exemplu2 {
    public static void main (String[] args) {
        Exemplu1.main(null);

        Exemplu1 obiect1 = new Exemplu1();
        obiect1.setNumarLaborator(1);
        obiect1.main(null); // -> se poate, dar nu este recomandat
        // Exemplu1.setNumarLaborator(69); -> nu se poate

        System.out.println(obiect1.getNumarLaborator()); // 1
        System.out.println(obiect1.numarLaborator); // 1

        Exemplu1 obiect2 = new Exemplu1();
        obiect2.setNumarLaborator(2);
        System.out.println(obiect2.numarLaborator); // 2

        Exemplu1 obiect3 = new Exemplu1();
        System.out.println(obiect3.numarLaborator); // 0
    }

}
