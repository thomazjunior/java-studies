package org.example.creation.frabrique.logistics;

public class LogistiqueMer extends Logistique {
    @Override
    public Transport creerTransport() {
        return new Bateau();
    }
}
