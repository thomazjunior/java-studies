package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates basic concurrency concepts in Java, including thread management,
 * synchronization, and usage of java.util.concurrent utilities such as
 * ExecutorService,
 * AtomicInteger, and CountDownLatch.
 */
public class BasicConceptsExample {

    /**
     * Shared counter resource, demonstrating a thread-safe operation
     * with AtomicInteger to avoid explicit synchronization for counting.
     */
    private static final AtomicInteger counter = new AtomicInteger(0);

    /**
     * Number of tasks to be executed.
     */
    private static final int NUM_TASKS = 5;

    /**
     * Main method, entry point of the application. Initializes a thread pool
     * and uses CountDownLatch to ensure that the main thread waits for
     * all tasks to complete before printing the final counter value.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Using ExecutorService to manage a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // CountDownLatch to synchronize the completion of tasks
        CountDownLatch latch = new CountDownLatch(NUM_TASKS);

        for (int i = 0; i < NUM_TASKS; i++) {
            executorService.submit(() -> {
                try {
                    performTask();
                } finally {
                    latch.countDown(); // Decrement latch after each task completion
                }
            });
        }

        try {
            // Wait for all tasks to finish
            latch.await();
            System.out.println("All tasks completed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }

        // Print the final value of the counter
        System.out.println("Final counter value: " + counter.get());
    }

    /**
     * Simulates a task execution, incrementing the shared counter.
     * This method is synchronized to demonstrate a simple way to control
     * access to shared resources, though AtomicInteger itself is thread-safe.
     */
    private static synchronized void performTask() {
        int taskId = counter.incrementAndGet();
        System.out.println("Task " + taskId + " is being processed by " + Thread.currentThread().getName());

        // Simulate processing time with Thread.sleep
        try {
            Thread.sleep(1000); // Simulates task workload
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task " + taskId + " interrupted.");
        }

        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
    }
}