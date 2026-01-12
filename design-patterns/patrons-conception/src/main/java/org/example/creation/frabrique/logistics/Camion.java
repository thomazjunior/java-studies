package org.example.creation.frabrique.logistics;

public class Camion implements Transport {
    @Override
    public void livrer() {
        System.out.println("Livraison par camion sur la route");
    }
}
