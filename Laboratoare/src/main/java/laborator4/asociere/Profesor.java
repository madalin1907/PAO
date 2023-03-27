package main.java.laborator4.asociere;

public class Profesor {
    private int id;
    private String nume;

    public Profesor(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "\nProfesor {" + "id=" + id + ", nume='" + nume + '\'' + "}";
    }
}
