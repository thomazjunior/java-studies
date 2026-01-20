package org.example.structurel.adapter;

public class SystemeBancaire {
    public static void main(String[] args) {
        // Service externe fourni par un partenaire
        ServicePaiementExterne servicePaiementExterne = new ServicePaiementExterne();

        // Adaptateur utilisé par la banque
        PaiementInterne paiementInterne = new AdaptateurPaiementExterne(servicePaiementExterne);

        // Le système bancaire ne connaît que l'interface interne
        paiementInterne.payer(250.75, "EUR");
    }
}
