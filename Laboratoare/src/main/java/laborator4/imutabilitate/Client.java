package main.java.laborator4.imutabilitate;

public class Client {
    private Adresa adresa;

    public Client(Adresa adresa) {
        this.adresa = new Adresa(adresa);
    }

    public Adresa getAdresa() {
        return adresa;
    }

    @Override
    public String toString() {
        return "Client{" +
                "adresa=" + adresa +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
