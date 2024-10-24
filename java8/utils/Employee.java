package utils;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private int experience;
    private int age;
    private String jobTitle;

    public static List<Employee> employees = Arrays.asList(
            new Employee("John", "IT", 50000, 5, 28, "Developer"),
            new Employee("Alice", "HR", 60000, 3, 35, "HR Manager"),
            new Employee("Paulo", "Engineering", 80000, 3, 29, "Software Engineer"),
            new Employee("Bob", "Finance", 70000, 7, 40, "Finance Manager"),
            new Employee("Charlie", "IT", 55000, 4, 34, "Developer"),
            new Employee("David", "Engineering", 90000, 6, 32, "Junior Engineer"),
            new Employee("Eve", "Marketing", 72000, 6, 38, "Marketing Manager"));

    public Employee(String name, String department, double salary, int experience, int age, String jobTitle) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return String.format("Employee [name=%s, department=%s, salary=%.2f, experience=%d, age=%d, jobTitle=%s]",
                name, department, salary, experience, age, jobTitle);
    }
}
