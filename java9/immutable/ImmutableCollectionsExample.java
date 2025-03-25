package java9.immutable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        System.out.println("🚀 Démonstration des collections immuables en Java 9");

        // 📌 Création d'une liste immuable
        List<String> fruits = List.of("🍎 Pomme", "🍌 Banane", "🍇 Raisin");
        System.out.println("✅ Liste immuable : " + fruits);

        // 📌 Création d'un ensemble immuable
        Set<String> couleurs = Set.of("🔵 Bleu", "🟢 Vert", "🔴 Rouge");
        System.out.println("✅ Set immuable : " + couleurs);

        // 📌 Création d'une map immuable
        Map<String, Integer> scores = Map.of(
                "Alice", 100,
                "Bob", 200,
                "Charlie", 150
        );
        System.out.println("✅ Map immuable : " + scores);

        // 📌 Tentative de modification (provoque une exception)
        try {
            fruits.add("🍊 Orange");
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ Erreur : Impossible d'ajouter un élément à une liste immuable !");
        }
    }
}
