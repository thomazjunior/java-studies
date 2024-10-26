package poo.abstraction;

// Subclass implementing the abstract method
// Define a concrete class 'Car' that extends Vehicle and implements Movable
class Car extends Vehicle implements Movable {
    private String model;

    public Car(String brand, String model) {
        super(brand);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting car engine for " + getBrand() + " " + model);
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " " + model + " is moving on the road.");
    }

    public void displayModel() {
        System.out.println("Model: " + model);
    }
}