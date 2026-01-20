package org.example.structurel.point.forme_couleur;

public abstract class Forme {

    protected Couleur couleur; // ← le PONT

    protected Forme(Couleur couleur) {
        this.couleur = couleur;
    }

    public abstract void dessiner();
}
