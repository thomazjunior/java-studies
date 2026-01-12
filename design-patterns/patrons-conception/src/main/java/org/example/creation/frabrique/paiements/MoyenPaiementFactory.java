package org.example.creation.frabrique.paiements;

public class MoyenPaiementFactory {
    public static MoyenPaiement creer(TypeMoyenPaiement type){
        return switch (type) {
            case CARTE -> new PaiementCarte();
            case VIREMENT -> new PaiementVirement();
            case PRELEVEMENT -> new PaiementPrelevement();
        };
    }
}
