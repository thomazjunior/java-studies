package java9.stackWalker;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerExample {
    public static void main(String[] args) {
        System.out.println("🚀 Test de StackWalker en Java 9");
        firstMethod();
    }

    static void firstMethod() {
        secondMethod();
    }

    static void secondMethod() {
        thirdMethod();
    }

    static void thirdMethod() {
        // 📌 1. Afficher toute la pile d'exécution
        System.out.println("\n🔹 Pile complète :");
        StackWalker.getInstance().forEach(frame -> 
            System.out.println(frame.getClassName() + " -> " + frame.getMethodName())
        );

        // 📌 2. Récupérer uniquement le dernier appel (méthode en cours)
        System.out.println("\n🔹 Méthode en cours :");
        String currentMethod = StackWalker.getInstance()
                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Inconnu"));
        System.out.println("Méthode actuelle : " + currentMethod);

        // 📌 3. Filtrer la pile (ex: ignorer les méthodes internes de Java)
        System.out.println("\n🔹 Pile filtrée (excluant java.lang.) :");
        List<String> filteredStack = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE)
                .walk(frames -> frames
                        .filter(frame -> !frame.getClassName().startsWith("java.lang"))
                        .map(frame -> frame.getClassName() + " -> " + frame.getMethodName())
                        .collect(Collectors.toList())
                );
        filteredStack.forEach(System.out::println);
    }
}

