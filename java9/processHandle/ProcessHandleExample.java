package java9.processHandle;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessHandleExample {
    public static void main(String[] args) {
        System.out.println("🚀 Exemple de l'API ProcessHandle en Java 9");

        // 📌 1. Lister tous les processus en cours
        System.out.println("\n🔹 Processus actifs sur le système :");
        Stream<ProcessHandle> processes = ProcessHandle.allProcesses();
        processes.forEach(process -> {
            System.out.println(getProcessInfo(process));
        });

        // 📌 2. Récupérer les informations du processus actuel
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("\n🔹 Informations sur le processus actuel :");
        System.out.println(getProcessInfo(currentProcess));

        // 📌 3. Trouver et arrêter un processus spécifique (exemple : fermer Notepad sous Windows)
        System.out.println("\n🔹 Tentative d'arrêt de 'notepad.exe' (exemple Windows) :");
        ProcessHandle.allProcesses()
                .filter(p -> p.info().command().orElse("").contains("notepad.exe"))
                .findFirst()
                .ifPresentOrElse(process -> {
                    System.out.println("Processus trouvé : " + getProcessInfo(process));
                    boolean terminated = process.destroy();
                    System.out.println(terminated ? "✅ Processus arrêté !" : "❌ Échec de l'arrêt.");
                }, () -> System.out.println("⚠️ Aucun processus correspondant trouvé."));
    }

    private static String getProcessInfo(ProcessHandle process) {
        ProcessHandle.Info info = process.info();
        Optional<Instant> startTime = info.startInstant();
        Optional<String> command = info.command();
        return "PID : " + process.pid() +
               ", Commande : " + command.orElse("Inconnu") +
               ", Démarré à : " + startTime.map(Instant::toString).orElse("Inconnu");
    }
}

