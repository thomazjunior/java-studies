package utils;

import java.util.Random;

public class Person implements RandomPopulatable {
    private String name;
    private int age;
    private String gender;
    private static final Random random = new Random();

    public Person() {
    };

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void populateRandomValues() {
        // Generate a random name
        this.name = "Person" + (1000 + random.nextInt(9000)); // Random name like "Person1234"

        // Generate a random age between 18 and 65
        this.age = 18 + random.nextInt(48); // Ages 18 to 65

        // Generate a random gender
        this.gender = random.nextBoolean() ? "Male" : "Female"; // Randomly assign gender
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, gender='%s'}", name, age, gender);
    }

}
