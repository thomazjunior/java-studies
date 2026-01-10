package concurrency.thread.gestion.atomic;

public class GestionAtomic {
    public static int age = 0;
    public static int datenaissance = 0;
    public static long compteur = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                age = 15;
                datenaissance = 2000;
                compteur = 10000;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("age " + age + " date " + datenaissance + " compteur " + compteur);
                age = 0;
                datenaissance = 0;
                compteur = 0;
            }
        }).start();
    }

}
