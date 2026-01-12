package org.example.creation.frabrique.paiements;

public interface MoyenPaiement {
    void valider(Paiement paiement);
    void executer(Paiement paiement);
    TypeMoyenPaiement getType();
}
