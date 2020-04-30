package com.company;

import java.util.Scanner;

public class VehicleDeleter {


    public void deleteCar() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Type in the registration plate of the car.\r\n");
            String regPlate = sc.next();
            if(VehicleCatalog.cars.containsKey(regPlate)) {
                Car c = VehicleCatalog.cars.get(regPlate);
                Person p = c.getOwner();
                p.getOwnedVehicles().remove(c);
                VehicleCatalog.cars.remove(regPlate);
                System.out.println("Car deleted successfully.");
            }
    }

    public void deleteTruck() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Type in the registration plate of the truck.\r\n");
            String regPlate = sc.next();
            if(VehicleCatalog.trucks.containsKey(regPlate)) {
                Truck t = VehicleCatalog.trucks.get(regPlate);
                Person p = t.getOwner();
                p.getOwnedVehicles().remove(t);
                VehicleCatalog.trucks.remove(regPlate);
                System.out.println("Truck deleted successfully.");
            }
    }

    public void deleteAllCars(){
        try {
            VehicleCatalog.cars.clear();
            Person p = null;
            for (int i = 0; i < PersonCatalog.people.size(); i++) {
                p.getOwnedVehicles().clear();
            }
            System.out.println("All cars deleted successfully.");
        } catch (NullPointerException n) {
            System.out.println("The list is probably empty already.");
        }

    }

    public void deleteAllTrucks(){
        try {
            VehicleCatalog.trucks.clear();
            Person p = null;
            for (int i = 0; i < PersonCatalog.people.size(); i++) {
                p.getOwnedVehicles().clear();
            }
            System.out.println("All trucks deleted successfully.");
        } catch (NullPointerException n){
            System.out.println("The list is probably empty already.");
        }
    }
}
