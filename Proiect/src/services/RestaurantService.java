package services;

import repositories.RestaurantRepository;

public class RestaurantService {
    RestaurantRepository restaurantRepository = new RestaurantRepository();

    public void displayRestaurants() {
        System.out.println("\nYou chose \"Display all restaurants\" option.");
        restaurantRepository.displayRestaurants();
    }

    public void addRestaurant() {
        System.out.println("\nYou chose \"Add a new restaurant\" option.");
        restaurantRepository.addRestaurant();
    }

    public void updateRestaurant() {
        System.out.println("\nYou chose \"Update a restaurant\" option.");
        restaurantRepository.updateRestaurant();
    }

    public void deleteRestaurant() {
        System.out.println("\nYou chose \"Delete a restaurant\" option.");
        restaurantRepository.deleteRestaurant();
    }

    public void displayRestaurantsSortedByRating() {
        System.out.println("\nYou chose \"Display restaurants sorted by rating\" option.");
        restaurantRepository.displayRestaurantsSortedByRating();
    }
}
