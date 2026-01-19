package org.example.creation.fabrique_abstraite.magasin_meubles;

import org.example.creation.fabrique_abstraite.magasin_meubles.implementations.FabriqueMeubleModerne;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.FabriqueMeuble;

public class Application {
    public static void main(String[] args) {

        // Choix de la fabrique selon la configuration
        FabriqueMeuble fabrique;
        String style = System.getProperty("style", "Moderne");

        fabrique = switch (style) {
            case "Victoriene" -> new FabriqueMeubleModerne();
            default -> new FabriqueMeubleModerne();
        };

        Client client = new Client(fabrique);
        client.utiliserMeubles();
    }
}
