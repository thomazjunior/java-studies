package concurrency.thread.synchronisation;

public class Synchronisation {

    static Personne qq;

    public static void main(String[] args) {
        qq = new Personne();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                qq.joyeuxAnniversaire();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                qq.joyeuxAnniversaire();
            }
        });

        t1.start();
        t2.start();
    }

}
