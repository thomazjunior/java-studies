package poo.abstraction;

public class AbstractionExample {
    public static void main(String[] args) {

        ServiceStation serviceStation = new ServiceStation();

        // Use an abstract class for shared structure and behavior while still allowing
        // subclass-specific implementation
        Vehicle car = new Car("Toyota", "Camry");
        car.startEngine();
        car.displayBrand();
        // Casting to access move behavior
        ((Movable) car).move();
        ((Car) car).displayModel();

        // Use interface for shared "move" behavior without needing a common ancestor
        Movable bicycle = new Bicycle();
        bicycle.move();

        // Boat uses both abstract class (Vehicle) for shared behavior and interface
        // (Movable) for shared capability
        Vehicle boat = new Boat("Yamaha");
        boat.startEngine();
        boat.displayBrand();
        ((Movable) boat).move();

        serviceStation.performService(car);
        ((Serviceable) bicycle).service();
    }
}
