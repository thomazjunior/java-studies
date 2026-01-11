package concurrency.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExemple {

    public static void main(String[] args) {
        // java.util.concurrent
        // Executor : s'utilise comme Thread : appel une méthode execute (Runnable)
        // utilisation problable d'un thread existant

        // ExecutorServide est une sous-interface, submit(Runnable) ou Callable
        // retour possible

        // ScheduleExecutorService sous-interface, lance des tâches avec
        // des délais et des répétitions

        Executor exe = Executors.newSingleThreadExecutor();
        exe.execute(() -> System.out.println("Exécution dans " + Thread.currentThread().getName()));

        System.out.println("Exécution dans " + Thread.currentThread().getName());
    }
}
