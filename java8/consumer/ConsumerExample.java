package consumer;

import java.util.function.Consumer;

import utils.Employee;

public class ConsumerExample {
    public static void main(String[] args) {

        // Define a Consumer to modify employee attributes and print details
        Consumer<Employee> updateEmployeeDetails = employee -> {
            // Increase salary by 10% if experience is greater than 5 years
            if (employee.getExperience() > 5) {
                double newSalary = employee.getSalary() * 1.1;
                employee.setSalary(newSalary);
            }

            // Promote employees with specific job title
            if ("Junior Engineer".equals(employee.getJobTitle())) {
                employee.setJobTitle("Senior Engineer");
            }
            System.out.println(employee);
        };

        // Use Consumer to process each employee
        System.out.println("\nUpdated Employee details");
        Employee.employees.forEach(updateEmployeeDetails);

    }
}
