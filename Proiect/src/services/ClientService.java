package services;
import models.*;

import java.util.List;
import java.util.Scanner;

public class ClientService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayClients(List<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("\nThere are no clients to display.");
            return;
        }

        System.out.println("\nList of current clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public static void addClient(List<Client> clients) {
        System.out.println("\n--Add a new client--");

        System.out.print("Enter the name of the client:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("Invalid input. Please enter the name of the client:");
            name = scanner.nextLine();
        }

        System.out.print("Enter the phone number of the client:");
        String phoneNumber = scanner.nextLine();
        while (phoneNumber.isEmpty()) {
            System.out.print("Invalid input. Please enter the phone number of the client:");
            phoneNumber = scanner.nextLine();
        }

        System.out.print("Enter the email of the client:");
        String email = scanner.nextLine();
        while (email.isEmpty()) {
            System.out.print("Invalid input. Please enter the email of the client:");
            email = scanner.nextLine();
        }

        System.out.println("--Entering the address of the client--");
        System.out.print("Enter the country of the client:");
        String country = scanner.nextLine();
        while (country.isEmpty()) {
            System.out.print("Invalid input. Please enter the country of the client:");
            country = scanner.nextLine();
        }

        System.out.print("Enter the city of the client:");
        String city = scanner.nextLine();
        while (city.isEmpty()) {
            System.out.print("Invalid input. Please enter the city of the client:");
            city = scanner.nextLine();
        }

        System.out.print("Enter the street of the client:");
        String street = scanner.nextLine();
        while (street.isEmpty()) {
            System.out.print("Invalid input. Please enter the street of the client:");
            street = scanner.nextLine();
        }

        System.out.print("Enter the number of the client:");
        String number = scanner.nextLine();
        while (number.isEmpty()) {
            System.out.print("Invalid input. Please enter the number of the client:");
            number = scanner.nextLine();
        }

        System.out.print("Enter the postal code of the client:");
        String postalCode = scanner.nextLine();
        while (postalCode.isEmpty()) {
            System.out.print("Invalid input. Please enter the postal code of the client:");
            postalCode = scanner.nextLine();
        }

        Client client = new Client(name, phoneNumber, email, new Address(country, city, street, number, postalCode));
        clients.add(client);
        System.out.println("Client added successfully.");
    }

    public static void updateClient(List<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("\nThere are no clients to update.");
            return;
        }

        displayClients(clients);
        System.out.print("Enter the id of the client you want to update:");
        int id;
        do {
            try {
                id = scanner.nextInt();
                break;
            }catch (Exception e) {
                System.out.print("Invalid input. Please enter a number:");
                scanner.nextLine();
            }
        } while (true);
        scanner.nextLine();

        for (Client client : clients) {
            if (client.getId() == id) {
                System.out.println("\n--Updating the client--");

                System.out.print("Enter the name of the client:");
                String name = scanner.nextLine();
                while (name.isEmpty()) {
                    System.out.print("Invalid input. Please enter the name of the client:");
                    name = scanner.nextLine();
                }

                System.out.print("Enter the phone number of the client:");
                String phoneNumber = scanner.nextLine();
                while (phoneNumber.isEmpty()) {
                    System.out.print("Invalid input. Please enter the phone number of the client:");
                    phoneNumber = scanner.nextLine();
                }

                System.out.print("Enter the email of the client:");
                String email = scanner.nextLine();
                while (email.isEmpty()) {
                    System.out.print("Invalid input. Please enter the email of the client:");
                    email = scanner.nextLine();
                }

                System.out.println("--Updating the address of the client--");
                System.out.print("Enter the country of the client:");
                String country = scanner.nextLine();
                while (country.isEmpty()) {
                    System.out.print("Invalid input. Please enter the country of the client:");
                    country = scanner.nextLine();
                }

                System.out.print("Enter the city of the client:");
                String city = scanner.nextLine();
                while (city.isEmpty()) {
                    System.out.print("Invalid input. Please enter the city of the client:");
                    city = scanner.nextLine();
                }

                System.out.print("Enter the street of the client:");
                String street = scanner.nextLine();
                while (street.isEmpty()) {
                    System.out.print("Invalid input. Please enter the street of the client:");
                    street = scanner.nextLine();
                }

                System.out.print("Enter the number of the client:");
                String number = scanner.nextLine();
                while (number.isEmpty()) {
                    System.out.print("Invalid input. Please enter the number of the client:");
                    number = scanner.nextLine();
                }

                System.out.print("Enter the postal code of the client:");
                String postalCode = scanner.nextLine();
                while (postalCode.isEmpty()) {
                    System.out.print("Invalid input. Please enter the postal code of the client:");
                    postalCode = scanner.nextLine();
                }

                client.setName(name);
                client.setPhoneNumber(phoneNumber);
                client.setEmail(email);
                client.setAddress(new Address(country, city, street, number, postalCode));

                System.out.println("Client updated successfully.");
                return;
            }
        }
    }

    public static void deleteClient(List<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("\nThere are no clients to delete.");
            return;
        }

        displayClients(clients);
        System.out.print("Enter the id of the client you want to delete:");
        int id;
        do {
            try {
                id = scanner.nextInt();
                break;
            }catch (Exception e) {
                System.out.print("Invalid input. Please enter a number:");
                scanner.nextLine();
            }
        } while (true);
        scanner.nextLine();

        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                System.out.println("\nClient deleted successfully.");
                return;
            }
        }

        System.out.println("\nClient not found.");
    }

    public static Client getClientById(List<Client> clients, int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
