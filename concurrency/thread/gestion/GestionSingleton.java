package concurrency.thread.gestion;

public class GestionSingleton {

    public static void main(String[] args) {
        new Thread(() -> {
            Connexion.getInstance().open();
        }).start();

        new Thread(() -> {
            Connexion.getInstance().open();
        }).start();
    }
}
