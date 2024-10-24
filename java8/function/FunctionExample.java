package function;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import utils.Employee;

public class FunctionExample {
    public static void main(String[] args) {
        // Define a Function to calculate bonus based on employee's salary
        Function<Employee, Double> calculateBonus = employee -> {
            if (employee.getSalary() > 7000)
                return employee.getSalary() * 0.10; // 10% bonus

            return 0.0;
        };
        // Define a Predicate to filter employees with a bonus greater than 0
        Predicate<Employee> hasBonusGreaterThanZero = emp -> calculateBonus.apply(emp) > 0;

        Function<Employee, String> formatEmployeeBonusInfo = emp -> emp.getName() + " (Department: "
                + emp.getDepartment() + ") qualifies for a bonus of: $" +
                calculateBonus.apply(emp);

        // Define a function to generate summary report for employess who is qualify for
        // bonus
        Function<List<Employee>, String> generateBonusReport = empList -> {
            List<Employee> qualifiedEmployees = empList.stream()
                    // .filter(emp -> calculateBonus.apply(emp) > 0)
                    .filter(hasBonusGreaterThanZero)
                    .collect(Collectors.toList());

            // Create report using stream
            var report = qualifiedEmployees.stream()
                    // .map(emp -> emp.getName() + " (Department: " + emp.getDepartment() + ")
                    // qualifies for a bonus of: $"
                    // + calculateBonus.apply(emp))
                    .map(formatEmployeeBonusInfo)
                    .collect(Collectors.joining("\n"));

            return report.isEmpty() ? "No employees qualify for a bonus." : report;
        };

        Function<Employee, String> printEmployeeBonus = emp -> emp.getName() + " - Bonus: $"
                + calculateBonus.apply(emp);

        // Calculates and display bonuses for all employees
        Employee.employees.stream()
                .map(printEmployeeBonus)
                .forEach(System.out::println);

        // Generate and display bonus report for employees qualify for bonus
        String bonusReport = generateBonusReport.apply(Employee.employees);
        System.out.println("\n" + bonusReport);
    }
}
