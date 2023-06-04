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
        System.out.println("\n--Adding a new restaurant--");

        System.out.print("Enter the name of the restaurant:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("Invalid input. Please enter the name of the restaurant:");
            name = scanner.nextLine();
        }

        System.out.println("--Entering the address of the restaurant--");
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

    public static void updateRestaurant(List<Restaurant> restaurants) {
        if (restaurants.isEmpty()) {
            System.out.println("\nThere are no restaurants to update.");
            return;
        }

        displayRestaurants(restaurants);
        System.out.print("Enter the id of the restaurant you want to update:");
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
                System.out.println("\n--Updating the restaurant--");
                System.out.print("Enter the name of the restaurant:");
                String name = scanner.nextLine();
                while (name.isEmpty()) {
                    System.out.print("Invalid input. Please enter the name of the restaurant:");
                    name = scanner.nextLine();
                }

                System.out.println("--Updating the address of the restaurant--");
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

                restaurant.setName(name);
                restaurant.setAddress(new Address(country, city, street, number, postalCode));
                restaurant.setRating(rating);
                System.out.println("\nRestaurant updated successfully.");
                return;
            }
        }

        System.out.println("\nRestaurant not found.");
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



    public static Restaurant getRestaurantById(List<Restaurant> restaurants, int id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        return null;
    }
}
