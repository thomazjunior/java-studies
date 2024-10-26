package poo.abstraction;

public class AbstractionExample {
    public static void main(String[] args) {
        // Use an abstract class for shared structure and behavior while still allowing subclass-specific implementation
        Vehicle car = new Car("Toyota", "Camry");
        car.startEngine();
        car.displayBrand();
        ((Movable) car).move(); // Casting to access move behavior
        ((Car) car).displayModel();

        // Use interface for shared "move" behavior without needing a common ancestor
        Movable bicycle = new Bicycle();
        bicycle.move();

        // Boat uses both abstract class (Vehicle) for shared behavior and interface (Movable) for shared capability
        Vehicle boat = new Boat("Yamaha");
        boat.startEngine();
        boat.displayBrand();
        ((Movable) boat).move();
    }
}
