package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demonstrates real-world concurrency by processing user data in parallel.
 * Each user data record is processed by a thread, simulating a batch-processing
 * job.
 * Utilizes Java concurrency utilities including ExecutorService, Future, and
 * ConcurrentHashMap.
 */
public class UserDataProcessingExample {

    // Concurrent map to store processing results with thread safety
    private static final Map<Integer, String> processedData = new ConcurrentHashMap<>();
    // Thread pool with a fixed number of threads
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        // Simulated list of user IDs to process
        List<Integer> userIds = List.of(101, 102, 103, 104, 105, 106, 107, 108);

        // Process user data and retrieve the result
        processUserData(userIds);

        // Shut down the executor
        executor.shutdown();

        System.out.println("\nProcessed Data Results:");
        processedData.forEach((userId, result) -> System.out.println("User " + userId + ": " + result));
    }

    /**
     * Processes a list of user IDs by submitting each user ID to a thread pool.
     * Each user ID is processed in a separate thread, with results stored in a
     * concurrent map.
     * 
     * @param userIds List of user IDs to process
     */
    public static void processUserData(List<Integer> userIds) {
        List<Future<?>> futures = new ArrayList<>();

        for (Integer userId : userIds) {
            Future<?> future = executor.submit(() -> {
                String result = processSingleUser(userId);
                processedData.put(userId, result);
            });
            futures.add(future);
        }

        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error processing user data: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Simulates processing of a single user's data. Mimics data processing logic
     * by introducing a delay and returns a "Processed" message.
     * 
     * @param userId User ID to process
     * @return A message indicating that processing is complete
     */
    private static String processSingleUser(Integer userId) {
        try {
            // Simulate time-consuming data processing
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Processing interrupted for user " + userId;
        }
        return "Processed";
    }
}
