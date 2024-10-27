package collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListBasicExamples {

    // Demonstrating CopyOnWriteArrayList for concurrency
    public static void concurrentAccessExample() {
        List<String> concurrentList = new CopyOnWriteArrayList<>(DataUtil.getMockFruitsArrayList());
        System.out.println("Initial Concurrent List: " + concurrentList);

        // Simulate concurrent modification
        for (String fruit : concurrentList) {
            if ("Banana".equals(fruit)) {
                concurrentList.add("Dragonfruit");
            }
            System.out.print(fruit + " ");
        }
        System.out.println("\nConcurrent List after modification: " + concurrentList);
    }

    // Removing elements during iteration in LinkedList
    public static void removeDuringIterationLinkedList() {
        List<String> linkedList = new LinkedList<>(DataUtil.getMockFruitsLinkedList());
        System.out.println("Original LinkedList: " + linkedList);

        // Remove elements during iteration
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.startsWith("E")) {
                iterator.remove();
            }
        }
        System.out.println("LinkedList after removing elements starting with 'E': " + linkedList);
    }

    public static void main(String[] args) {

        // Example 1: ArrayList
        System.out.println("ArrayList Example:");
        List<String> arrayList = DataUtil.getMockFruitsArrayList();
        System.out.println("ArrayList Elements: " + arrayList);

        // Access elements
        System.out.println("Element at index 2: " + arrayList.get(2));

        // Remove an element
        arrayList.remove("Banana");
        System.out.println("After removal: " + arrayList);

        // Iterate over ArrayList
        System.out.print("Iterating over ArrayList: ");
        for (String fruit : arrayList) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");

        // Example 2: LinkedList
        System.out.println("LinkedList Example:");
        List<String> linkedList = DataUtil.getMockFruitsLinkedList();
        System.out.println("LinkedList Elements: " + linkedList);

        // Add elements at specific positions
        linkedList.add(1, "Blueberry");
        System.out.println("After adding at index 1: " + linkedList);

        // Remove the first and last elements
        ((LinkedList<String>) linkedList).removeFirst();
        ((LinkedList<String>) linkedList).removeLast();
        System.out.println("After removing first and last: " + linkedList);

        // Iterate over LinkedList using a forEach loop
        System.out.print("Iterating over LinkedList: ");
        linkedList.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println("\n");

        // Example 3: Vector
        System.out.println("Vector Example:");
        List<String> vector = DataUtil.getMockFruitsVector();
        System.out.println("Vector Elements: " + vector);

        // Check if an element exists
        System.out.println("Contains 'Kiwi': " + vector.contains("Kiwi"));

        // Iterate over Vector using an iterator
        System.out.print("Iterating over Vector: ");
        for (String fruit : vector) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");

        concurrentAccessExample();
    }
}