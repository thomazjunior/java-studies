package concurrency.thread.gestion;

public class Cuisiner implements Runnable {

    private String tache;
    private Recette recette;
    private int etat;

    public Cuisiner(String tache, Recette recette, int etat) {
        this.tache = tache;
        this.recette = recette;
        this.etat = etat;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(tache);
        }

        if (etat == 1) {
            if (recette.getEtat() == 0) {
                recette.etatOeufsOf();
            } else recette.etatChocoOk();
        }


    }
}
