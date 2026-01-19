package org.example.creation.monteur.voiture;

import lombok.Setter;

// Manual.java
public class Manual {
    @Setter
    private String seatsInfo;
    @Setter
    private String engineInfo;
    @Setter
    private String tripComputerInfo;
    private String gpsInfo;

    public void setGPSInfo(String gpsInfo) { this.gpsInfo = gpsInfo; }

    @Override
    public String toString() {
        return "Manual [seatsInfo=" + seatsInfo + ", engineInfo=" + engineInfo +
                ", tripComputerInfo=" + tripComputerInfo + ", gpsInfo=" + gpsInfo + "]";
    }
}