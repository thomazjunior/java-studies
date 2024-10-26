package poo.abstraction;

// Define a concrete class 'Bicycle' that only implements Movable since it has no engine
class Bicycle implements Movable, Serviceable {
    @Override
    public void move() {
        System.out.println("Bicycle is being pedaled on the road.");
    }

    @Override
    public void service() {
        System.out.println("Bicycle is being serviced.");
    }
}
