package complebleFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdvancedCompletableFutureDemo {
    
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private static final Random random = new Random();

    public static void main(String[] args) {
        AdvancedCompletableFutureDemo demo = new AdvancedCompletableFutureDemo();

        // Exécuter tous les exemples
        demo.runExamples();

        executor.shutdown(); // Arrêter le pool de threads après utilisation
    }

    private void runExamples() {
        CompletableFuture<String> api1 = fetchDataFromApi("Service-A");
        CompletableFuture<String> api2 = fetchDataFromApi("Service-B");
        
        // 1️⃣ Combiner les résultats de deux appels API
        CompletableFuture<String> combinedFuture = api1.thenCombine(api2, (result1, result2) ->
                "Données fusionnées : [" + result1 + "] & [" + result2 + "]");
        
        System.out.println(combinedFuture.join());

        // 2️⃣ Exécuter plusieurs tâches en parallèle et attendre la fin
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(api1, api2, fetchDataFromApi("Service-C"));
        allTasks.join(); // Attendre la complétion de toutes les tâches
        System.out.println("Tous les appels API sont terminés !");

        // 3️⃣ Première réponse disponible (course entre les tâches)
        CompletableFuture<String> firstResponse = CompletableFuture.anyOf(api1, api2)
                .thenApply(result -> "Réponse la plus rapide : " + result);
        System.out.println(firstResponse.join());

        // 4️⃣ Gestion des erreurs de manière résiliente
        CompletableFuture<String> futureWithError = fetchDataWithError("Service-D")
                .exceptionally(ex -> "Données de secours : réponse par défaut en raison de " + ex.getMessage());
        System.out.println(futureWithError.join());

        // 5️⃣ Gestion du timeout
        CompletableFuture<String> timeoutFuture = fetchDataWithDelay("Service-Lent", 5)
                .orTimeout(2, TimeUnit.SECONDS)
                .exceptionally(ex -> "Timeout atteint : " + ex.getMessage());
        System.out.println(timeoutFuture.join());
    }

    // Simule un appel API avec un délai aléatoire
    private CompletableFuture<String> fetchDataFromApi(String serviceName) {
        return CompletableFuture.supplyAsync(() -> {
            simulateRandomDelay();
            return serviceName + " Réponse";
        }, executor);
    }

    // Simule un appel API qui peut échouer
    private CompletableFuture<String> fetchDataWithError(String serviceName) {
        return CompletableFuture.supplyAsync(() -> {
            if (random.nextBoolean()) {
                throw new RuntimeException(serviceName + " a échoué !");
            }
            return serviceName + " Succès !";
        }, executor);
    }

    // Simule un appel API avec un délai fixe
    private CompletableFuture<String> fetchDataWithDelay(String serviceName, int seconds) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return serviceName + " Réponse";
        }, executor);
    }

    // Simule un délai réseau aléatoire
    private void simulateRandomDelay() {
        try {
            int delay = random.nextInt(3) + 1;
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
