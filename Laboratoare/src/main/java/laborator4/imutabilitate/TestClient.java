package main.java.laborator4.imutabilitate;

public class TestClient {
    public static void main(String[] args) {
        Adresa adresa = new Adresa("Iuliu Maniu", 33);
        Client client = new Client(adresa);
        System.out.println("Client inainte de modificare" + client);

        Adresa badAddress = client.getAdresa();
        badAddress.setNumar(66);
        adresa.setNumar(100);
        System.out.println("Client dupa modificare: " + client);

        ClientRecord clientRecord = new ClientRecord(adresa);
        System.out.println(clientRecord.adresa());
        System.out.println(clientRecord.toString());
    }
}
