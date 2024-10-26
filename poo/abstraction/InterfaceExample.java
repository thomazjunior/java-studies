package poo.abstraction;

// Interface
interface Movable {
    void move();
}

// Class implementing the interface
class Bicycle implements Movable {
    @Override
    public void move() {
        System.out.println("Bicycle is moving by pedaling.");
    }
}