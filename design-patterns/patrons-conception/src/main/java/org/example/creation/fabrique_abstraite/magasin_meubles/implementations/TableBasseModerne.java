package org.example.creation.fabrique_abstraite.magasin_meubles.implementations;

import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.TableBasse;

public class TableBasseModerne implements TableBasse {
    @Override
    public void poserObjet() {
        System.out.println("Objet posé sur une table basse moderne");
    }
}
