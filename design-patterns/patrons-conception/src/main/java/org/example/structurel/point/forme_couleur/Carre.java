package org.example.structurel.point.forme_couleur;

public class Carre extends Forme {

    public Carre(Couleur couleur) {
        super(couleur);
    }

    @Override
    public void dessiner() {
        System.out.print("Carré dessiné en ");
        couleur.appliquerCouleur();
    }
}
