package concurrency.thread.collectionsConcurrentes;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CollenctionsConcurrentes {
    static BlockingQueue bq = new ArrayBlockingQueue(3);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("je produis...");
                try {
                    bq.put(i);
                } catch (InterruptedException e) {
                    //...
                }
                System.out.println("fini de produire...");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("A consomme..");
                try {
                    System.out.println(bq.take());
                } catch (InterruptedException e) {
                    //...
                }
                System.out.println("A finit de consommer...");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("B consomme..");
                try {
                    System.out.println(bq.take());
                } catch (InterruptedException e) {
                    //...
                }
                System.out.println("B finit de consommer...");
            }
        }).start();
    }

}
