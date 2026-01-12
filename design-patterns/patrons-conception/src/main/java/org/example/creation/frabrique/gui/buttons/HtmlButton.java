package org.example.creation.frabrique.gui.buttons;

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Teste button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
