package org.example.creation.frabrique.courrier;

public class Train implements Transport {
    @Override
    public void livrer() {
        System.out.println("Livraison par train (courrier terrestre)");
    }
}
