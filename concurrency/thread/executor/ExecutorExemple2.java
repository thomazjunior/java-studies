package concurrency.thread.executor;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorExemple2 {

    static class Calcul implements Callable<Integer> {
        private int[] tab;
        private int debut;
        private int fin;

        public Calcul(int[] donnees, int i, int i1) {
            this.tab = donnees;
            this.debut = i;
            this.fin = i1;
        }

        @Override
        public Integer call() throws Exception {
            int retval = 0;
            for (int i = debut; i <= fin; i++) {
                retval += tab[i];
            }
            return retval;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] donnees = IntStream.range(0, 51).toArray();

        Calcul c1 = new Calcul(donnees, 0, 25);
        Calcul c2 = new Calcul(donnees, 26, 50);


        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = es.submit(c1);
        Future<Integer> f2 = es.submit(c2);


        int valeur = f1.get() + f2.get();

        System.out.println("valeur : " + valeur);

        es.shutdown();

    }
}
