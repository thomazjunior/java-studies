package poo.abstraction;

interface Serviceable {
    void service();
}

// ServiceStation.java
public class ServiceStation {
    public void performService(Serviceable item) {
        System.out.println("Starting service...");
        item.service();
        System.out.println("Service complete.");
    }
}