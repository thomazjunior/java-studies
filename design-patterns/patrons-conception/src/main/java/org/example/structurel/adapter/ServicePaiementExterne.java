package org.example.structurel.adapter;

// API d'un prestataire externe
public class ServicePaiementExterne {
    public void makePayment(int amountInCents, String currencyCode) {
        System.out.println(
                "Paiement externe effectué : " +
                        amountInCents + " cents en " + currencyCode
        );
    }
}
