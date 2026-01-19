package org.example.creation.frabrique.courrier;

abstract class Courrier {
    // Méthode fabrique abstraite
    public abstract Transport creerTransport(String type);

    public void envoyer(String type) {
        Transport t = creerTransport(type);
        System.out.println("Préparation de l'envoi...");
        t.livrer();
    }
}
