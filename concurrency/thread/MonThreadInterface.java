package concurrency.thread;

// ================
// 2. Création d'un thread en implémentant l'interface Runnable
// ================
public class MonThreadInterface implements Runnable {

    // La méthode run() définit le travail du thread
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Le thread qui implément Runnable");
        }
    }
}
