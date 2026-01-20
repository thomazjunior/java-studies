package org.example.structurel.adapter;

// Interface utilisée par le système bancaire interne
public interface PaiementInterne {
    void payer(double montant, String devise);
}
