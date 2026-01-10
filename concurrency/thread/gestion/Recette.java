package concurrency.thread.gestion;

public class Recette {

    private int etat;

    public void etatOeufsOf() {
        etat = 1;
    }


    public void etatChocoOk() {
        etat = 2;
    }

    public int getEtat() {
        return etat;
    }
}
