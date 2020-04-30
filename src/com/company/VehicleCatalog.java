package com.company;

import java.util.HashMap;

public class VehicleCatalog {

    Vehicle car, truck;
    String regPlate;
    static HashMap<String, Car> cars = new HashMap<>();
    static HashMap<String, Truck> trucks = new HashMap<>();




    public static void addInCarCatalog(Car car){
        cars.put(car.getRegPlate(), car);
    }

    public static void addInTruckCatalog(Truck truck){
        trucks.put(truck.getRegPlate(), truck);
    }

    public static void printCatalog(HashMap<String, ? extends Vehicle> h){
        for (Vehicle vehicle: h.values()
             ) {
            System.out.println(vehicle);
        }
    }


}
