package concurrency.thread.collectionsConcurrentes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SystemeCommandes {

    // Capacité limitée : back-pressure
    private static final int CAPACITE_QUEUE = 5;
    private static final int NB_CLIENTS = 3;
    private static final int NB_TRAVAILLEURS = 2;

    // Poison pill pour arrêter proprement les workers
    private static final String POISON = "STOP";

    // File partagée thread-safe
    private static final BlockingQueue<String> commandes =
            new ArrayBlockingQueue<>(CAPACITE_QUEUE);

    public static void main(String[] args) throws InterruptedException {

        // === PRODUCTEURS : clients ===
        for (int i = 1; i <= NB_CLIENTS; i++) {
            int idClient = i;
            new Thread(() -> produireCommandes(idClient),
                    "Client-" + idClient).start();
        }

        // === CONSOMMATEURS : travailleurs ===
        Thread[] workers = new Thread[NB_TRAVAILLEURS];
        for (int i = 0; i < NB_TRAVAILLEURS; i++) {
            workers[i] = new Thread(() -> consommerCommandes(),
                    "Worker-" + (i + 1));
            workers[i].start();
        }

        // Attendre que les clients finissent
        Thread.sleep(3000);

        // Envoi du poison pill pour chaque worker
        for (int i = 0; i < NB_TRAVAILLEURS; i++) {
            commandes.put(POISON);
        }

        // Attendre la fin des workers
        for (Thread w : workers) {
            w.join();
        }

        System.out.println("🟢 Système arrêté proprement");
    }

    // ================= MÉTHODES =================

    // Producteur
    private static void produireCommandes(int idClient) {
        try {
            for (int i = 1; i <= 5; i++) {
                String commande = "Commande " + i + " du client " + idClient;
                System.out.println(Thread.currentThread().getName()
                        + " produit -> " + commande);

                commandes.put(commande); // bloque si la queue est pleine
                Thread.sleep(200);
            }
        } catch (InterruptedException ignored) {
        }
    }

    // Consommateur
    private static void consommerCommandes() {
        try {
            while (true) {
                String commande = commandes.take(); // bloque si vide

                if (commande.equals(POISON)) {
                    System.out.println(Thread.currentThread().getName()
                            + " reçoit STOP");
                    break;
                }

                System.out.println(Thread.currentThread().getName()
                        + " traite -> " + commande);
                Thread.sleep(500); // traitement long
            }
        } catch (InterruptedException ignored) {
        }
    }
}
