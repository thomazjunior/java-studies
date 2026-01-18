package org.example.creation.fabrique_abstraite.gui;

public class MACFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MACButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new MacCheckBox();
    }
}
