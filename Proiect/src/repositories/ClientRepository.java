package repositories;

import database.DBConnection;
import services.AuditService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.Scanner;

public class ClientRepository {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuditService auditService = new AuditService();

    public boolean displayClients() {
        String sqlCommand = "SELECT * FROM client";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("\nThere are no clients in the database at this moment.");
                return false;
            }

            while (result.next()) {
                System.out.println("\n------------------- CLIENT ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Phone number: " + result.getString("phoneNumber"));
                System.out.println("Email: " + result.getString("email"));

                int addressId = result.getInt("addressId");
                String sqlCommand2 = "SELECT * FROM address WHERE id = ?";
                try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                    statement2.setInt(1, addressId);
                    var result2 = statement2.executeQuery();

                    while (result2.next()) {
                        System.out.println("Address: " + result2.getString("country") + ", " + result2.getString("city") + ", " + result2.getString("street") + ", " + result2.getString("number") + ", " + result2.getString("postalCode"));
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong when trying to access addresses: " + e.getMessage());
                    return false;
                }
            }

            auditService.addLog("Display all clients");
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to access clients: " + e.getMessage());
            return false;
        }
    }


    public void addClient() {
        String sqlCommand = "INSERT INTO client (name, phoneNumber, email, addressId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            System.out.println("\n------ADDING A NEW CLIENT------");

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

            System.out.println("Enter the address of the client:");
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

            // create the address
            String sqlCommand2 = "INSERT INTO address (country, city, street, number, postalCode) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2, Statement.RETURN_GENERATED_KEYS)) {
                statement2.setString(1, country);
                statement2.setString(2, city);
                statement2.setString(3, street);
                statement2.setString(4, number);
                statement2.setString(5, postalCode);

                statement2.executeUpdate();

                ResultSet generatedKeys = statement2.getGeneratedKeys();
                int addressId;
                if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating address failed, no ID obtained.");
                }

                statement.setString(1, name);
                statement.setString(2, phoneNumber);
                statement.setString(3, email);
                statement.setInt(4, addressId);

                statement.executeUpdate();
                System.out.println("Client added successfully!");
                auditService.addLog("Add a new client");

            } catch (Exception e) {
                System.out.println("Something went wrong when trying to add a new address: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to add a new client: " + e.getMessage());
        }
    }


    public void updateClient() {
        String sqlCommand = "UPDATE client SET name = ?, phoneNumber = ?, email = ?, addressId = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayClients()) {
                return;
            }

            System.out.print("\nEnter the ID of the client you want to update:");
            int id;
            do {
                try {
                    id = scanner.nextInt();
                    if (id <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            // check if the client exists
            int clientAddressId;
            String sqlCommand2 = "SELECT * FROM client WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();

                if (!result.next()) {
                    System.out.println("The client with the specified ID does not exist!");
                    return;
                }

                clientAddressId = result.getInt("addressId");
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access clients: " + e.getMessage());
                return;
            }

            System.out.println("\n------UPDATING CLIENT WITH ID " + id + "------");

            System.out.print("Enter the new name of the client:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter the new name of the client:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the new phone number of the client:");
            String phoneNumber = scanner.nextLine();
            while (phoneNumber.isEmpty()) {
                System.out.print("Invalid input. Please enter the new phone number of the client:");
                phoneNumber = scanner.nextLine();
            }

            System.out.print("Enter the new email of the client:");
            String email = scanner.nextLine();
            while (email.isEmpty()) {
                System.out.print("Invalid input. Please enter the new email of the client:");
                email = scanner.nextLine();
            }

            System.out.println("Enter the new address of the client:");

            System.out.print("Enter the new country of the client:");
            String country = scanner.nextLine();
            while (country.isEmpty()) {
                System.out.print("Invalid input. Please enter the new country of the client:");
                country = scanner.nextLine();
            }

            System.out.print("Enter the new city of the client:");
            String city = scanner.nextLine();
            while (city.isEmpty()) {
                System.out.print("Invalid input. Please enter the new city of the client:");
                city = scanner.nextLine();
            }

            System.out.print("Enter the new street of the client:");
            String street = scanner.nextLine();
            while (street.isEmpty()) {
                System.out.print("Invalid input. Please enter the new street of the client:");
                street = scanner.nextLine();
            }

            System.out.print("Enter the new number of the client:");
            String number = scanner.nextLine();
            while (number.isEmpty()) {
                System.out.print("Invalid input. Please enter the new number of the client:");
                number = scanner.nextLine();
            }

            System.out.print("Enter the new postal code of the client:");
            String postalCode = scanner.nextLine();
            while (postalCode.isEmpty()) {
                System.out.print("Invalid input. Please enter the new postal code of the client:");
                postalCode = scanner.nextLine();
            }

            // edit the address
            String sqlCommand3 = "UPDATE address SET country = ?, city = ?, street = ?, number = ?, postalCode = ? WHERE id = ?";
            try (PreparedStatement statement3 = DBConnection.getInstance().prepareStatement(sqlCommand3)) {
                statement3.setString(1, country);
                statement3.setString(2, city);
                statement3.setString(3, street);
                statement3.setString(4, number);
                statement3.setString(5, postalCode);
                statement3.setInt(6, clientAddressId);

                statement3.executeUpdate();
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to update the address: " + e.getMessage());
                return;
            }

            // update the client
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setInt(4, clientAddressId);
            statement.setInt(5, id);

            statement.executeUpdate();
            System.out.println("Client updated successfully!");
            auditService.addLog("Update a client");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to update a client: " + e.getMessage());
        }
    }


    public void deleteClient() {
        String sqlCommand = "DELETE FROM drink WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayClients()) {
                return;
            }

            System.out.print("\nEnter the ID of the client you want to delete:");
            int id;
            do {
                try {
                    id = scanner.nextInt();
                    if (id <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            // check if the client exists
            int clientAddressId;
            String sqlCommand2 = "SELECT * FROM client WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();

                if (!result.next()) {
                    System.out.println("The client with the specified ID does not exist!");
                    return;
                }

                clientAddressId = result.getInt("addressId");
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access clients: " + e.getMessage());
                return;
            }

            // delete the client
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Client deleted successfully!");
            auditService.addLog("Delete a client");

            // delete the address
            String sqlCommand3 = "DELETE FROM address WHERE id = ?";
            try (PreparedStatement statement3 = DBConnection.getInstance().prepareStatement(sqlCommand3)) {
                statement3.setInt(1, clientAddressId);
                statement3.executeUpdate();
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to delete an address: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to delete a client: " + e.getMessage());
        }
    }
}