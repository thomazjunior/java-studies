package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeExamples {
    public static void main(String[] args) {
        copyOnWriteExample();
        synchronizedListExample();
        arrayListExample();
    }

    // Example 1: CopyOnWriteArrayList for thread-safe iteration and modification
    static void copyOnWriteExample() {
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>(List.of("Apple", "Banana", "Cherry"));

        System.out.println("CopyOnWriteArrayList Initial: " + copyOnWriteList);

        // Simulate modification while iterating safely
        CompletableFuture<Void> modifyingFuture = CompletableFuture.runAsync(() -> {
            copyOnWriteList.add("Dragonfruit"); // Safe modification
            System.out.println("Added Dragonfruit to CopyOnWriteArrayList");
        });

        // Reading while modifying
        CompletableFuture<Void> readingFuture = CompletableFuture.runAsync(() -> {
            for (String fruit : copyOnWriteList) {
                // Simulating a read delay
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(fruit + " ");
            }
            System.out.println();
        });

        CompletableFuture.allOf(modifyingFuture, readingFuture).join();
        System.out.println("Final CopyOnWriteArrayList: " + copyOnWriteList);
    }

    // Example 2: Synchronized List for safe modification across threads
    public static void synchronizedListExample() {
        System.out.println("\n--- Synchronized List Example ---");

        // Create a synchronized list
        List<String> synchronizedList = createSynchronizedList(DataUtil.getMockFruitsArrayList());
        System.out.println("Initial Synchronized List: " + synchronizedList);

        // Using CompletableFuture for better async handling
        CompletableFuture<Void> modifyingFuture = CompletableFuture.runAsync(() -> modifyList(synchronizedList));
        CompletableFuture<Void> readingFuture = CompletableFuture.runAsync(() -> readList(synchronizedList));

        // Wait for both tasks to complete
        CompletableFuture.allOf(modifyingFuture, readingFuture).join();

        // Bad usage: Attempting to modify the synchronized list without synchronization
        demonstrateBadUsage(synchronizedList);

        // Safe final output after all modifications
        System.out.println("\nFinal Synchronized List: " + synchronizedList);
    }

    private static List<String> createSynchronizedList(List<String> mockFruits) {
        return Collections.synchronizedList(new ArrayList<>(mockFruits));
    }

    private static void modifyList(List<String> synchronizedList) {
        synchronizedList.add("Mango");
        synchronizedList.add("Pineapple");
        System.out.println("Thread added Mango and Pineapple");
    }

    private static void readList(List<String> synchronizedList) {
        // Iterate over the synchronized list
        synchronized (synchronizedList) {
            System.out.print("Thread reading Synchronized List: ");
            Iterator<String> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                // Simulate delay to make the modification visible
                try {
                    Thread.sleep(100); // Sleep for 100ms
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    private static void demonstrateBadUsage(List<String> synchronizedList) {
        System.out.println("\n--- Bad Usage Example ---");
        System.out.print("Iterating over Synchronized List without synchronization: ");

        // This is a potential unsafe operation; uncomment to see the issue in action
        /*
         * for (String fruit : synchronizedList) {
         * if ("Banana".equals(fruit)) {
         * synchronizedList.add("Kiwi"); // This could lead to
         * ConcurrentModificationException
         * }
         * System.out.print(fruit + " ");
         * }
         */
    }

    // Example 3: ArrayList (not thread-safe)
    static void arrayListExample() {
        System.out.println("\n--- ArrayList Example (Not Thread-Safe) ---");
        List<String> arrayList = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));
        System.out.println("Initial ArrayList: " + arrayList);

        // Simulate concurrent modification
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            arrayList.add("Mango");
            System.out.println("Added Mango to ArrayList");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Reading ArrayList: " + arrayList);
        });

        CompletableFuture.allOf(future, future2).join(); // Wait for both tasks to complete
        System.out.println("Final ArrayList: " + arrayList);
    }
}
