package org.example.creation.fabrique_abstraite.gui;

public class WinCheckBox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Affichage d'une case à cocher style Windows");
    }
}
