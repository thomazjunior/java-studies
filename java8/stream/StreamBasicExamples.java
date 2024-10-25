package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamBasicExamples {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Eve", "Bob");
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<String> filterName = name -> name.startsWith("A");

        // Example 1: Filter names that start with "A" and print then
        names.stream()
                .filter(filterName)
                // Method reference
                .forEach(System.out::println);

        // Example 2: Using map to convert names to uppercase
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Example 3: Using reduce to sum values
        int result = values.stream().reduce(0, Integer::sum);
        System.out.println("Result: " + result);

        // Example 4: Group names by their first letter
        Map<Character, List<String>> groupNames = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupNames);

        // Example 5: Using Set to get unique names
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println("Unique names: " + uniqueNames);
    }

}
