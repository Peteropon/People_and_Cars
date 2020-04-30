package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleCreator {
    private static Vehicle car, truck;
    VehicleCatalog vehicleCatalog = new VehicleCatalog();

    public static void createVehicle() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of vehicle do you want to create? Press 1 for car and 2 for truck.");
        int choice = sc.nextInt();
        if (choice == 1) {
            Car c = addNewCar();
            VehicleCatalog.addInCarCatalog(c);
            assignOwnerToCar(c);

            VehicleSaver.saveCars(VehicleCatalog.cars);

        }
        else if (choice == 2){
            Truck t = addNewTruck();
            VehicleCatalog.addInTruckCatalog(t);
            assignOwnerToTruck(t);
            VehicleSaver.saveTrucks(VehicleCatalog.trucks);
        }
        else {
            System.out.println("Invalid choice. Please type 1 or 2.");
            createVehicle();
        }

    }


    public static Truck addNewTruck(){
        Truck t = new Truck();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the brand.");
        t.setBrand(getBrand());
        System.out.println("Type in the color.");
        t.setColor(sc.next());
        System.out.println("Type in the registration plate.");
        t.setRegPlate(getRegNumber());
        assignEngine(t);
        System.out.println("Type in the year.");
        t.setYear(getYear());
        System.out.println("Type in the load capacity.");
        t.setLoadCapacity(sc.nextInt());
        System.out.println("Type in the weight.");
        t.setWeight(sc.nextInt());
        showInfo(t);
        return t;
    }

    public static Car addNewCar(){
        Car c = new Car();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the brand.");
        c.setBrand(getBrand());
        System.out.println("Type in the color.");
        c.setColor(sc.next());
        System.out.println("Type in the registration plate.");
        c.setRegPlate(getRegNumber());
        assignEngine(c);
        System.out.println("Type in the number of passengers.");
        c.setPassengers(sc.nextInt());
        System.out.println("Type in the year.");
        c.setYear(getYear());
        System.out.println("Type in the weight.");
        c.setWeight(sc.nextInt());

        showInfo(c);
        return c;
    }

    public static void assignOwnerToCar(Car c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("If you want to assign an existing person as the owner press 1. " +
                "If you want to create a new person press 2.");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Type the person's name.");
            String input = sc.next();

            for (int i = 0; i < PersonCatalog.people.size(); i++) {
                if (input.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))) {
                    c.setOwner(PersonCatalog.people.get(i));
                    PersonCatalog.people.get(i).setOwnedVehicles(c);
                    System.out.println("Owner assigned to car successfully.");
                }
            }

        } else if (answer == 2) {
            Person p = PersonCreator.addPerson();
            c.setOwner(p);
            p.setOwnedVehicles(c);
            System.out.println("Owner assigned to car successfully.");
        }
    }

    public static void assignOwnerToTruck(Truck t){
        Scanner sc = new Scanner(System.in);
        System.out.println("If you want to assign an existing person as the owner press 1. " +
                "If you want to create a new person press 2.");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Type the person's name.");
            String input = sc.next();
            for (int i = 0; i < PersonCatalog.people.size(); i++) {
                if (input.equalsIgnoreCase(PersonCatalog.people.get(i).getName())) {
                    Person p = PersonCatalog.people.get(i);
                    t.setOwner(p);
                    p.setOwnedVehicles(t);
                    System.out.println("Owner assigned to truck successfully.");
                }
            }

        } else if (answer == 2) {
            Person p = PersonCreator.addPerson();
            t.setOwner(p);
            p.setOwnedVehicles(t);
            System.out.println("Owner assigned to truck successfully.");
        }
    }

    public static String getBrand() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if( s.matches("[A-Za-z]*") )
            return s;
        else {
            System.out.println("Invalid brand name. Please try again.");
            getBrand();
        }
        return s;
    }


    public static String getRegNumber() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if( s.length() > 0 && s.matches("[A-Za-z]{3}\\s*[0-9]{2}[A-Za-z0-9]") )
            return s;
        else {
            System.out.println("Invalid reg. plate. Please try again.");
            getRegNumber();
        }
        return s;
    }

    public static int getYear(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        if( s > 1900 && s <= 2018 )
            return s;
        else {
            System.out.println("Invalid year. Please try again.");
            getYear();
        }
        return s;
    }

    public static void assignEngine(Vehicle v){
        System.out.println("What type of engine? \nPress '1' for Bensin \nPress '2' for Diesel \nPress '3' for Electric");
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        if(in == 1) {
            v.setEngine(new Bensin());
        } else if (in == 2){
            v.setEngine(new Diesel());
        } else {
            v.setEngine(new El());
        }
    }

    public static void showInfo(Vehicle v){
        System.out.println(v.toString()+ "\r\n");
    }

}
