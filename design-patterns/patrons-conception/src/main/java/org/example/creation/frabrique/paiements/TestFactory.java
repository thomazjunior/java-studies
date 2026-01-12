package org.example.creation.frabrique.paiements;

import java.math.BigDecimal;

public class TestFactory {
    public static void main(String[] args) {
        Paiement paiement1 = new Paiement("PAY-001", new BigDecimal("1500"), "EUR");
        Paiement paiement2 = new Paiement("PAY-002", new BigDecimal("2500"), "USD");

        MoyenPaiement moyen1 = MoyenPaiementFactory.creer(TypeMoyenPaiement.CARTE);
        MoyenPaiement moyen2 = MoyenPaiementFactory.creer(TypeMoyenPaiement.VIREMENT);

        moyen1.valider(paiement1);
        moyen1.executer(paiement1);

        moyen2.valider(paiement2);
        moyen2.executer(paiement2);

        System.out.println("Paiement1 statut: " + paiement1.getId() + " -> VALIDE et TRANSMIS");
        System.out.println("Paiement2 statut: " + paiement2.getId() + " -> VALIDE et TRANSMIS");

    }
}
