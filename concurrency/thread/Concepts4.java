package concurrency.thread;

public class Concepts4 {

    public static void main(String[] args) throws InterruptedException {

        // Création du premier Cuisiner avec une tâche spécifique
        Cuisinier c1 = new Cuisinier("Faire fondre le choco");

        // Création du second Cuisiner avec une autre tâche
        Cuisinier c2 = new Cuisinier("Casser les oeufs");

        // Création d'un theread pour éxecuter la tâche du premier cuisiner
        Thread t1 = new Thread(c1, "Fabien");
        t1.start(); // Démarre le thread t1, la tâche de c1 s'exécute en parallèle

        // Création d'un thread pour exécuter la tâche du second cuisiner
        Thread t2 = new Thread(c2, "Xavier");
        t2.start(); // Démarre le thread t2, la tâche de c2 s'exécute en parallèle

        // La méthode join() bloque le thread principal (main)
        // jusqu'à ce que t1 et t2 aient terminé leur exécution
        t1.join();
        t2.join();

        if(t1.isAlive())
            System.out.println("T1 est vivant");
        else
            System.out.println("T1 est mort");

        // ATTENTION : relancer un thread déjà terminé est interdit en Java
        // La ligne suivante provoque une IllegalThreadStateException
        // t1.start();

        System.out.println("Faire le mélange");
    }

}
