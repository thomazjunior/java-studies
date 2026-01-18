package org.example.creation.fabrique_abstraite.gui;

public class MacCheckBox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Affichage d'une case à coucher style macOS");
    }
}
