package org.example.creation.frabrique.logistics;

// Créateur
public abstract class Logistique {
    // Méthode frabique
    public abstract Transport creerTransport();

    // Méthode avec fonctionnement propre
    public void planifierLivraison() {
        Transport t = creerTransport(); // création via la fabrique
        System.out.println("Planification de la livraison...");
        t.livrer(); // exécution du produit
    }
}
