package repositories;

import services.AuditService;
import database.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class RestaurantRepository {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuditService auditService = new AuditService();

    public boolean displayRestaurants() {
        String sqlCommand = "SELECT * FROM restaurant";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("\nThere are no restaurants in the database at this moment.");
                return false;
            }

            while (result.next()) {
                System.out.println("\n------------------- RESTAURANT ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Rating: " + result.getDouble("rating"));

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

            auditService.addLog("Display all restaurants");
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to access restaurants: " + e.getMessage());
            return false;
        }
    }

    public void addRestaurant() {
        String sqlCommand = "INSERT INTO restaurant (name, rating, addressId) VALUES (?, ?, ?)";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            System.out.println("\n------ADDING A NEW RESTAURANT------");

            System.out.print("Enter the name of the restaurant:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter the name of the restaurant:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the rating of the restaurant:");
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

            System.out.println("Enter the address of the restaurant:");
            System.out.print("Enter the country of the restaurant:");
            String country = scanner.nextLine();
            while (country.isEmpty()) {
                System.out.print("Invalid input. Please enter the country of the restaurant:");
                country = scanner.nextLine();
            }

            System.out.print("Enter the city of the restaurant:");
            String city = scanner.nextLine();
            while (city.isEmpty()) {
                System.out.print("Invalid input. Please enter the city of the restaurant:");
                city = scanner.nextLine();
            }

            System.out.print("Enter the street of the restaurant:");
            String street = scanner.nextLine();
            while (street.isEmpty()) {
                System.out.print("Invalid input. Please enter the street of the restaurant:");
                street = scanner.nextLine();
            }

            System.out.print("Enter the number of the restaurant:");
            String number = scanner.nextLine();
            while (number.isEmpty()) {
                System.out.print("Invalid input. Please enter the number of the restaurant:");
                number = scanner.nextLine();
            }

            System.out.print("Enter the postal code of the restaurant:");
            String postalCode = scanner.nextLine();
            while (postalCode.isEmpty()) {
                System.out.print("Invalid input. Please enter the postal code of the restaurant:");
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
                statement.setDouble(2, rating);
                statement.setInt(3, addressId);

                statement.executeUpdate();
                System.out.println("The restaurant was added successfully!");
                auditService.addLog("Add a new restaurant");

            } catch (Exception e) {
                System.out.println("Something went wrong when trying to add a new address: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to add a new restaurant: " + e.getMessage());
        }
    }

    public void updateRestaurant() {
        String sqlCommand = "UPDATE restaurant SET name = ?, rating = ?, addressId = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayRestaurants()) {
                return;
            }

            System.out.print("\nEnter the id of the restaurant you want to update:");
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

            // check if the restaurant exists
            int restaurantAddressId;
            String sqlCommand2 = "SELECT * FROM restaurant WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();

                if (!result.next()) {
                    System.out.println("There is no restaurant with the given id!");
                    return;
                }

                restaurantAddressId = result.getInt("addressId");
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access restaurants: " + e.getMessage());
                return;
            }

            System.out.println("\n------UPDATING THE RESTAURANT WITH ID " + id + "------");

            System.out.print("Enter the new name of the restaurant:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter the new name of the restaurant:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the new rating of the restaurant:");
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

            System.out.println("Enter the new address of the restaurant:");

            System.out.print("Enter the new country of the restaurant:");
            String country = scanner.nextLine();
            while (country.isEmpty()) {
                System.out.print("Invalid input. Please enter the new country of the restaurant:");
                country = scanner.nextLine();
            }

            System.out.print("Enter the new city of the restaurant:");
            String city = scanner.nextLine();
            while (city.isEmpty()) {
                System.out.print("Invalid input. Please enter the new city of the restaurant:");
                city = scanner.nextLine();
            }

            System.out.print("Enter the new street of the restaurant:");
            String street = scanner.nextLine();
            while (street.isEmpty()) {
                System.out.print("Invalid input. Please enter the new street of the restaurant:");
                street = scanner.nextLine();
            }

            System.out.print("Enter the new number of the restaurant:");
            String number = scanner.nextLine();
            while (number.isEmpty()) {
                System.out.print("Invalid input. Please enter the new number of the restaurant:");
                number = scanner.nextLine();
            }

            System.out.print("Enter the new postal code of the restaurant:");
            String postalCode = scanner.nextLine();
            while (postalCode.isEmpty()) {
                System.out.print("Invalid input. Please enter the new postal code of the restaurant:");
                postalCode = scanner.nextLine();
            }

            // update the address
            String sqlCommand3 = "UPDATE address SET country = ?, city = ?, street = ?, number = ?, postalCode = ? WHERE id = ?";
            try (PreparedStatement statement3 = DBConnection.getInstance().prepareStatement(sqlCommand3)) {
                statement3.setString(1, country);
                statement3.setString(2, city);
                statement3.setString(3, street);
                statement3.setString(4, number);
                statement3.setString(5, postalCode);
                statement3.setInt(6, restaurantAddressId);

                statement3.executeUpdate();
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to update the address: " + e.getMessage());
                return;
            }

            // update the restaurant
            statement.setString(1, name);
            statement.setDouble(2, rating);
            statement.setInt(3, restaurantAddressId);
            statement.setInt(4, id);

            statement.executeUpdate();
            System.out.println("The restaurant was updated successfully!");
            auditService.addLog("Update a restaurant");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to update a restaurant: " + e.getMessage());
        }
    }

    public void deleteRestaurant() {
        String sqlCommand = "DELETE FROM restaurant WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayRestaurants()) {
                return;
            }

            System.out.print("\nEnter the ID of the restaurant you want to delete:");
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

            // check if the restaurant exists
            int restaurantAddressId;
            String sqlCommand2 = "SELECT * FROM restaurant WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();

                if (!result.next()) {
                    System.out.println("There is no restaurant with the given id!");
                    return;
                }

                restaurantAddressId = result.getInt("addressId");
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access restaurants: " + e.getMessage());
                return;
            }

            // delete the restaurant
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("The restaurant was deleted successfully!");
            auditService.addLog("Delete a restaurant");

            // delete the address
            String sqlCommand3 = "DELETE FROM address WHERE id = ?";
            try (PreparedStatement statement3 = DBConnection.getInstance().prepareStatement(sqlCommand3)) {
                statement3.setInt(1, restaurantAddressId);
                statement3.executeUpdate();
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to delete the address: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to delete a restaurant: " + e.getMessage());
        }
    }

    public void displayRestaurantsSortedByRating() {
String sqlCommand = "SELECT * FROM restaurant ORDER BY rating DESC";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("There are no restaurants in the database at this moment.");
                return;
            }

            while (result.next()) {
                System.out.println("\n------------------- RESTAURANT ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Rating: " + result.getDouble("rating"));

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
                }
            };

            auditService.addLog("Display restaurants sorted by rating");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to display restaurants sorted by rating: " + e.getMessage());
        }
    }
}
