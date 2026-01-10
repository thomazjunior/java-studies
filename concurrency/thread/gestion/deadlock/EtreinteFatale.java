package concurrency.thread.gestion.deadlock;


// Classe principale pour lancer deux threads représentant deux cuisiniers
public class EtreinteFatale {

    public static void main(String[] args) throws InterruptedException {
        // Création de deux cuisiniers avec des tâches différentes
        Cuisiner c1 = new Cuisiner("Casser les oeufs");
        Cuisiner c2 = new Cuisiner("Faire fondre le choco");

        // Création de deux threads : chacun fait travailler un cuisinier
        Thread t1 = new Thread(() -> c1.travailler(c2));
        Thread t2 = new Thread(() -> c2.travailler(c1));

        // Démarrage des threads
        t1.start();
        t2.start();

        // Le thread principal attend que t1 et t2 se terminent
        t1.join();
        t2.join();

        // S'affiche seulement si aucun deadlock ne se produit
        System.out.println("Fin de la cuisine");
    }
}
