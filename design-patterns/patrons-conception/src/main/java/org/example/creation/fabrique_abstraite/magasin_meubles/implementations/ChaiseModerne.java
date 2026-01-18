package org.example.creation.fabrique_abstraite.magasin_meubles.implementations;

import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Chaise;

public class ChaiseModerne implements Chaise {
    @Override
    public void sasseoir() {
        System.out.println("Vous êtes assis sur une chaise moderne.");
    }
}
