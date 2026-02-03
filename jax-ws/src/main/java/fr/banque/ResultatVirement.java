package fr.banque;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.Date;


@XmlRootElement(name = "resultatVirement")
public class ResultatVirement {

    private String reference;
    private String statut;
    private Date dateExecution;
    private BigDecimal montant;
    private String compteSource;
    private String compteDestination;

    // Constructeurs
    public ResultatVirement() {
        this.dateExecution = new Date();
    }

    public ResultatVirement(String reference, String statut, BigDecimal montant,
                            String compteSource, String compteDestination) {
        this();
        this.reference = reference;
        this.statut = statut;
        this.montant = montant;
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }

    // Getters et Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(Date dateExecution) {
        this.dateExecution = dateExecution;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(String compteSource) {
        this.compteSource = compteSource;
    }

    public String getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(String compteDestination) {
        this.compteDestination = compteDestination;
    }
}