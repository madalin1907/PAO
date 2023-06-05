package services;

import repositories.DrinkRepository;

public class DrinkService {
    DrinkRepository drinkRepository = new DrinkRepository();

    public void displayDrinks() {
        System.out.println("\nYou chose \"Display all drinks\" option.");
        drinkRepository.displayDrinks();
    }

    public void addDrink() {
        System.out.println("\nYou chose \"Add a new drink\" option.");
        drinkRepository.addDrink();
    }

    public void updateDrink() {
        System.out.println("\nYou chose \"Update a drink\" option.");
        drinkRepository.updateDrink();
    }

    public void deleteDrink() {
        System.out.println("\nYou chose \"Delete a drink\" option.");
        drinkRepository.deleteDrink();
    }
}
