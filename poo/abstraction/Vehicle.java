package poo.abstraction;

// Define abstract base class 'Vehicle' to encapsulate common properties and behaviors for all vehicles
abstract class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    // Abstract method for starting the engine, to be implemented by each subclass
    public abstract void startEngine();

    // Concrete method that can be used by all subclasses
    public void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}
