package org.example.creation.monteur.voiture;

// Builder.java
public interface Builder {
    void reset();
    void setSeats(int seats);
    void setEngine(String engine);
    void setTripComputer(boolean hasTripComputer);
    void setGPS(boolean hasGPS);
}

