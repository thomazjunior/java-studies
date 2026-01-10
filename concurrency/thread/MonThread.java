package concurrency.thread;

// =====================
// 1. Création d'un thread en héritant de la classe Thred
// =====================
public class MonThread extends Thread {

    // La méthode run() contient le code qui sera exécuté
    // lorsque le thread démarre
    @Override
    public void run() {
        // Boucle pour montrer que le thread s'exécute plusieurs fois
        for (int i = 0; i < 1000; i++) {
            System.out.println("Exécution du Thread");
        }
    }
}
