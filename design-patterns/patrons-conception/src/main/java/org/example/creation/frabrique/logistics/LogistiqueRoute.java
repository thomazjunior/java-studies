package org.example.creation.frabrique.logistics;

public class LogistiqueRoute extends Logistique {
    @Override
    public Transport creerTransport() {
        return new Camion();
    }
}
