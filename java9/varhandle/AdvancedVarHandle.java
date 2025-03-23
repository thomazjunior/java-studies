package java9.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class AdvancedVarHandle {
    private static final VarHandle ARRAY_HANDLE;
    private final int[] counters = new int[10]; // Tableau de compteurs partagés

    static {
        try {
            ARRAY_HANDLE = MethodHandles.arrayElementVarHandle(int[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void increment(int index) {
        if (index < 0 || index >= counters.length) return;
        ARRAY_HANDLE.getAndAdd(counters, index, 1); // Opération atomique
    }

    public void safeUpdate(int index, int expected, int newValue) {
        if (index < 0 || index >= counters.length) return;
        boolean updated = ARRAY_HANDLE.compareAndSet(counters, index, expected, newValue);
        if (updated) {
            System.out.println("✅ Mise à jour réussie à l'index " + index);
        } else {
            System.out.println("❌ Échec de la mise à jour à l'index " + index);
        }
    }

    public void displayCounters() {
        System.out.print("🔢 États des compteurs : ");
        for (int value : counters) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AdvancedVarHandle example = new AdvancedVarHandle();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Simulation de mises à jour concurrentes
        IntStream.range(0, 1000).forEach(i -> executor.submit(() -> example.increment(i % 10)));

        executor.shutdown();
        while (!executor.isTerminated()) {}

        example.displayCounters();

        // Test d'une mise à jour sécurisée
        example.safeUpdate(2, 100, 200); // Ne mettra à jour que si la valeur à l'index 2 est 100
        example.displayCounters();
    }
}
