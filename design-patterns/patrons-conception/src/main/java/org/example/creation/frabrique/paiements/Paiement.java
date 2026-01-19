package org.example.creation.frabrique.paiements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Paiement {
    private String id;
    private BigDecimal montant;
    private String devise;
    private LocalDate datePaiement;
    private StatutPaiement statut = StatutPaiement.CREE;

    public Paiement(String s, BigDecimal bigDecimal, String usd) {
        this.id = s;
        this.montant = bigDecimal;
        this.devise = usd;
        this.datePaiement = LocalDate.now();
    }

    public void valider() {
        if (!statut.equals(StatutPaiement.CREE) && !statut.equals(StatutPaiement.EN_ATTENTE)) {
            throw new IllegalStateException("Paiement non validable");
        }
        this.statut = StatutPaiement.VALIDE;
    }
}
