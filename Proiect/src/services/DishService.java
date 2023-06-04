package services;

import repositories.DishRepository;

public class DishService {
    DishRepository dishRepository = new DishRepository();

    public void displayDishes() {
        System.out.println("\nYou chosed \"Display all dishes\" option.");
        dishRepository.displayDishes();
    }

    public void addDish() {
        System.out.println("\nYou chosed \"Add a new dish\" option.");
        dishRepository.addDish();
    }

    public void updateDish() {
        System.out.println("\nYou chosed \"Update a dish\" option.");
        dishRepository.updateDish();
    }

    public void deleteDish() {
        System.out.println("\nYou chosed \"Delete a dish\" option.");
        dishRepository.deleteDish();
    }
}
