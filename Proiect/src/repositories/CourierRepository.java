package repositories;

import database.DBConnection;
import services.AuditService;

import java.sql.PreparedStatement;

import java.util.Scanner;


public class CourierRepository {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuditService auditService = new AuditService();

    public boolean displayCouriers() {
        String sqlCommand = "SELECT * FROM courier";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("\nThere are no couriers in the database at this moment.");
                return false;
            }

            while (result.next()) {
                System.out.println("\n------------------- COURIER ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Phone number: " + result.getString("phoneNumber"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("Rating: " + result.getDouble("rating"));
                System.out.println("Vehicle: " + result.getString("vehicle"));
            }

            auditService.addLog("Display all couriers");
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to access couriers: " + e.getMessage());
            return false;
        }
    }

    public void addCourier() {
        String sqlCommand = "INSERT INTO courier (name, phoneNumber, email, rating, vehicle) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            System.out.println("\n------ADDING A NEW COURIER------");

            System.out.print("Enter the name of the courier:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter the name of the courier:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the phone number of the courier:");
            String phoneNumber = scanner.nextLine();
            while (phoneNumber.isEmpty()) {
                System.out.print("Invalid input. Please enter the phone number of the courier:");
                phoneNumber = scanner.nextLine();
            }

            System.out.print("Enter the email of the courier:");
            String email = scanner.nextLine();
            while (email.isEmpty()) {
                System.out.print("Invalid input. Please enter the email of the courier:");
                email = scanner.nextLine();
            }

            System.out.print("Enter the rating of the courier:");
            double rating;
            do {
                try {
                    rating = scanner.nextDouble();
                    if (rating < 1 || rating > 5) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a double between 1 and 5:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            System.out.print("Enter the vehicle of the courier:");
            String vehicle = scanner.nextLine();
            while (vehicle.isEmpty()) {
                System.out.print("Invalid input. Please enter the vehicle of the courier:");
                vehicle = scanner.nextLine();
            }

            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setDouble(4, rating);
            statement.setString(5, vehicle);

            statement.executeUpdate();
            System.out.println("\nThe courier was added successfully!");
            auditService.addLog("Add a new courier");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to add a new courier: " + e.getMessage());
        }
    }

    public void updateCourier() {
        String sqlCommand = "UPDATE courier SET name = ?, phoneNumber = ?, email = ?, rating = ?, vehicle = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayCouriers()) {
                return;
            }

            System.out.println("\nEnter the ID of the courier you want to update:");
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

            // check if the courier exists
            String sqlCommand2 = "SELECT * FROM courier WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.isBeforeFirst()) {
                    System.out.println("\nThere is no courier with the ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access couriers: " + e.getMessage());
                return;
            }

            System.out.println("\n------UPDATING COURIER WITH ID = " + id + "------");

            System.out.print("Enter the name of the courier:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter the name of the courier:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the phone number of the courier:");
            String phoneNumber = scanner.nextLine();
            while (phoneNumber.isEmpty()) {
                System.out.print("Invalid input. Please enter the phone number of the courier:");
                phoneNumber = scanner.nextLine();
            }

            System.out.print("Enter the email of the courier:");
            String email = scanner.nextLine();
            while (email.isEmpty()) {
                System.out.print("Invalid input. Please enter the email of the courier:");
                email = scanner.nextLine();
            }

            System.out.print("Enter the rating of the courier:");
            double rating;
            do {
                try {
                    rating = scanner.nextDouble();
                    if (rating < 1 || rating > 5) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a double between 1 and 5:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            System.out.print("Enter the vehicle of the courier:");
            String vehicle = scanner.nextLine();
            while (vehicle.isEmpty()) {
                System.out.print("Invalid input. Please enter the vehicle of the courier:");
                vehicle = scanner.nextLine();
            }

            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setDouble(4, rating);
            statement.setString(5, vehicle);
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println("\nThe courier was updated successfully!");
            auditService.addLog("Update a courier");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to update a courier: " + e.getMessage());
        }
    }

    public void deleteCourier() {
        String sqlCommand = "DELETE FROM courier WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayCouriers()) {
                return;
            }

            System.out.print("\nEnter the ID of the courier you want to delete:");
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

            // check if the courier exists
            String sqlCommand2 = "SELECT * FROM courier WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.isBeforeFirst()) {
                    System.out.println("\nThere is no courier with the ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access couriers: " + e.getMessage());
                return;
            }

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("\nThe courier was deleted successfully!");
            auditService.addLog("Delete a courier");

            // reset the auto increment
            String sqlCommand3 = "ALTER TABLE courier AUTO_INCREMENT = 1";
            try (PreparedStatement statement3 = DBConnection.getInstance().prepareStatement(sqlCommand3)) {
                statement3.executeUpdate();
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to reset the auto increment: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to delete the courier: " + e.getMessage());
        }
    }
}
