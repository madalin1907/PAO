package services;
import models.*;

import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayRestaurants(List<Restaurant> restaurants) {
        if (restaurants.isEmpty()) {
            System.out.println("\nThere are no restaurants to display.");
            return;
        }

        System.out.println("\nList of current restaurants:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }

    public static void addRestaurant(List<Restaurant> restaurants) {
        System.out.println("\nAdd a new restaurant:");

        System.out.print("Enter the name of the restaurant:");
        String name = scanner.nextLine();
        System.out.print("Enter the country of the restaurant:");
        String country = scanner.nextLine();
        System.out.print("Enter the city of the restaurant:");
        String city = scanner.nextLine();
        System.out.print("Enter the street of the restaurant:");
        String street = scanner.nextLine();
        System.out.print("Enter the number of the restaurant:");
        String number = scanner.nextLine();
        System.out.print("Enter the postal code of the restaurant:");
        String postalCode = scanner.nextLine();

        System.out.print("Enter the rating of the restaurant (between 1 and 5):");
        double rating;
        do {
            try {
                rating = scanner.nextDouble();
                if (rating < 1 || rating > 5) {
                    throw new Exception();
                }
                break;
            }catch (Exception e) {
                System.out.print("Invalid input. Please enter a number between 1 and 5:");
                scanner.nextLine();
            }
        } while (true);
        scanner.nextLine();

        Restaurant restaurant = new Restaurant(name, new Address(country, city, street, number, postalCode), rating);
        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully.");
    }

    public static void deleteRestaurant(List<Restaurant> restaurants) {
        if (restaurants.isEmpty()) {
            System.out.println("\nThere are no restaurants to delete.");
            return;
        }

        displayRestaurants(restaurants);
        System.out.print("Enter the id of the restaurant you want to delete:");
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

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) {
                restaurants.remove(restaurant);
                System.out.println("\nRestaurant deleted successfully.");
                return;
            }
        }

        System.out.println("\nRestaurant not found.");
    }

    // sort restaurants by rating
    public static void sortRestaurantsByRating(List<Restaurant> restaurants) {
        if (restaurants.isEmpty()) {
            System.out.println("\nThere are no restaurants to sort.");
            return;
        }

        restaurants.sort((restaurant1, restaurant2) -> {
            return restaurant2.getRating().compareTo(restaurant1.getRating());
        });

        System.out.print("\nRestaurants sorted successfully.");
        displayRestaurants(restaurants);
    }
}
