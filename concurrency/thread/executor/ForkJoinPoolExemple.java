package concurrency.thread.executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinPoolExemple {

    static class Calcul extends RecursiveTask<Integer> {

        private int[] tab;
        private int debut;
        private int fin;

        public Calcul(int[] tab, int debut, int fin) {
            this.tab = tab;
            this.debut = debut;
            this.fin = fin;
        }

        @Override
        protected Integer compute() {
            Integer retval = 0;

            int milieu = (debut - fin) / 2;

            if(milieu > 10){
                    Calcul p1 = new Calcul(tab, debut, debut + milieu - 1);
                    p1.fork();
                    Calcul p2 = new Calcul(tab, debut + milieu, fin);
                    retval = p2.compute() + p1.join();
            } else {
                for (int i = debut; i < fin; i++) {
                    retval += tab[i];
                }
            }

            return retval;
        }
    }

    public static void main(String[] args) {
        int[] tab = IntStream.range(0, 51).toArray();

        Calcul tache = new Calcul(tab, 0, 50);


        ForkJoinPool fjp = new ForkJoinPool();

        Integer valeur = fjp.invoke(tache);

        System.out.println(valeur);
    }
}
