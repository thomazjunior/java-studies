package concurrency;

import java.util.stream.IntStream;

public class BasicConceptsExample1 {

    public static void main(String[] args) {
        // Step 1: Basic Thread and Runnable example
        basicThreadExample();
    }

    public static void basicThreadExample() {
        int numbersOfThreads = 5;

        IntStream.range(0, numbersOfThreads).forEach(threadId -> {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " is starting " + Thread.currentThread().getName());
                    Thread.sleep(2000); // Simulate workload
                    System.out.println("Thread " + threadId + " is finishing " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.err.println("Thread " + threadId + "was interrupted " + e.getMessage());
                }
            }, "Custom thread-" + threadId);

            thread.start();
        });
    }

}
