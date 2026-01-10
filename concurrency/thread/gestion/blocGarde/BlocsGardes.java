package concurrency.thread.gestion.blocGarde;

public class BlocsGardes {

    public static void main(String[] args) throws InterruptedException {
        Recette recette = new Recette();

        Chef chef = new Chef(recette);
        Marmiton mar = new Marmiton(recette);

        Thread t1 = new Thread(chef);
        Thread t2 = new Thread(mar);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Fin de la cuisine");

    }
}
