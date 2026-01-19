package org.example.creation.frabrique.logistics;

public class TestFactoryMethod {
    public static void main(String[] args) {

        Logistique logistiqueRoute = new LogistiqueRoute();
        logistiqueRoute.planifierLivraison();

        System.out.println();

        Logistique logistiqueMer = new LogistiqueMer();
        logistiqueMer.planifierLivraison();
    }
}
