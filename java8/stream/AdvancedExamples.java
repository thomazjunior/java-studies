package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedExamples {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Élodie", "Émile", "Alice", "Bob");

        // Exemple 1 : Parallélisation d’un flux avec filter et map
        List<String> nomsFiltrés = noms.parallelStream()
                .filter(nom -> nom.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Noms filtrés : " + nomsFiltrés);

        // Exemple 2 : Création d’un histogramme (compter les occurrences)
        Map<String, Long> histogramme = noms.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Histogramme des noms : " + histogramme);

        // Exemple 3 : Utilisation de flatMap pour aplatir une liste de listes
        List<List<Integer>> nombres = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> aplati = nombres.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Liste aplatie : " + aplati);

        // Exemple 4 : Trouver le mot le plus long
        noms.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(nom -> System.out.println("Mot le plus long : " + nom));

        // Exemple 5 : Utilisation d’IntStream pour créer une somme conditionnelle
        int sommePairs = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("Somme des nombres pairs de 1 à 10 : " + sommePairs);

        // Exemple 6 : Collecteur personnalisé pour concaténer les noms avec un séparateur
        String nomsConcaténés = noms.stream()
                .distinct()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
        System.out.println("Noms concaténés : " + nomsConcaténés);

        // Exemple 7 : Partitionner les noms selon leur longueur (plus de 4 lettres ou non)
        Map<Boolean, List<String>> partition = noms.stream()
                .collect(Collectors.partitioningBy(nom -> nom.length() > 4));
        System.out.println("Partition des noms : " + partition);

        // Exemple 8 : Générer un flux infini de nombres aléatoires et en prendre 5
        new Random().ints(1, 100)
                .distinct()
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Exemple 9 : Trouver les trois premiers éléments triés sans doublons
        noms.stream()
                .distinct()
                .sorted()
                .limit(3)
                .forEach(nom -> System.out.print(nom + " "));
        System.out.println();

        // Exemple 10 : Fusionner deux listes en un seul flux
        List<String> autresNoms = Arrays.asList("Zara", "Yann", "Xavier");
        Stream.concat(noms.stream(), autresNoms.stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
