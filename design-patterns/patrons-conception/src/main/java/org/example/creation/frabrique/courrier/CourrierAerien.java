package org.example.creation.frabrique.courrier;

public class CourrierAerien extends Courrier {
    @Override
    public Transport creerTransport(String type) {
        // Pour le courrier aérien, on utilise toujours Avion
        return new Avion();
    }
}
