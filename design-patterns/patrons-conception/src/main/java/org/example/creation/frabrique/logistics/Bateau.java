package org.example.creation.frabrique.logistics;

public class Bateau implements Transport {
    @Override
    public void livrer() {
        System.out.println("Livraison par bateau sur la mer");
    }
}
