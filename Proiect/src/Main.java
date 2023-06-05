import services.*;

import exceptions.CustomException;
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

            app.continueOrExit();
        }
    }

    DishService dishService = new DishService();
    DrinkService drinkService = new DrinkService();
    ClientService clientService = new ClientService();
    CourierService courierService = new CourierService();
    RestaurantService restaurantService = new RestaurantService();

    private final Scanner scanner = new Scanner(System.in);

    private void showMenu() {
        System.out.println("\nWelcome to our Food Delivery App! Please enter a number to choose an option:");

        System.out.println(" 1. Display all restaurants.");
        System.out.println(" 2. Add a new restaurant.");
        System.out.println(" 3. Update a restaurant.");
        System.out.println(" 4. Delete a restaurant.");
        System.out.println(" 5. Display restaurants sorted by rating (descending).");

        System.out.println(" 6. Display all dishes.");
        System.out.println(" 7. Add a new dish.");
        System.out.println(" 8. Update a dish.");
        System.out.println(" 9. Delete a dish.");

        System.out.println("10. Display all drinks.");
        System.out.println("11. Add a new drink.");
        System.out.println("12. Update a drink.");
        System.out.println("13. Delete a drink.");

        System.out.println("14. Display all clients.");
        System.out.println("15. Add a new client.");
        System.out.println("16. Update a client.");
        System.out.println("17. Delete a client.");

        System.out.println("18. Display all couriers.");
        System.out.println("19. Add a new courier.");
        System.out.println("20. Update a courier.");
        System.out.println("21. Delete a courier.");

        System.out.println("22. [NOT IMPLEMENTED YET] Display all orders.");
        System.out.println("23. [NOT IMPLEMENTED YET] Add a new order.");
        System.out.println("24. [NOT IMPLEMENTED YET] Update an order.");
        System.out.println("25. [NOT IMPLEMENTED YET] Delete an order.");
        System.out.println("26. [NOT IMPLEMENTED YET] Display all orders for a specific client.");
        System.out.println("27. [NOT IMPLEMENTED YET] Display all orders for a specific restaurant.");

        System.out.println("28. Exit.");

        System.out.print("Please enter a number:");
    }


    public void continueOrExit() {
        System.out.print("\nDo you want to continue? (Type 'y' for yes or 'n' for no):");
        scanner.nextLine();

        while (true) {
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("y")) {
                break;
            } else if (answer.equals("n")) {
                System.out.println("\nThank you for using our Food Delivery App! Goodbye!");
                System.exit(0);
            } else {
                System.out.print("Invalid input. Please type 'y' for yes or 'n' for no:");
            }
        }
    }


    public void executeOption(int option) {
        switch (option) {
            case 1:
                restaurantService.displayRestaurants();
                break;
            case 2:
                restaurantService.addRestaurant();
                break;
            case 3:
                restaurantService.updateRestaurant();
                break;
            case 4:
                restaurantService.deleteRestaurant();
                break;
            case 5:
                restaurantService.displayRestaurantsSortedByRating();
                break;
            case 6:
                dishService.displayDishes();
                break;
            case 7:
                dishService.addDish();
                break;
            case 8:
                dishService.updateDish();
                break;
            case 9:
                dishService.deleteDish();
                break;
            case 10:
                drinkService.displayDrinks();
                break;
            case 11:
                drinkService.addDrink();
                break;
            case 12:
                drinkService.updateDrink();
                break;
            case 13:
                drinkService.deleteDrink();
                break;
            case 14:
                clientService.displayClients();
                break;
            case 15:
                clientService.addClient();
                break;
            case 16:
                clientService.updateClient();
                break;
            case 17:
                clientService.deleteClient();
                break;
            case 18:
                courierService.displayCouriers();
                break;
            case 19:
                courierService.addCourier();
                break;
            case 20:
                courierService.updateCourier();
                break;
            case 21:
                courierService.deleteCourier();
                break;
            case 22:
                System.out.println("\n[NOT IMPLEMENTED YET] Display all orders");
                break;
            case 23:
                System.out.println("\n[NOT IMPLEMENTED YET] Add a new order");
                break;
            case 24:
                System.out.println("\n[NOT IMPLEMENTED YET] Update an order");
                break;
            case 25:
                System.out.println("\n[NOT IMPLEMENTED YET] Delete an order");
                break;
            case 26:
                System.out.println("\n[NOT IMPLEMENTED YET] Display all orders for a specific client");
                break;
            case 27:
                System.out.println("\n[NOT IMPLEMENTED YET] Display all orders for a specific restaurant");
                break;
            case 28:
                System.out.println("\nThank you for using our Food Delivery App! Goodbye!");
                System.exit(0);
        }
    }

    private int readOption() {
        int option = -1;

        do {
            try {
                option = readInt();
                if (option < 1 || option > 28) {
                    System.out.print("Invalid option! Try again: ");
                }
            } catch (CustomException exception) {
                System.out.print("Invalid option! Try again: ");
            }
        } while (option < 1 || option > 28);

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
