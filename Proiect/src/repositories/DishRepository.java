package repositories;

import database.DBConnection;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class DishRepository {
    private static final Scanner scanner = new Scanner(System.in);

    public boolean displayDishes() {
        String sqlCommand = "SELECT * FROM dish";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            var result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("\nThere are no dishes in the database at this moment.");
                return false;
            }

            while (result.next()) {
                System.out.println("\n------------------- DISH ID = " + result.getInt("id") + " -------------------");
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Price: " + result.getDouble("price") + " RON");
                System.out.println("Description: " + result.getString("description"));

                String[] ingredients = result.getString("ingredients").split(",");
                System.out.print("Ingredients: " + ingredients[0]);
                for (int i = 1; i < ingredients.length; i++) {
                    System.out.print(", " + ingredients[i]);
                }

                System.out.println("\nWeight: " + result.getInt("weight"));
            }

            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to access dishes: " + e.getMessage());
            return false;
        }
    }


    public void addDish() {
        String sqlCommand = "INSERT INTO dish (name, price, description, ingredients, weight) VALUES (?, ?, ?, ?, ?)";
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

            System.out.print("Enter the number of ingredients:");
            int numberOfIngredients;
            do {
                try {
                    numberOfIngredients = scanner.nextInt();
                    if (numberOfIngredients <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            String[] ingredients = new String[numberOfIngredients];
            for (int i = 0; i < numberOfIngredients; i++) {
                System.out.print("Enter the name of the ingredient:");
                ingredients[i] = scanner.nextLine();
                while (ingredients[i].isEmpty()) {
                    System.out.print("Invalid input. Please enter an ingredient:");
                    ingredients[i] = scanner.nextLine();
                }
            }
            String ingredientsString = String.join(",", ingredients);

            System.out.print("Enter the weight of the dish (in grams):");
            int weight;
            do {
                try {
                    weight = scanner.nextInt();
                    if (weight <= 0) {
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
            statement.setString(4, ingredientsString);
            statement.setInt(5, weight);

            statement.executeUpdate();
            System.out.println("Successfully added a new dish!");
        } catch (Exception e) {
            System.out.println("Something went wrong when trying to add a new dish: " + e.getMessage());
        }
    }


    public void updateDish() {
        String sqlCommand = "UPDATE dish SET name = ?, price = ?, description = ?, ingredients = ?, weight = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayDishes()) {
                return;
            }

            System.out.print("\nEnter the ID of the dish you want to update:");
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

            // Check if the dish exists
            String sqlCommand2 = "SELECT * FROM dish WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.isBeforeFirst()) {
                    System.out.println("There is no dish with the ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access dishes: " + e.getMessage());
                return;
            }

            System.out.println("\n------UPDATING DISH WITH ID " + id + "------");
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

            System.out.print("Enter the number of ingredients:");
            int numberOfIngredients;
            do {
                try {
                    numberOfIngredients = scanner.nextInt();
                    if (numberOfIngredients <= 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter an integer greater than 0:");
                    scanner.nextLine();
                }
            } while (true);
            scanner.nextLine();

            String[] ingredients = new String[numberOfIngredients];
            for (int i = 0; i < numberOfIngredients; i++) {
                System.out.print("Enter the name of the ingredient:");
                ingredients[i] = scanner.nextLine();
                while (ingredients[i].isEmpty()) {
                    System.out.print("Invalid input. Please enter an ingredient:");
                    ingredients[i] = scanner.nextLine();
                }
            }
            String ingredientsString = String.join(",", ingredients);

            System.out.print("Enter the weight of the dish (in grams):");
            int weight;
            do {
                try {
                    weight = scanner.nextInt();
                    if (weight <= 0) {
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
            statement.setString(4, ingredientsString);
            statement.setInt(5, weight);
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println("Successfully updated a dish!");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to update a dish: " + e.getMessage());
        }
    }


    public void deleteDish() {
        String sqlCommand = "DELETE FROM dish WHERE id = ?";
        try (PreparedStatement statement = DBConnection.getInstance().prepareStatement(sqlCommand)) {
            if (!displayDishes()) {
                return;
            }

            System.out.print("\nEnter the ID of the dish you want to delete:");
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

            // Check if the dish exists
            String sqlCommand2 = "SELECT * FROM dish WHERE id = ?";
            try (PreparedStatement statement2 = DBConnection.getInstance().prepareStatement(sqlCommand2)) {
                statement2.setInt(1, id);
                var result = statement2.executeQuery();
                if (!result.isBeforeFirst()) {
                    System.out.println("There is no dish with ID " + id + " in the database.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong when trying to access dishes: " + e.getMessage());
                return;
            }

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("Successfully deleted a dish!");

        } catch (Exception e) {
            System.out.println("Something went wrong when trying to delete the dish: " + e.getMessage());
        }
    }
}