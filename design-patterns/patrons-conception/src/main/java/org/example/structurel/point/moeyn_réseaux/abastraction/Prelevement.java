package org.example.structurel.point.moeyn_réseaux.abastraction;

import org.example.structurel.point.moeyn_réseaux.implementation.ReseauBancaire;

public class Prelevement extends MoyenPaiement {

    public Prelevement(ReseauBancaire reseau) {
        super(reseau);
    }

    @Override
    public void effectuerPaiement(double montant, String devise) {
        System.out.print("Prélèvement automatique : ");
        reseau.transferer(montant, devise);
    }
}
