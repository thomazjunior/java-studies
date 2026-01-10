package concurrency.thread;

public class Concepts2 {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Le thread1 tourne..."); // affiche un message à chaque itération
                    Thread.sleep(10); // met le thread en pause pendant 10 ms (bloque le thread)
                }
            } catch (InterruptedException e) {
                // Cette exception est levée si le thread est interrompu pendant sleep()
                System.out.println("Thread1 interrompu..."); // message d'interruption
            }
        });

        t.start(); // Démarre l'exécution du thread t

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("Le thread2 tourne..."); // affiche un message à chaque itération

                // Vérifie si le thread a été interrompu
                // Thread.interrupted() retourne true si le thread courant a été interrompu
                if (Thread.interrupted()) {
                    System.out.println("Thread2 interrompu"); // message d'interruption
                    break; // sort de la boucle et termine le thread
                }
            }
        });

        t2.start(); // Démarre l'exécution du thread t2

        // Boucle du thread principal (main)
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread..."); // affiche un message à chaque itération
        }

        // Interrompt les deux threads t et t2
        // Cela ne force pas l'arrêt immédiat, mais envoie un signal d'interruption
        t.interrupt();
        t2.interrupt();
    }

}
