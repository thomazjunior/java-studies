package org.example.creation.monteur.voiture;

import lombok.Setter;

// Car.java
public class Car {
    @Setter
    private int seats;
    @Setter
    private String engine;
    @Setter
    private boolean tripComputer;
    @Setter
    private boolean gps;

    public void setGPS(boolean gps) { this.gps = gps; }

    @Override
    public String toString() {
        return "Car [seats=" + seats + ", engine=" + engine +
                ", tripComputer=" + tripComputer + ", gps=" + gps + "]";
    }
}