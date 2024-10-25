package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import utils.GenericDataProvider;
import utils.Person;

public class CollectorExample {

    public static void main(String[] args) {
        // Create a GenericDataProvider for Person objects
        GenericDataProvider<Person> personProvider = new GenericDataProvider<>(Person::new);
        // Generate 10 random Person instances
        List<Person> people = personProvider.generate(10);

        // Grouping by gender
        Map<String, List<Person>> groupedByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupedByGender.forEach((gender, personList) -> {
            System.out.println(gender + ": " + personList);
        });

        // Collect names of people into a list
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        // Print the list of names
        System.out.println("\nList of Names:");
        System.out.println(names);

        // Calculate average age of people
        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();
        averageAge.ifPresent(avg -> System.out.printf("Average age: %.2f%n", avg));

        // Group by gender, then age range
        Map<String, Map<String, List<Person>>> groupedByGenderAndAge = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.groupingBy(person -> person.getAge() < 30 ? "Under 30" : "30 and above")));

        // Custom output
        groupedByGenderAndAge.forEach((gender, ageGroupMap) -> {
            System.out.println("Gender: " + gender);
            ageGroupMap.forEach((ageGroup, persons) -> {
                System.out.println("  Age Group: " + ageGroup);
                persons.forEach(
                        person -> System.out.println("    Name: " + person.getName() + ", Age: " + person.getAge()));
            });
        });

    }

}
