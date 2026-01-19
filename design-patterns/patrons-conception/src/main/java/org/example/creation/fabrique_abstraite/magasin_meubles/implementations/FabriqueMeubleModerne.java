package org.example.creation.fabrique_abstraite.magasin_meubles.implementations;

import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Chaise;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.FabriqueMeuble;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Sofa;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.TableBasse;

public class FabriqueMeubleModerne implements FabriqueMeuble {
    @Override
    public Chaise creerChaise() {
        return new ChaiseModerne();
    }

    @Override
    public Sofa creerSofa() {
        return new SofaModerne();
    }

    @Override
    public TableBasse creerTableBasse() {
        return new TableBasseModerne();
    }
}
