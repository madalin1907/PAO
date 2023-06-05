package services;

import repositories.ClientRepository;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void displayClients() {
        System.out.println("\nYou chose \"Display all clients\" option.");
        clientRepository.displayClients();
    }

    public void addClient() {
        System.out.println("\nYou chose \"Add a new client\" option.");
        clientRepository.addClient();
    }

    public void updateClient() {
        System.out.println("\nYou chose \"Update a client\" option.");
        clientRepository.updateClient();
    }

    public void deleteClient() {
        System.out.println("\nYou chose \"Delete a client\" option.");
        clientRepository.deleteClient();
    }
}
