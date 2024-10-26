package poo.abstraction;

// Define a concrete class 'Bicycle' that only implements Movable since it has no engine
class Bicycle implements Movable {
    @Override
    public void move() {
        System.out.println("Bicycle is being pedaled on the road.");
    }
}
