package org.example.creation.frabrique.paiements;

public class PaiementVirement implements MoyenPaiement {
    @Override
    public void valider(Paiement paiement) {
        paiement.valider();
    }

    @Override
    public void executer(Paiement paiement) {
        paiement.setStatut(StatutPaiement.TRANSMIS);
    }

    @Override
    public TypeMoyenPaiement getType() {
        return TypeMoyenPaiement.PRELEVEMENT;
    }
}
