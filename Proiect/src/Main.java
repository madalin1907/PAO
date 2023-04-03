import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        // instantiate some restaurants
        Restaurant restaurant1 = new Restaurant("McDonalds", new Address("Romania", "Bucuresti, Sector 3", "Calea Vitan", "23", "002342"), 4.5);
        Restaurant restaurant2 = new Restaurant("KFC", new Address("Romania", "Bucuresti, Sector 3", "Calea Vitan", "24", "002342"), 4.2);
        Restaurant restaurant3 = new Restaurant("Pizza Hut", new Address("Romania", "Bucuresti, Sector 2", "Sos. Colentina", "123", "032142"), 4.0);

        // instantiate some clients
        Client client1 = new Client("Andrei", "1111111111", "andrei@yahoo.ro", new Address("Romania", "Bucuresti, Sector 1", "Calea Victoriei", "1", "001234"));
        Client client2 = new Client("Marian", "2222222222", "marian@yahoo.ro", new Address("Romania", "Bucuresti, Sector 1", "Calea Dorobanti", "2", "002345"));

        // instantiate some couriers
        Courier courier1 = new Courier("John", "1231231234", "john@yahoo.y", "4.5", "Car");
        Courier courier2 = new Courier("Tom", "2342342345", "tom@yahoo.ro", "4.0", "Scooter");
        Courier courier3 = new Courier("Bob", "3453213456", "bob@yahoo.ro", "3.5", "Bike");

        // instantiate some drinks
        Drink drink = new Drink("Coca-Cola", 5.0, "Coca-Cola is a carbonated soft drink produced by The Coca-Cola Company.", false, 500);
        Drink drink2 = new Drink("Fanta", 5.0, "Fanta is a brand of fruit-flavored carbonated soft drinks created by Coca-Cola in Germany in 1940.", false, 500);
        Drink drink3 = new Drink("Irish Coffee", 10.0, "Irish coffee is a hot drink consisting of coffee, Irish whiskey, and sugar, topped with thick cream.", true, 300);

        // instantiate some dishes
        Dish dish1 = new Dish("Cheeseburger", 31.99, "A tasty sandwich with beef, cheese and sauces", new String[]{"bread", "beef", "cheese", "mayo", "ketchup"}, 500);
        Dish dish2 = new Dish("Chicken Wings", 22.99, "A tasty dish with chicken wings and sauces", new String[]{"chicken wings", "mayo", "ketchup"}, 500);
        Dish dish3 = new Dish("Pizza Diavola", 29.99, "A tasty pizza with tomato sauce, mozzarella, spicy salami and oregano", new String[]{"tomato sauce", "mozzarella", "spicy salami", "oregano", "olives"}, 500);

    }
}