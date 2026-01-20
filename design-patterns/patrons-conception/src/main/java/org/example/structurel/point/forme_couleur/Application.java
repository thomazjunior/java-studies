package org.example.structurel.point.forme_couleur;

public class Application {

    public static void main(String[] args) {

        Forme cercleRouge = new Cercle(new Rouge());
        Forme carreBleu = new Carre(new Bleu());


        cercleRouge.dessiner();
        carreBleu.dessiner();

    }
}
