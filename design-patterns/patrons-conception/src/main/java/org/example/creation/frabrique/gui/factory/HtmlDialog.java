package org.example.creation.frabrique.gui.factory;

import org.example.creation.frabrique.gui.buttons.Button;
import org.example.creation.frabrique.gui.buttons.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
