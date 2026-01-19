package org.example.creation.monteur;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Maison en bois et verre
        Monteur boisVerre = new MaisonBoisVerreMonteur();
        Directeur directeur1 = new Directeur(boisVerre);
        directeur1.construireMaisonComplete();
        System.out.println(directeur1.getMaison());

        // Château en pierre et fer
        Monteur pierreFer = new ChateauPierreFerMonteur();
        Directeur directeur2 = new Directeur(pierreFer);
        directeur2.construireMaisonComplete();
        System.out.println(directeur2.getMaison());

    }
}
