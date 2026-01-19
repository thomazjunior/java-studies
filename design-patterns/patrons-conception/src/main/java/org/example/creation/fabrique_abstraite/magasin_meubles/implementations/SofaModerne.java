package org.example.creation.fabrique_abstraite.magasin_meubles.implementations;

import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Sofa;

public class SofaModerne implements Sofa {
    @Override
    public void sAllonger() {
        System.out.println("Vous êtes allongé sur un sofa moderne");
    }
}
