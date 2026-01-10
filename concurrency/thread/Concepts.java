package concurrency.thread;

// ==============
// 3. Classe principale
// ==============
public class Concepts {
    public static void main(String[] args) {

        // --------------
        // a) Démarrage d'un thread en héritant de Thread
        // Création de l'obete MonThread
        MonThread mt = new MonThread();
        // start() créé un nouveau thread et appelle run() automatiquement
        // ATTENTION : appeler run() directement ne crée PAS un thread
        mt.start();

        // ----------------
        // b) Démarrage d'un thread avec Runnable
        // -----------------
        //. On passe l'objete Runnable au constructeur de Thread
        new Thread(new MonThreadInterface()).start();

        // -----------------
        // c) Thread avec une classe anonyme
        // -----------------
        // Runnable est implémenté directement sans créer une classe séparée
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("blah blah");
            }
        }).start();

        // ------------------
        // e) Thread principal
        // -------------------
        // Le thread main continue son exécution
        // Il ne bloque PAS le autres threads
        new Thread(() -> System.out.println("Coucou")).start();

        System.out.println("Fin du main");
    }
}
