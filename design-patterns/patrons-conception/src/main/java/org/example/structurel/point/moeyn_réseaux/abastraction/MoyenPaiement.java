package org.example.structurel.point.moeyn_réseaux.abastraction;

import org.example.structurel.point.moeyn_réseaux.implementation.ReseauBancaire;

public abstract class MoyenPaiement {

    protected ReseauBancaire reseau; // ← LE PONT

    protected MoyenPaiement(ReseauBancaire reseau) {
        this.reseau = reseau;
    }

    public abstract void effectuerPaiement(double montant, String devise);
}
