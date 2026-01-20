package org.example.structurel.point.moeyn_réseaux;

import org.example.structurel.point.moeyn_réseaux.abastraction.MoyenPaiement;
import org.example.structurel.point.moeyn_réseaux.abastraction.PaiementCarte;
import org.example.structurel.point.moeyn_réseaux.abastraction.Prelevement;
import org.example.structurel.point.moeyn_réseaux.abastraction.Virement;
import org.example.structurel.point.moeyn_réseaux.implementation.ReseauInterne;
import org.example.structurel.point.moeyn_réseaux.implementation.Sepa;
import org.example.structurel.point.moeyn_réseaux.implementation.Swift;

public class CoreBankingSystem {

    public static void main(String[] args) {

        MoyenPaiement virementSepa =
                new Virement(new Sepa());

        MoyenPaiement carteSwift =
                new PaiementCarte(new Swift());

        MoyenPaiement prelevementInterne =
                new Prelevement(new ReseauInterne());

        virementSepa.effectuerPaiement(1000, "EUR");
        carteSwift.effectuerPaiement(250, "USD");
        prelevementInterne.effectuerPaiement(500, "EUR");
    }
}
