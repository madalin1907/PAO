package services;

import repositories.DishRepository;

public class DishService {
    DishRepository dishRepository = new DishRepository();

    public void displayDishes() {
        System.out.println("\nYou chose \"Display all dishes\" option.");
        dishRepository.displayDishes();
    }

    public void addDish() {
        System.out.println("\nYou chose \"Add a new dish\" option.");
        dishRepository.addDish();
    }

    public void updateDish() {
        System.out.println("\nYou chose \"Update a dish\" option.");
        dishRepository.updateDish();
    }

    public void deleteDish() {
        System.out.println("\nYou chose \"Delete a dish\" option.");
        dishRepository.deleteDish();
    }
}
