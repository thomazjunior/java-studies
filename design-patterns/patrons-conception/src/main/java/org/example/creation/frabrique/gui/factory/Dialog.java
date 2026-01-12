package org.example.creation.frabrique.gui.factory;

import org.example.creation.frabrique.gui.buttons.Button;

public abstract class Dialog {
    public void renderWindow() {

        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
