package java9.JShell;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import jdk.jshell.VarSnippet;

public class JShellEvaluator {
    public static void main(String[] args) {
        try (JShell jshell = JShell.create()) {
            System.out.println("[JShell] Exécution dynamique de code Java...");

            // Exécuter une instruction simple
            List<SnippetEvent> events = jshell.eval("int x = 10; x * 2;");
            for (SnippetEvent event : events) {
                if (event.status() == Snippet.Status.VALID) {
                    System.out.println("[JShell] Résultat: " + event.value());
                }
            }

            // Déclarer une fonction et l'exécuter
            jshell.eval("int somme(int a, int b) { return a + b; }");
            List<SnippetEvent> sumResult = jshell.eval("somme(5, 7);");

            for (SnippetEvent event : sumResult) {
                if (event.status() == Snippet.Status.VALID) {
                    System.out.println("[JShell] Somme(5,7) = " + event.value());
                }
            }

            // Vérifier les variables définies
            System.out.println("[JShell] Variables définies :");
            jshell.variables().forEach(var -> {
                VarSnippet varSnippet = var;
                System.out.println("Nom: " + varSnippet.name() + ", Valeur: " + jshell.varValue(var));
            });

        } catch (Exception e) {
            System.err.println("[JShell] Erreur : " + e.getMessage());
        }
    }
}
