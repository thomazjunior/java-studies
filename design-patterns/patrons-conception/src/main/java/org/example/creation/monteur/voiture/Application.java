package org.example.creation.monteur.voiture;

// Application.java
public class Application {
    public static void main(String[] args) {
        Director director = new Director();

        // Construire une voiture sportive
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println(car);

        // Construire le manuel de la voiture sportive
        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.println(manual);

        // Construire un SUV et son manuel
        director.constructSUV(carBuilder);
        Car suv = carBuilder.getProduct();
        System.out.println(suv);

        director.constructSUV(manualBuilder);
        Manual suvManual = manualBuilder.getProduct();
        System.out.println(suvManual);
    }
}
