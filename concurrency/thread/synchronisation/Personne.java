package concurrency.thread.synchronisation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Personne {

    private int age;
    private int experience;

    private Lock verrou = new ReentrantLock();


    public void joyeuxAnniversaire() {
        verrou.lock();
        System.out.println("Entrée : " + Thread.currentThread().threadId());

        try {
            age++;
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                //...
            }
            experience++;
            System.out.println(Thread.currentThread().threadId() + " " + this);
        } finally {
            System.out.println("Sortie : " + Thread.currentThread().threadId());
            verrou.unlock();
        }
    }

    @Override
    public String toString() {
        if (experience > age) return "Un beau CV ! exp : " + experience + " age: " + age;
        else if (age > experience) return "N'a rien appris ? exp : " + experience + " age :" + age;
        else return "tout est ok";
    }
}
