package services;
import models.*;

import java.util.List;
import java.util.Scanner;

// TODO: modify after implementing ProductService
public class DishService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayDishes(List<Dish> dishes) {
        if (dishes.isEmpty()) {
            System.out.println("\nThere are no dishes to display.");
            return;
        }

        System.out.println("\nList of current dishes:");
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }

    public static void addDish(List<Dish> dishes) {
        System.out.println("\n--Adding a new dish--");

        System.out.print("Enter the name of the dish:");
        String name = scanner.nextLine();

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
        }

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

        Dish dish = new Dish(name, price, description, ingredients, weight);
        dishes.add(dish);
        System.out.println("\nDish added successfully.");
    }

    public static void deleteDish(List<Dish> dishes) {
        if (dishes.isEmpty()) {
            System.out.println("\nThere are no dishes to delete.");
            return;
        }

        displayDishes(dishes);
        System.out.print("Enter the id of the dish you want to delete:");

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

        for (Dish dish : dishes) {
            if (dish.getId() == id) {
                dishes.remove(dish);
                System.out.println("\nDish deleted successfully.");
                return;
            }
        }

        System.out.println("\nDish not found.");
    }
}
