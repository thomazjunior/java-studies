package org.example.creation.fabrique_abstraite.gui;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Affichage d'un bouton style Windows");
    }
}
