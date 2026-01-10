package concurrency.thread.gestion.deadlock;

// Classe représentant un cuisinier qui effectue une tâche
public class Cuisiner {
    private String tache;
    private boolean fini = false; // Indique si la tâche est terminée

    public Cuisiner(String tache) {
        this.tache = tache;
    }

    /**
     * Méthode synchronisée : un thread doit acquérir le verrou sur "this"
     * avant d'entrer dans cette méthode.
     *
     * @param autre : le second cuisinier à vérifier
     */
    synchronized void travailler(Cuisiner autre) {
        // Simulation du travail du cuisinier : affichage de sa tâche 10 fois
        for (int i = 0; i < 10; i++) {
            System.out.println(tache);
        }

        // Marque la tâche comme terminée
        fini = true;

        // Vérifie si l'autre cuisinier a terminé sa tâche
        // ATTENTION : appel à une méthode synchronisée de l'autre objet
        // -> risque de deadlock si l'autre thread fait exactement la même chose
        if(autre.asTuFini()){
            System.out.println("C'est bon pour moi");
        }
    }

    /**
     * Méthode pour savoir si la tâche est terminée
     * Synchronisée pour garantir une lecture cohérente
     */
    synchronized boolean asTuFini() {
        return fini;
    }
}
