package org.example.structurel.point.forme_couleur;

public class Cercle extends Forme {

    public Cercle(Couleur couleur) {
        super(couleur);
    }

    @Override
    public void dessiner() {
        System.out.print("Cercle dessiné en ");
        couleur.appliquerCouleur();
    }
}
