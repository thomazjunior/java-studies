package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.BitSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {

    // private por protrège nos données (encapsultion)
    private String id;
    private BigDecimal montant;
    private String devise;
    private LocalDate datePaiement;
    private StatutPaiement statut;

    public void setMontant(BigDecimal montant) {

        if (montant == null) {
            throw new IllegalArgumentException("Le montant ne peut pas être null");
        }

        if (montant.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le montant doit être strictement positif");
        }

        this.montant = montant;
    }


    void valider() {

        if (!statut.equals(StatutPaiement.CREE) && !statut.equals(StatutPaiement.EN_ATTENTE)) {
            throw new IllegalStateException("Paiement non validable");
        }

        this.statut = StatutPaiement.VALIDE;
    }

}