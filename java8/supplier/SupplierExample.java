package supplier;

import java.util.function.Predicate;
import java.util.function.Supplier;

import utils.Employee;

//It represents a function which does not take in any argument but produces a value of type T.
public class SupplierExample {
    public static void main(String[] args) {
        // Example1:
        Supplier<Employee> getDefault = Employee::new;
        // fetch the default employee using Supplier
        Employee defaultEmployee = getDefault.get();
        System.out.println(defaultEmployee);

        // Example 2:
        // Get a default employee when no employee matches the condition
        Predicate<Employee> hasMoreThan5YearsExperience = emp -> emp.getExperience() > 5;
        Supplier<Employee> getDefaultEmployee = () -> new Employee("Unknown", "Unknown");
        var selectedEmployee = Employee.employees.stream()
                .filter(hasMoreThan5YearsExperience)
                .findFirst()
                .orElseGet(getDefaultEmployee);

        // Display the selected employee (either a real employee or a supplied employee)
        System.out.println("Selected employee: " + selectedEmployee);
    }
}
