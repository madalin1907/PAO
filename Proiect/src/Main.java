import exceptions.CustomException;
import models.*;
import services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Main app = new Main();
        while (true) {
            app.showMenu();
            int option = app.readOption();
            app.executeOption(option);
        }
    }

    private final Scanner scanner = new Scanner(System.in);

    private final List<Restaurant> restaurants = new ArrayList<>();
    private final List<Dish> dishes = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private final List<Courier> couriers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    private void showMenu() {
        System.out.println("\nWelcome to our Food Delivery App! Please enter a number to choose an option:");
        System.out.println("1. Display all restaurants.");
        System.out.println("2. Add a new restaurant.");
        System.out.println("3. Delete a restaurant.");
        System.out.println("4. Sort restaurants by rating (descending).");
        System.out.println("5. Display all dishes.");
        System.out.println("6. Add a new dish.");
        System.out.println("7. Delete a dish.");
        System.out.println("8. Display all drinks.");
        System.out.println("9. Add a new drink.");
        System.out.println("10. Delete a drink.");
        System.out.println("11. Display all clients.");
        System.out.println("12. Add a new client.");
        System.out.println("13. Delete a client.");
        System.out.println("14. Display all couriers.");
        System.out.println("15. Add a new courier.");
        System.out.println("16. Delete a courier.");
        System.out.println("17. Display all orders.");
        System.out.println("18. Add a new order.");
        System.out.println("19. Delete an order.");
        System.out.println("20. Display all orders for a specific client.");
        System.out.println("21. Display all orders for a specific restaurant.");
        System.out.println("22. Exit.");
        System.out.print("Please enter a number:");
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                RestaurantService.displayRestaurants(restaurants);
                break;
            case 2:
                RestaurantService.addRestaurant(restaurants);
                break;
            case 3:
                RestaurantService.deleteRestaurant(restaurants);
                break;
            case 4:
                RestaurantService.sortRestaurantsByRating(restaurants);
                break;
            case 5:
                DishService.displayDishes(dishes);
                break;
            case 6:
                DishService.addDish(dishes);
                break;
            case 7:
                DishService.deleteDish(dishes);
                break;
            case 8:
                DrinkService.displayDrinks(drinks);
                break;
            case 9:
                DrinkService.addDrink(drinks);
                break;
            case 10:
                DrinkService.deleteDrink(drinks);
                break;
            case 11:
                ClientService.displayClients(clients);
                break;
            case 12:
                ClientService.addClient(clients);
                break;
            case 13:
                ClientService.deleteClient(clients);
                break;
            case 14:
                CourierService.displayCouriers(couriers);
                break;
            case 15:
                CourierService.addCourier(couriers);
                break;
            case 16:
                CourierService.deleteCourier(couriers);
                break;
            case 17:
                OrderService.displayOrders(orders);
                break;
            case 18:
//                List<Product> allProducts = new ArrayList<>();
//                allProducts.addAll(dishes);
//                allProducts.addAll(drinks);
//                OrderService.addOrder(orders, clients, couriers, restaurants, allProducts);
                System.out.println("\n[NOT IMPLEMENTED YET] Add a new order");
                break;
            case 19:
                System.out.println("\n[NOT IMPLEMENTED YET] Delete an order");
                break;
            case 20:
                System.out.println("\n[NOT IMPLEMENTED YET] Display all orders for a specific client");
                break;
            case 21:
                System.out.println("\n[NOT IMPLEMENTED YET] Display all orders for a specific restaurant");
                break;
            case 22:
                System.out.println("\nThank you for choosing our app. Goodbye!");
                System.exit(0);
        }
    }

    private int readOption() {
        int option = -1;

        do {
            try {
                option = readInt();
                if (option < 1 || option > 22) {
                    System.out.print("Invalid option! Try again: ");
                }
            } catch (CustomException exception) {
                System.out.print("Invalid option! Try again: ");
            }
        } while (option < 1 || option > 22);

        return option;
    }

    private int readInt() throws CustomException {
        String line = scanner.next();
        if (line.matches("^\\d+$")) {
            return Integer.parseInt(line);
        } else {
            throw new CustomException("Invalid number");
        }
    }
}
