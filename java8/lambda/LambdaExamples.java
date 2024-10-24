package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * The LambdaExamples class demonstrates the use of lambda expressions in Java
 * to simplify code when working with functional interfaces. This class provides
 * examples of common scenarios where lambda expressions can be used:
 * 
 * - Implementing Consumer to process a list of integers.
 * - Using Predicate to filter elements from a collection.
 * - Creating custom functional interfaces (MathOperation and SalaryAdjustment)
 * to perform operations like arithmetic calculations and salary adjustments.
 * 
 * The purpose is to showcase how lambda expressions enable concise, readable,
 * and functional-style code, reducing boilerplate for interfaces with a single
 * abstract method.
 */
public class LambdaExamples {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // Example 1:
        // Using a lambda expression to implement Consumer Functional Interface
        System.out.println("Using consumer to print all the numbers");
        numbers.forEach(n -> System.out.println(n));

        // Example 2:
        // Using a lambda expression to implement Predicate Functional Interface
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("\nUsing predicate to filter even numbers");
        numbers.stream()
                .filter(isEven)
                .forEach(n -> System.out.println(n));

        // Example 3:
        // Using a custom functional interface for math operations
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> {
            if (b == 0)
                throw new ArithmeticException("Division by zero is not allowed");

            return a / b;
        };
        System.out.println("\nUsing custom functional interface for math operations");
        System.out.println("Addition: " + operate(1, 2, addition));
        System.out.println("Subtraction: " + operate(1, 2, subtraction));

        // Example 4:
        // Using functional interface in a more complex way
        // to apply a salary increment using lambda expression
        List<Double> salaries = Arrays.asList(3000.0, 4000.0, 5000.0, 6000.0);
        SalaryAdjustment adjustment = (salary) -> salary * 1.10;
        System.out.println("\nUpdated salaries after a 10% salary increment");
        salaries.stream()
                .map(adjustment::adjustSalary)
                .forEach(s -> System.out.printf("%.2f%n", s));

    }

    private static int operate(int a, int b, MathOperation op) {
        return op.operate(a, b);
    }
}

// This annotation is not required but it's a good practice to use it.
// @FunctionalInterface ensures that the interface has exactly one abstract
// method.
// It helps prevent accidental addition of more methods in the future, which
// would break the functional interface contract
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface SalaryAdjustment {
    double adjustSalary(double salary);
}