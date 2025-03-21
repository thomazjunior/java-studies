package optional;

import java.util.Optional;

public class AdvancedOptionalDemo {

    public static void main(String[] args) {
        AdvancedOptionalDemo demo = new AdvancedOptionalDemo();

        // Exécuter les démonstrations
        demo.optionalExamples();
    }

    private void optionalExamples() {
        Optional<String> optionalValue = getOptionalValue(true);
        Optional<String> emptyOptional = getOptionalValue(false);

        // 1️⃣ Vérification et exécution conditionnelle avec ifPresent
        optionalValue.ifPresent(value -> System.out.println("Valeur présente : " + value));

        // 2️⃣ Valeur par défaut avec orElse et orElseGet
        String result1 = optionalValue.orElse("Valeur défaut");
        String result2 = emptyOptional.orElseGet(() -> "Valeur calculée");

        System.out.println("Résultat 1 : " + result1);
        System.out.println("Résultat 2 : " + result2);

        // 3️⃣ Lancer une exception si la valeur est absente
        try {
            String result3 = emptyOptional.orElseThrow(() -> new RuntimeException("Valeur manquante !"));
            System.out.println("Résultat 3 : " + result3);
        } catch (Exception e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        }

        // 4️⃣ Transformation avec map et flatMap
        Optional<Integer> length = optionalValue.map(String::length);
        System.out.println("Longueur de la chaîne : " + length.orElse(0));

        // 5️⃣ Filtrage conditionnel
        Optional<String> filtered = optionalValue.filter(s -> s.startsWith("Hello"));
        System.out.println("Filtrage : " + filtered.orElse("Non valide"));
    }

    private Optional<String> getOptionalValue(boolean present) {
        return present ? Optional.of("Hello, Optional!") : Optional.empty();
    }
}
