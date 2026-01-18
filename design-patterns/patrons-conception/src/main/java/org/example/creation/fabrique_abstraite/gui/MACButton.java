package org.example.creation.fabrique_abstraite.gui;

public class MACButton implements Button{
    @Override
    public void paint() {
        System.out.println("Affichage d'un bouton style macOS");
    }
}
