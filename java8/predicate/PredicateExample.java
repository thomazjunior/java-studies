package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        // Create a list of employees with diverse backgrounds
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 50000, 5),
                new Employee("Alice", "HR", 60000, 3),
                new Employee("Paulo", "Engineering", 80000, 3),
                new Employee("Bob", "Finance", 70000, 7),
                new Employee("Charlie", "IT", 55000, 4),
                new Employee("David", "Engineering", 90000, 6),
                new Employee("Eva", "Marketing", 65000, 2),
                new Employee("Frank", "HR", 62000, 4),
                new Employee("Grace", "Finance", 75000, 5),
                new Employee("Hannah", "Engineering", 100000, 8));

        // Define predicates for filtering
        Predicate<Employee> isEngineering = emp -> "Engineering".equals(emp.getDepartament());
        Predicate<Employee> earnsAbove70k = emp -> emp.getSalary() > 70000;
        Predicate<Employee> hasExperienceGreaterThan3 = emp -> emp.getExperience() > 3;

        // Combine predicates using and() and or() methods
        Predicate<Employee> engineeringAndHighSalary = isEngineering.and(earnsAbove70k);
        Predicate<Employee> notEngineeringOrLowExperience = isEngineering.negate()
                .or(hasExperienceGreaterThan3.negate());

        // Filter employees using the combined predicate
        System.out.println("Employees are Engineering or with salary above 70k");
        var filtered = employees.stream()
                .filter(engineeringAndHighSalary)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);

        System.out.println("\nEmployees are not Engineering or with experience lower than 3");
        employees.stream().filter(notEngineeringOrLowExperience).forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private String departament;
    private double salary;
    private int experience;

    public Employee(String name, String departament, double salary, int experience) {
        this.name = name;
        this.departament = departament;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", departament=" + departament + ", salary=" + salary + ", experience="
                + experience + "]";
    }

}