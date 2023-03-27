package main.java.laborator4.imutabilitate;

public class Adresa {
    private String strada;
    private int numar;

    public Adresa(String strada, int numar) {
        this.strada = strada;
        this.numar = numar;
    }

    public Adresa(Adresa adresa) {
        this.strada = adresa.strada;
        this.numar = adresa.numar;
    }

    public String getStrada() {
        return strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }


    @Override
    public String toString() {
        return "Adresa{" +
                "strada='" + strada + '\'' +
                ", numar=" + numar +
                '}';
    }
}
