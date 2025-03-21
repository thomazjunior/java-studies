package collectors;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Classe représentant un employé avec nom, département, salaire et âge.
class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary;
    }
}

public class CollectorsExample {
    public static void main(String[] args) {
        // Création d'une liste d'employés
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 5000, 28),
            new Employee("Bob", "RH", 4000, 35),
            new Employee("Charlie", "IT", 7000, 40),
            new Employee("David", "Finance", 6000, 50),
            new Employee("Eve", "RH", 3000, 24),
            new Employee("Frank", "IT", 8000, 32)
        );

        // 1. Grouper les employés par département
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employés groupés par département :");
        employeesByDept.forEach((dept, empList) -> System.out.println(dept + " -> " + empList));

        // 2. Compter le nombre d'employés par département
        Map<String, Long> employeeCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("\nNombre d'employés par département : " + employeeCountByDept);

        // 3. Trouver le salaire le plus élevé par département
        Map<String, Optional<Employee>> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        System.out.println("\nSalaire le plus élevé par département :");
        highestSalaryByDept.forEach((dept, emp) -> System.out.println(dept + " -> " + emp.get()));

        // 4. Calculer le salaire moyen par département
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("\nSalaire moyen par département : " + avgSalaryByDept);

        // 5. Partitionner les employés selon leur salaire (plus de 5000€ ou non)
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 5000));

        System.out.println("\nEmployés partitionnés par salaire :");
        System.out.println("Supérieur à 5000€ : " + partitionedBySalary.get(true));
        System.out.println("Inférieur ou égal à 5000€ : " + partitionedBySalary.get(false));

        // 6. Collecter les noms des employés sous forme de chaîne CSV
        String employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("\nListe des noms d'employés : " + employeeNames);
    }
}

