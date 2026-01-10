package concurrency.thread.gestion.blocGarde;

public class Recette {

    private boolean oeufsOk = false;
    private boolean chocoFondu = false;

    synchronized void faireFondreChoco() {
        System.out.println("choco fondu");
        if (!oeufsOk) {
            try {
                wait();
            } catch (InterruptedException e) {
                //....
            }
        }

        System.out.println("Alors finisson le mélange");
    }

    synchronized void casserLesOeufs() {
        System.out.println("oeufs cassés");
        oeufsOk = true;
        notifyAll();
    }

}
