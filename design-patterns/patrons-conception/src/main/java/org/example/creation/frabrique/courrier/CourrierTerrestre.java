package org.example.creation.frabrique.courrier;

public class CourrierTerrestre extends Courrier {
    @Override
    public Transport creerTransport(String type) {
        // Pour le courrier terrestre, on peut choisir Camion ou Train
        return switch (type) {
            case "CAMION" -> new Camion();
            case "TRAIN" -> new Train();
            default -> throw new IllegalArgumentException("Type de transport terrestre inconny");
        };
    }
}
