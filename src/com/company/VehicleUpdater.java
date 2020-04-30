package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleUpdater {


    public void updateCar() throws InputMismatchException, NullPointerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the reg plate of the car you want to update. \r\n");
        String regplate = sc.next();
        if (VehicleCatalog.cars.containsKey(regplate)) {
            Car c = VehicleCatalog.cars.get(regplate);
            System.out.println("Press 1 to change the colour. \n2 to change the owner. \n3 to change the weight." +
                    " \n4 to change the engine type. \r\n");
            int nextChoice = sc.nextInt();
            switch (nextChoice){
                case 1:
                    System.out.println("Type in the new colour");
                    c.setColor(sc.next());
                    System.out.println("New color updated successfully.");
                    break;
                case 2:
                    System.out.println("Type in the new owner");
                    for (int i = 0; i < PersonCatalog.people.size(); i++) {
                        String name = sc.nextLine();
                        if (name.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))) {
                            Person newP = PersonCatalog.people.get(i);
                            Person oldP = c.getOwner();
                            oldP.getOwnedVehicles().remove(c);
                            c.setOwner(newP);
                            newP.setOwnedVehicles(c);
                            System.out.println("New owner updated successfully.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Type in the new weight");
                    c.setWeight(sc.nextInt());
                    System.out.println("New weight updated successfully.");
                    break;
                case 4:
                    System.out.println("Select a new type of engine: \nPress 1 for Bensin. \nPress 2 for Diesel. \nPress 3 for Electric.");
                    int choice = sc.nextInt();
                    if (choice == 1){
                        c.setEngine(new Bensin());
                    }else if (choice ==2) {
                        c.setEngine(new Diesel());
                    } else if (choice == 3) {
                        c.setEngine(new El());
                    }
                    System.out.println("Engine updated successfully.");
                    break;
            }

        } else {
            System.out.println("This vehicle doesn't exist.");
        }

    }

    public void updateTruck() throws InputMismatchException, NullPointerException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the reg plate of the truck you want to update.\r\n");
        String regplate = sc.next();
        if (VehicleCatalog.trucks.containsKey(regplate)) {
            Truck v =  VehicleCatalog.trucks.get(regplate);
            System.out.println("Press 1 to change the colour. \n2 to change the owner." +
                    " \n3 to change the weight. \n4 to change the load capacity. \n5 to change the engine type.\r\n");
            int nextChoice = sc.nextInt();
            switch (nextChoice) {
                case 1:
                    System.out.println("Type in the new colour");
                    v.setColor(sc.next());
                    System.out.println("New color updated successfully.");
                    break;
                case 2:
                    System.out.println("Type in the new owner");
                    for (int i = 0; i < PersonCatalog.people.size(); i++) {
                        String name = sc.next();
                        if (name.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))) {
                            Person newP = PersonCatalog.people.get(i);
                            Person oldP = v.getOwner();
                            oldP.getOwnedVehicles().remove(v);
                            v.setOwner(newP);
                            newP.setOwnedVehicles(v);
                            System.out.println("New owner updated successfully.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Type in the new weight");
                    v.setWeight(sc.nextInt());
                    System.out.println("New weight updated successfully.");
                    break;
                case 4:
                    System.out.println("Type in the new load capacity");
                    v.setLoadCapacity(sc.nextInt());
                    System.out.println("New load capacity updated successfully.");
                    break;
                case 5:
                    System.out.println("Select a new type of engine: \nPress 1 for Bensin. \nPress 2 for Diesel. \nPress 3 for Electric.");
                    int choice = sc.nextInt();
                    if (choice == 1){
                        v.setEngine(new Bensin());
                    }else if (choice ==2) {
                        v.setEngine(new Diesel());
                    } else if (choice == 3) {
                        v.setEngine(new El());
                    }
                    System.out.println("Engine updated successfully.");
                    break;
            }


        }else {
            System.out.println("Truck not found.");
        }

    }
}
