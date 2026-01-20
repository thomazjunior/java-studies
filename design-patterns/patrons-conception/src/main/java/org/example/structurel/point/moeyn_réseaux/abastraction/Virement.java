package org.example.structurel.point.moeyn_réseaux.abastraction;

import org.example.structurel.point.moeyn_réseaux.implementation.ReseauBancaire;

public class Virement extends MoyenPaiement {

    public Virement(ReseauBancaire reseau) {
        super(reseau);
    }

    @Override
    public void effectuerPaiement(double montant, String devise) {
        System.out.print("Virement bancaire : ");
        reseau.transferer(montant, devise);
    }
}

