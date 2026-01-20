package org.example.structurel.point.moeyn_réseaux.implementation;

public class Sepa implements ReseauBancaire {
    @Override
    public void transferer(double montant, String devise) {
        System.out.println("Transfert SEPA de " + montant + " " + devise);
    }
}

