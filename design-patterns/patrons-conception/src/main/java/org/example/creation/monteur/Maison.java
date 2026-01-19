package org.example.creation.monteur;

// Maison.java
public class Maison {
    private String murs;
    private String portes;
    private String toit;
    private String piscine;

    public void setMurs(String murs) {
        this.murs = murs;
    }

    public void setPortes(String portes) {
        this.portes = portes;
    }

    public void setToit(String toit) {
        this.toit = toit;
    }

    public void setPiscine(String piscine) {
        this.piscine = piscine;
    }

    @Override
    public String toString() {
        return "Maison [Murs=" + murs + ", Portes=" + portes + ", Toit=" + toit + ", Piscine=" + piscine + "]";
    }
}
