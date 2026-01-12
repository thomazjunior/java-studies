package org.example.creation.frabrique.courrier;

public class TestFactoryMethodCourrier {
    public static void main(String[] args) {
        Courrier courrierAerien = new CourrierAerien();
        courrierAerien.envoyer("");

        Courrier courrierTerrestre = new CourrierTerrestre();
        courrierTerrestre.envoyer("CAMION");
        courrierTerrestre.envoyer("TRAIN");
    }
}
