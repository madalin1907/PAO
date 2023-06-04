package repositories;

import database.DBConnection;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class DrinkRepository {
    private static final Scanner scanner = new Scanner(System.in);

    public boolean displayDrinks() {
        String sqlCommand = "SELECT * FROM drink";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("\nThere are no drinks in the database at this moment.");
                return false;
            }

            while (result.next()) {
                System.out.println("\n------------------- DRINK ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Price: " + result.getDouble("price") + " RON");
                System.out.println("Description: " + result.getString("description"));
                System.out.println("Is alcoholic: " + (result.getBoolean("isAlcoholic") ? "Yes" : "No"));
                System.out.println("Volume: " + result.getInt("volume") + "ml");
            }

            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to access drinks: " + e.getMessage());
            return false;
        }
    }

    public void addDrink() {
        String sqlCommand = "INSERT INTO drink (name, price, description, isAlcoholic, volume) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            System.out.println("\n------ADDING A NEW DISH------");

            System.out.print("Enter the name of the dish:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter a name:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the price of the dish:");
            double price;
            do {
                try {
                    price = scanner.nextDouble();
                    if (price <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a double greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            System.out.print("Enter the description of the dish:");
            String description = scanner.nextLine();
            while (description.isEmpty()) {
                System.out.print("Invalid input. Please enter a description:");
                description = scanner.nextLine();
            }

            System.out.print("Is the dish alcoholic (yes/no):");
            boolean isAlcoholic;
            do {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes")) {
                    isAlcoholic = true;
                    break;
                } else if (input.equalsIgnoreCase("no")) {
                    isAlcoholic = false;
                    break;
                } else {
                    System.out.print("Invalid input. Please enter yes/no:");
                }
            } while (true);

            System.out.print("Enter the volume of the dish (milliliters):");
            int volume;
            do {
                try {
                    volume = scanner.nextInt();
                    if (volume <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setString(3, description);
            statement.setBoolean(4, isAlcoholic);
            statement.setInt(5, volume);

            statement.executeUpdate();
            System.out.println("\nDrink added successfully!");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to add a new drink: " + e.getMessage());
        }
    }


    public void updateDrink() {
        String sqlCommand = "UPDATE drink SET name = ?, price = ?, description = ?, isAlcoholic = ?, volume = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayDrinks()) {
                return;
            }

            System.out.print("\nEnter the ID of the drink you want to update:");
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

            // check if the drink exists
            String sqlCommand2 = "SELECT * FROM drink WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.next()) {
                    System.out.println("\nThere is no drink with the ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access drinks: " + e.getMessage());
                return;
            }

            System.out.println("\n------UPDATING DRINK WITH ID = " + id + "------");
            System.out.print("Enter the new name of the drink:");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.print("Invalid input. Please enter a name:");
                name = scanner.nextLine();
            }

            System.out.print("Enter the new price of the drink:");
            double price;
            do {
                try {
                    price = scanner.nextDouble();
                    if (price <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a double greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            System.out.print("Enter the new description of the drink:");
            String description = scanner.nextLine();
            while (description.isEmpty()) {
                System.out.print("Invalid input. Please enter a description:");
                description = scanner.nextLine();
            }

            System.out.print("Is the drink alcoholic (yes/no):");
            boolean isAlcoholic;
            do {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("yes")) {
                    isAlcoholic = true;
                    break;
                } else if (input.equalsIgnoreCase("no")) {
                    isAlcoholic = false;
                    break;
                } else {
                    System.out.print("Invalid input. Please enter yes/no:");
                }
            } while (true);

            System.out.print("Enter the new volume of the drink (milliliters):");
            int volume;
            do {
                try {
                    volume = scanner.nextInt();
                    if (volume <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setString(3, description);
            statement.setBoolean(4, isAlcoholic);
            statement.setInt(5, volume);
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println("\nDrink updated successfully!");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to update a dish: " + e.getMessage());
        }
    }


    public void deleteDrink() {
        String sqlCommand = "DELETE FROM drink WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayDrinks()) {
                return;
            }

            System.out.print("\nEnter the ID of the drink you want to delete:");
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

            // check if the drink exists
            String sqlCommand2 = "SELECT * FROM drink WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.next()) {
                    System.out.println("\nThere is no drink with the ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access drinks: " + e.getMessage());
                return;
            }

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("\nDrink deleted successfully!");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to delete a drink: " + e.getMessage());
        }
    }
}
