package concurrency.thread;

public class Cuisinier implements Runnable {

    private String tache;

    public Cuisinier(String tache) {
        this.tache = tache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().threadId() + " " + tache);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //...
            }
        }
    }
}
