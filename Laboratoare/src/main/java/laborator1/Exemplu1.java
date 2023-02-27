package main.java.laborator1;

public class Exemplu1 {
    // membrii unei clase: campuri si metode


    /*
        public - cel mai permisiv
        private - cel mai restrictiv
        default-package - accesibil doar din acelasi pachet
        protected - vizibil in acelasi pachet si in alt pachet prin mostenire
     */


    protected int numarLaborator;
    public int getNumarLaborator() {
        return numarLaborator;
    }

    public void setNumarLaborator(int numarLaborator) {
        this.numarLaborator = numarLaborator;
    }

    /**
     * metoda main = entry point
     * @param args lista de parametri pasati aplicatiei la run
     */



    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
