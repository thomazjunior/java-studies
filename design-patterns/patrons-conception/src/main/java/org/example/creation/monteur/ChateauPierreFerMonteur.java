package org.example.creation.monteur;

// ChateauPierreFerMonteur.java
public class ChateauPierreFerMonteur implements Monteur {
    private Maison maison;

    public ChateauPierreFerMonteur() {
        this.maison = new Maison();
    }

    @Override
    public void construireMurs() {
        maison.setMurs("Murs en pierre");
    }

    @Override
    public void construirePortes() {
        maison.setPortes("Portes en fer");
    }

    @Override
    public void construireToit() {
        maison.setToit("Toit en pierre");
    }

    @Override
    public void construirePiscine() {
        maison.setPiscine("Piscine royale");
    }

    @Override
    public Maison getMaison() {
        return maison;
    }
}
