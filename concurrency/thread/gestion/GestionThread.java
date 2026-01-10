package concurrency.thread.gestion;

public class GestionThread {

    public static void main(String[] args) throws InterruptedException {

        Recette recette = new Recette();

        Cuisiner c1 = new Cuisiner("Faire fondre le choco", recette, 1);
        Cuisiner c2 = new Cuisiner("Casser le oeufs", recette, 2);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();;
        t2.start();

        t1.join();
        t2.join();


    }
}
