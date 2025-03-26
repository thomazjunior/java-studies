package java10.localVarInferance;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LocalVarInferenceExample {
    public static void main(String[] args) {
        // 📌 1. Utilisation de 'var' pour des collections complexes
        var list = List.of("Java", "Java 10", "Local-Variable Type Inference");

        // 📌 2. Itération sur la liste avec une variable inférée
        for (var item : list) {
            System.out.println("Élément : " + item);
        }

        // 📌 3. Utilisation de 'var' pour la création de Map
        var map = new HashMap<String, Integer>();
        map.put("Java", 10);
        map.put("Kotlin", 5);
        
        // 📌 4. Parcours et affichage de la map avec des variables locales inférées
        map.forEach((var key, var value) -> {
            System.out.println("Clé : " + key + " | Valeur : " + value);
        });
        
        // 📌 5. Exemple avec un stream pour filtrer et transformer des données
        var filtered = list.stream()
                           .filter(item -> item.contains("Java"))
                           .map(String::toUpperCase)
                           .collect(Collectors.toList());  // Correct method for Java 10

        // 📌 Affichage du résultat filtré et transformé
        filtered.forEach(System.out::println);
    }
}
