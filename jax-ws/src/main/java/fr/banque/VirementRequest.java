package fr.banque;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlRootElement(name = "virementRequest")
@XmlType(propOrder = {"compteSource", "compteDestination", "montant", "description"})
public class VirementRequest {

    private String compteSource;
    private String compteDestination;
    private BigDecimal montant;
    private String description;

    // Constructeurs
    public VirementRequest() {
    }

    public VirementRequest(String compteSource, String compteDestination,
                           BigDecimal montant, String description) {
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
        this.montant = montant;
        this.description = description;
    }

    // Getters et Setters
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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}