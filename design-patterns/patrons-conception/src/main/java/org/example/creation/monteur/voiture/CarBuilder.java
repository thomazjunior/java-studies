package org.example.creation.monteur.voiture;

// CarBuilder.java
public class CarBuilder implements Builder {
    private Car car;

    public CarBuilder() { reset(); }

    @Override
    public void reset() { car = new Car(); }

    @Override
    public void setSeats(int seats) { car.setSeats(seats); }

    @Override
    public void setEngine(String engine) { car.setEngine(engine); }

    @Override
    public void setTripComputer(boolean hasTripComputer) { car.setTripComputer(hasTripComputer); }

    @Override
    public void setGPS(boolean hasGPS) { car.setGPS(hasGPS); }

    public Car getProduct() {
        Car product = car;
        reset();
        return product;
    }
}
