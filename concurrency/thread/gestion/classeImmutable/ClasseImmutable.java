package concurrency.thread.gestion.classeImmutable;

public class ClasseImmutable {
    static Personne p;
    public static void main(String[] args) {

        new Thread(() -> {
            p = new Personne("fabien");

            for (int i = 0; i < 100; i++) {
                System.out.println("La personne " + p.getNom());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //....
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(p != null) p.remplaceNom("Xavier");
            }
        }).start();
    }
}
