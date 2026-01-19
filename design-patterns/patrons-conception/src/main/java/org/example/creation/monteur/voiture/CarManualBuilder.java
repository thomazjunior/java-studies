package org.example.creation.monteur.voiture;

// CarManualBuilder.java
public class CarManualBuilder implements Builder {
    private Manual manual;

    public CarManualBuilder() { reset(); }

    @Override
    public void reset() { manual = new Manual(); }

    @Override
    public void setSeats(int seats) {
        manual.setSeatsInfo("This car has " + seats + " seats.");
    }

    @Override
    public void setEngine(String engine) {
        manual.setEngineInfo("Engine type: " + engine);
    }

    @Override
    public void setTripComputer(boolean hasTripComputer) {
        manual.setTripComputerInfo("Trip computer: " + (hasTripComputer ? "available" : "not available"));
    }

    @Override
    public void setGPS(boolean hasGPS) {
        manual.setGPSInfo("GPS: " + (hasGPS ? "available" : "not available"));
    }

    public Manual getProduct() {
        Manual product = manual;
        reset();
        return product;
    }
}
