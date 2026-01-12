package org.example.creation.frabrique.courrier;

public class Camion implements Transport {
    @Override
    public void livrer() {
        System.out.println("Livraison par camion (courrier terrestre)");
    }
}
