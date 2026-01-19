package org.example.creation.monteur.maison;

// Directeur.java
public class Directeur {
    private Monteur monteur;

    public Directeur(Monteur monteur) {
        this.monteur = monteur;
    }

    // Routine de construction complète
    public void construireMaisonComplete() {
        monteur.construireMurs();
        monteur.construirePortes();
        monteur.construireToit();
        monteur.construirePiscine();
    }

    // Routine minimale (exemple)
    public void construireMaisonSimple() {
        monteur.construireMurs();
        monteur.construirePortes();
        monteur.construireToit();
    }

    public Maison getMaison() {
        return monteur.getMaison();
    }
}
