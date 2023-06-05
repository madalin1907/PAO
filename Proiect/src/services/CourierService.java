package services;

import repositories.CourierRepository;

public class CourierService {
    CourierRepository courierRepository = new CourierRepository();

    public void displayCouriers() {
        System.out.println("\nYou chose \"Display all couriers\" option.");
        courierRepository.displayCouriers();
    }

    public void addCourier() {
        System.out.println("\nYou chose \"Add a new courier\" option.");
        courierRepository.addCourier();
    }

    public void updateCourier() {
        System.out.println("\nYou chose \"Update a courier\" option.");
        courierRepository.updateCourier();
    }

    public void deleteCourier() {
        System.out.println("\nYou chose \"Delete a courier\" option.");
        courierRepository.deleteCourier();
    }
}
