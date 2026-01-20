package org.example.structurel.adapter;

public class AdaptateurPaiementExterne implements PaiementInterne {
    private ServicePaiementExterne servicePaiementExterne;

    public AdaptateurPaiementExterne (ServicePaiementExterne servicePaiementExterne) {
        this.servicePaiementExterne = servicePaiementExterne;
    }

    @Override
    public void payer(double montant, String devise) {
        // Conversion euros -> centimes
        int montantEnCentimes = (int) Math.round(montant * 100);

        // Délégation au service externe
        servicePaiementExterne.makePayment(montantEnCentimes, devise);
    }
}
