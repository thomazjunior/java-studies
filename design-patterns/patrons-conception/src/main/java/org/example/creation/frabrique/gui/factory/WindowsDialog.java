package org.example.creation.frabrique.gui.factory;

import org.example.creation.frabrique.gui.buttons.Button;
import org.example.creation.frabrique.gui.buttons.HtmlButton;
import org.example.creation.frabrique.gui.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
