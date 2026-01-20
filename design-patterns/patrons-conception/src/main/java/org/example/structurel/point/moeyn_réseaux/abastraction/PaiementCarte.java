package org.example.structurel.point.moeyn_réseaux.abastraction;

import org.example.structurel.point.moeyn_réseaux.implementation.ReseauBancaire;

public class PaiementCarte extends MoyenPaiement {

    public PaiementCarte(ReseauBancaire reseau) {
        super(reseau);
    }

    @Override
    public void effectuerPaiement(double montant, String devise) {
        System.out.print("Paiement par carte : ");
        reseau.transferer(montant, devise);
    }
}
