package poo.abstraction;

// Define a concrete class 'Boat' that extends Vehicle and implements Movable
class Boat extends Vehicle implements Movable {
    public Boat(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println("Starting boat engine for " + getBrand());
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " boat is sailing on the water.");
    }
}   