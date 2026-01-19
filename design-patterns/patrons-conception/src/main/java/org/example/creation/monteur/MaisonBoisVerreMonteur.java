package org.example.creation.monteur;

// MaisonBoisVerreMonteur.java
public class MaisonBoisVerreMonteur implements Monteur {
    private Maison maison;

    public MaisonBoisVerreMonteur() {
        this.maison = new Maison();
    }

    @Override
    public void construireMurs() {
        maison.setMurs("Murs en bois");
    }

    @Override
    public void construirePortes() {
        maison.setPortes("Portes en verre");
    }

    @Override
    public void construireToit() {
        maison.setToit("Toit en bois");
    }

    @Override
    public void construirePiscine() {
        maison.setPiscine("Piscine standard");
    }

    @Override
    public Maison getMaison() {
        return maison;
    }
}
