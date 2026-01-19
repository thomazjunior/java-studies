package org.example.creation.fabrique_abstraite.gui;

public class ApplicationConfigurator {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")){
            factory = new WinFactory();
        } else if(os.contains("mac")){
            factory = new MACFactory();
        } else {
            throw new RuntimeException("Error! Uknown operting system");
        }

        Application app = new Application(factory);
        app.createUI();
        app.paint();
    }
}
