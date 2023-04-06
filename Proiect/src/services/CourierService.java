package services;
import models.*;

import java.util.List;
import java.util.Scanner;

public class CourierService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayCouriers(List<Courier> couriers) {
        if (couriers.isEmpty()) {
            System.out.println("\nThere are no couriers to display.");
            return;
        }

        System.out.println("\nList of current couriers:");
        for (Courier courier : couriers) {
            System.out.println(courier);
        }
    }

    public static void addCourier(List<Courier> couriers) {
        System.out.println("\n--Adding a new courier--");

        System.out.print("Enter the name of the courier:");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number of the courier:");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter the email of the courier:");
        String email = scanner.nextLine();

        System.out.println("Enter the phone number of the courier:");

        System.out.print("Enter the rating of the courier:");
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

        System.out.print("Enter the vehicle of the courier:");
        String vehicle = scanner.nextLine();

        Courier courier = new Courier(name, phoneNumber, email, rating, vehicle);
        couriers.add(courier);
        System.out.println("Courier added successfully.");
    }

    public static void deleteCourier(List<Courier> couriers) {
        if (couriers.isEmpty()) {
            System.out.println("\nThere are no couriers to delete.");
            return;
        }

        displayCouriers(couriers);
        System.out.print("Enter the id of the courier you want to delete:");
        int id;
        do {
            try {
                id = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number:");
                scanner.nextLine();
            }
        } while (true);
        scanner.nextLine();

        for (int i = 0; i < couriers.size(); i++) {
            if (couriers.get(i).getId() == id) {
                couriers.remove(i);
                System.out.print("Courier deleted successfully.");
                return;
            }
        }
        System.out.println("Courier not found.");
    }

    public static Courier getCourierById(List<Courier> couriers, int id) {
        for (Courier courier : couriers) {
            if (courier.getId() == id) {
                return courier;
            }
        }
        return null;
    }
}
