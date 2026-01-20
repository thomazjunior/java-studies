package org.example.structurel.point.moeyn_réseaux.implementation;

public class Swift implements ReseauBancaire {
    @Override
    public void transferer(double montant, String devise) {
        System.out.println("Transfert SWIFT international de " + montant + " " + devise);
    }
}
