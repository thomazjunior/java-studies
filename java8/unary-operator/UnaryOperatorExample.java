import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import utils.Employee;

// This class demonstrates the use of UnaryOperator, Predicate, and Consumer functional interfaces 
// to apply salary adjustments to employees based on specific conditions. 
// It defines two UnaryOperators: one for applying a 10% salary increase for employees in the "IT" department 
// and another for applying a 5% bonus to employees with more than 5 years of experience. 
// Both bonuses are applied sequentially using Java Streams, and the updated employee details 
// are printed using a Consumer.
public class UnaryOperatorExample {
    static Predicate<Employee> isFromDepartment = emp -> "IT".equals(emp.getDepartment());
    static Predicate<Employee> isAbove5YearsExperience = emp -> emp.getExperience() > 5;
    static Consumer<Employee> printEmployee = emp -> System.out.println(
            emp.getName() + " (Department: " + emp.getDepartment() + ", New Salary: $" + emp.getSalary() + ")");
    // Predicate to check if an employee's salary is above a certain threshold
    static Predicate<Employee> hasSalaryAbove50000 = emp -> emp.getSalary() > 50000;

    public static void main(String[] args) {
        // Example1: UnaryOperator to apply a 10% salary increase to employees in the
        // "IT" department
        UnaryOperator<Employee> applyItDepartmentBonus = emp -> {
            if (isFromDepartment.test(emp))
                emp.setSalary(emp.getSalary() * 1.10); // 10% salary increase

            return emp;
        };

        // Example2: UnaryOperator to give a 5% salary boost to employees with more than
        // 5 years of experience
        UnaryOperator<Employee> applyExperienceBonus = emp -> {
            if (isAbove5YearsExperience.test(emp))
                emp.setSalary(emp.getSalary() * 1.05); // 5% salary boost

            return emp;
        };

        // Example3: UnaryOperator to apply a 3% bonus to employees with more than 5
        // years of experience
        // UnaryOperator to apply a 3% bonus if an employee earns more than 50000
        UnaryOperator<Employee> applyHighSalaryBonus = emp -> {
            if (hasSalaryAbove50000.test(emp)) {
                emp.setSalary(emp.getSalary() * 1.03); // 3% salary increase
            }
            return emp;
        };

        // Combined UnaryOperator: apply department bonus first, then experience bonus,
        // then high salary bonus
        Function<Employee, Employee> applyAllBonuses = applyItDepartmentBonus
                .andThen(applyExperienceBonus)
                .andThen(applyHighSalaryBonus);

        // Apply both bonuses sequentially using stream and collect the adjusted list
        List<Employee> adjustedEmployees = Employee.employees.stream()
                .map(applyAllBonuses)
                .collect(Collectors.toList());

        // Display adjusted salaries for all employees
        adjustedEmployees.forEach(printEmployee);
    }
}
