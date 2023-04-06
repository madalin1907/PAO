package services;
import models.*;

import java.util.List;
import java.util.Scanner;
public class DrinkService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayDrinks(List<Drink> drinks) {
        if (drinks.isEmpty()) {
            System.out.println("\nThere are no drinks to display.");
            return;
        }

        System.out.println("\nList of current drinks:");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }

    public static void addDrink(List<Drink> drinks) {
        System.out.println("\nAdd a new drink:");

        System.out.print("Enter the name of the drink:");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the drink:");
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

        System.out.print("Enter the description of the drink:");
        String description = scanner.nextLine();

        System.out.print("Is the drink alcoholic? (true/false):");
        boolean isAlcoholic;
        do {
            try {
                isAlcoholic = scanner.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter true or false:");
                scanner.nextLine();
            }
        } while (true);
        scanner.nextLine();

        System.out.print("Enter the volume of the drink (milliliters):");
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

        Drink drink = new Drink(name, price, description, isAlcoholic, volume);
        drinks.add(drink);
        System.out.println("\nDrink added successfully.");
    }

    public static void deleteDrink(List<Drink> drinks) {
        if (drinks.isEmpty()) {
            System.out.println("\nThere are no drinks to delete.");
            return;
        }

        displayDrinks(drinks);
        System.out.print("Enter the id of the drink you want to delete:");
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

        for (Drink drink : drinks) {
            if (drink.getId() == id) {
                drinks.remove(drink);
                System.out.println("\nDrink deleted successfully.");
                return;
            }
        }

        System.out.println("\nDrink not found.");
    }
}
