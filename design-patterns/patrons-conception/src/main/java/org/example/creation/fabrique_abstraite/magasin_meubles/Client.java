package org.example.creation.fabrique_abstraite.magasin_meubles;

import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Chaise;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.FabriqueMeuble;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.Sofa;
import org.example.creation.fabrique_abstraite.magasin_meubles.interfaces.TableBasse;

public class Client {
    private final Chaise chaise;
    private final Sofa sofa;
    private final TableBasse tableBasse;

    public Client(FabriqueMeuble fabrique){
        this.chaise = fabrique.creerChaise();
        this.sofa = fabrique.creerSofa();
        this.tableBasse = fabrique.creerTableBasse();
    }

    public void utiliserMeubles(){
        chaise.sasseoir();
        sofa.sAllonger();
        tableBasse.poserObjet();
    }
}
