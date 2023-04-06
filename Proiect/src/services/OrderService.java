package services;

import models.*;

import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("\nThere are no orders to display.");
            return;
        }
        System.out.println("\nList of current orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // TODO: implements remaining methods from Main.java

//    public static void addOrder(List<Order> orders, List<Client> clients, List<Courier> couriers, List<Restaurant> restaurants, List<Product> products) {
//        System.out.println("\nAdding a new order--");
//
//        Client client;
//        ClientService.displayClients(clients);
//        System.out.print("Please select a client from the list above:");
//        do {
//            try {
//                int clientId = scanner.nextInt();
//                client = ClientService.getClientById(clients, clientId);
//                if (client == null) {
//                    throw new Exception();
//                }
//                System.out.println("Client selected: " + client);
//                break;
//            } catch (Exception e) {
//                System.out.print("Please enter a valid client id:");
//            } finally {
//                scanner.nextLine();
//            }
//        } while (true);
//
//        Courier courier;
//        CourierService.displayCouriers(couriers);
//        System.out.print("Please select a courier from the list above:");
//        do {
//            try {
//                int courierId = scanner.nextInt();
//                courier = CourierService.getCourierById(couriers, courierId);
//                if (courier == null) {
//                    throw new Exception();
//                }
//                System.out.println("Courier selected: " + courier);
//                break;
//            } catch (Exception e) {
//                System.out.print("Please enter a valid courier id:");
//            } finally {
//                scanner.nextLine();
//            }
//        } while (true);
//
//        Restaurant restaurant;
//        RestaurantService.displayRestaurants(restaurants);
//        System.out.print("Please select a restaurant from the list above:");
//        do {
//            try {
//                int restaurantId = scanner.nextInt();
//                restaurant = RestaurantService.getRestaurantById(restaurants, restaurantId);
//                if (restaurant == null) {
//                    throw new Exception();
//                }
//                System.out.println("Restaurant selected: " + restaurant);
//                break;
//            } catch (Exception e) {
//                System.out.print("Please enter a valid restaurant id:");
//            } finally {
//                scanner.nextLine();
//            }
//        } while (true);
//
//    }
}