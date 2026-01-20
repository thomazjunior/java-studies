package org.example.structurel.point.moeyn_réseaux.implementation;

public class ReseauInterne implements ReseauBancaire {
    @Override
    public void transferer(double montant, String devise) {
        System.out.println("Transfert interne banque de " + montant + " " + devise);
    }
}
