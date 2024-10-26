package poo;

/**
 * The {@code BasicConcepts} class is designed to illustrate fundamental
 * concepts of
 * inheritance in Object-Oriented Programming (OOP). The following topics will
 * be addressed within this class:
 * 
 * <ol>
 * <li><strong>Single Inheritance</strong>: Understanding how a class can
 * inherit from one
 * superclass and utilize its properties and methods.</li>
 * 
 * <li><strong>Multilevel Inheritance</strong>: Exploring the concept of a class
 * inheriting
 * from a derived class, creating a chain of inheritance.</li>
 * 
 * <li><strong>Method Overriding (Dynamic Polymorphism)</strong>: Demonstrating
 * how subclasses can
 * provide
 * specific implementations of methods defined in their superclasses,
 * enhancing or altering behavior.</li>
 * 
 * <li><strong>Polymorphism</strong>: Illustrating the ability of different
 * classes to be
 * treated as instances of the same superclass, particularly through method
 * overriding.</li>
 * 
 * <li><strong>Abstract Classes</strong>: Introducing the concept of abstract
 * classes as base
 * classes that cannot be instantiated and may contain abstract methods for
 * subclasses to implement.</li>
 * 
 * <li><strong>Interfaces</strong>: Discussing how interfaces can be used to
 * define contracts
 * for classes, allowing for multiple inheritance of type.</li>
 * 
 * <li><strong>Access Modifiers</strong>: Examining the role of access modifiers
 * (public,
 * protected, private, package) in inheritance, particularly in controlling
 * access to superclass members.</li>
 * </ol>
 * 
 * This class serves as a foundational component for understanding how
 * inheritance enables code reuse,
 * enhances modularity, and promotes a clear class hierarchy in OOP.
 */
public class BasicConcepts {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        Animal myCat = new Cat();
        MathOperations mathOps = new MathOperations();
        myDog.eat(); // Inherited from Animal
        myDog.walk(); // Inherited from Mammal
        myDog.bark(); // Dog's own method
        myCat.makeSound();
        myDog.makeSound();
        int sumOfTwoIntegers = mathOps.add(5, 10);
        double sumOfTwoDoubles = mathOps.add(3.5, 2.5);
        Flyable seaplaneAsFlyable = new Seaplane();
        Swimmable seaplaneAsSwimmable = new Seaplane();

        // Polymorphism: Arrays of animals references holding different types of animals
        Animal[] animals = { new Dog("Buddy"), new Cat(), new Animal("Fido") };
        for (Animal animal : animals) {
            animal.eat();
            animal.makeSound();
            if (animal instanceof Dog) {
                System.out.println("Dog found!");
                ((Dog) animal).bark();
            }
        }

        // Rectangle Instance
        Shape rectangle = new Rectangle(10, 10);
        Shape circle = new Circle(10);
        rectangle.displayShape();
        circle.displayShape();

        // Testing polymorphic behavior
        performFlying(seaplaneAsFlyable);
        performSwimming(seaplaneAsSwimmable);

    }

    // Method for Flyable objects to perform flying
    public static void performFlying(Flyable flyer) {
        flyer.fly();
    }

    // Method for Swimmable objects to perform swimming
    public static void performSwimming(Swimmable swimmer) {
        swimmer.swim();
    }
}

// Superclass (Parent Class)
class Animal {
    // Property
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Method
    void eat() {
        System.out.println(name + " is eating.");
    }

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

// Intermediate Class
class Mammal extends Animal {
    Mammal(String name) {
        super(name); // Calling the constructor of the superclass (Animal)
    }

    void walk() {
        System.out.println(name + " is walking.");
    }
}

// Subclass (Child Class)
class Dog /* Example about Single Inheritance extends Animal */ extends Mammal /* Multilevel inheritance */ {

    // Constructor
    Dog(String name) {
        super(name); // Call to the superclass constructor
    }

    // Method specific to Dog
    void bark() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    void makeSound() {
        System.out.println("Dog barks!");
    }
}

// Another Subclass
class Cat extends Mammal {
    Cat(String name) {
        super(name);
    }

    public Cat() {
        super("");
    }

    /** Dynamic Polymorphism - Overriding */
    @Override
    void makeSound() {
        System.out.println("Cat meows!");
    }
}

/**
 * The {@code MathOperations} class provides methods to perform
 * addition operations. This class demonstrates the concept of
 * method overloading by defining multiple {@code add} methods
 * with different parameter lists.
 */
class MathOperations {

    /**
     * Adds two integers and returns the sum.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the sum of {@code a} and {@code b}
     */
    int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds two double values and returns the sum.
     * 
     * @param a the first double
     * @param b the second double
     * @return the sum of {@code a} and {@code b}
     */
    double add(double a, double b) {
        return a + b;
    }

    /**
     * Adds three integers and returns the sum.
     * 
     * @param a the first integer
     * @param b the second integer
     * @param c the third integer
     * @return the sum of {@code a}, {@code b}, and {@code c}
     */
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

abstract class Shape {
    public abstract double calculateArea();

    public void displayShape() {
        System.out.println("This is a shape");
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Seaplane implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Seaplane is flying.");
    }

    @Override
    public void swim() {
        System.out.println("Seaplane is swimming on the water.");
    }
}

// Superclass
class Employee {
    public String publicTitle = "Public Employee"; // Accessible everywhere
    protected String protectedDepartment = "Protected Dept"; // Accessible within package and in subclasses
    String defaultRole = "Default Employee"; // Package-private, only within the same package
    private double privateSalary = 50000.00; // Accessible only within Employee

    // Public method accessible everywhere
    public void publicMethod() {
        System.out.println("Public method in Employee");
    }

    // Protected method accessible within package and by subclasses
    protected void protectedMethod() {
        System.out.println("Protected method in Employee");
    }

    // Package-private method, accessible only within the same package
    void defaultMethod() {
        System.out.println("Default method in Employee");
    }

    // Private method, accessible only within this class
    private void privateMethod() {
        System.out.println("Private method in Employee");
    }
}