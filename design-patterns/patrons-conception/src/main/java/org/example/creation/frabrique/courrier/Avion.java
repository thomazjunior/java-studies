package org.example.creation.frabrique.courrier;

public class Avion implements Transport {
    @Override
    public void livrer() {
        System.out.println("Livraison par avion (courrier aérien)");
    }
}
