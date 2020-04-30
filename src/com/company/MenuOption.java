package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOption {






    public static void crudMenu() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                meny();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        createMeny();
                        create(sc.nextInt());
                        break;
                    case 2:
                        readMeny();
                        read(sc.nextInt());
                        break;
                    case 3:
                        updateMeny();
                        update(sc.nextInt());
                        break;
                    case 4:
                        deleteMeny();
                        delete(sc.nextInt());
                        break;
                    case 5:
                        saveInfo();
                        break;
                }
            }
            while (choice != 0);

        }catch (InputMismatchException e) {
            System.out.println("Invalid choice"); }

    }


    private static void deleteMeny() {
        System.out.println("Press 1 to delete a person. \nPress 2 to delete a car. \nPress 3 to delete a truck." +
                "\nPress 4 to delete all people. \nPress 5 to delete all cars. \nPress 6 to delete all trucks." +
                "\nPress 9 to go back to main menu.\r\n");
    }

    private static void updateMeny() {
        System.out.println("Press 1 to update a person. \nPress 2 to update a car. \nPress 3 to update a truck. \r\n");
    }

    private static void readMeny() {
        System.out.println("Press 1 to read a person. \nPress 2 to read a car. \nPress 3 to read a truck. \nPress 4 to view all people. " +
                "\nPress 5 to view all cars. \nPress 6 to view all trucks. \nPress any key to exit to main menu.\r\n");
    }

    private static void createMeny() {
        System.out.println("Press 1 to create a person. \nPress 2 to create a vehicle. " +
                "\nPress 3 to download vehicle info from the internet" +
                "\nPress any key to exit to main menu.\r\n");
    }

    public static void meny(){
        System.out.println("\n---------------\nWhat would you like to do? \n1. Create\n2. Read \n3. Update" +
                "\n4. Delete \n5. Save \n0. Exit Program");
    }

    public static void create(int i){
        if(i == 1) PersonCreator.addPerson();
        else if (i == 2) VehicleCreator.createVehicle();
        else if (i == 3) Http.print();
        else {
            meny();
        }
    }

    private static void update(int i) {
        VehicleUpdater vu = new VehicleUpdater();
        switch (i) {
            case 1: PersonUpdater pu = new PersonUpdater();
                pu.updatePerson();
                break;
            case 2:
                vu.updateCar();
                break;
            case 3:
                vu.updateTruck();
                break;
        }
    }

    private static void saveInfo() {
        PersonSaver.save(PersonCatalog.people);
        VehicleSaver.saveCars(VehicleCatalog.cars);
        VehicleSaver.saveTrucks(VehicleCatalog.trucks);
    }

    private static void delete(int i) {
        VehicleDeleter vd = new VehicleDeleter();
        PersonDeleter pd = new PersonDeleter();
        switch (i){
            case 1:
                pd.deletePerson();
                break;
            case 2:
                vd.deleteCar();
                break;
            case 3:
                vd.deleteTruck();
                break;
            case 4:
                pd.deleteAllPeople();
                break;
            case 5:
                vd.deleteAllCars();
                break;
            case 6:
                vd.deleteAllTrucks();
                break;
        }

    }

    public static void read(int i){
        Finder f = new Finder();
        switch (i) {
            case 1: f.findPerson();
            break;
            case 2: f.findCar();
            break;
            case 3: f.findTruck();
            break;
            case 4: if (PersonCatalog.people.isEmpty()) System.out.println("The people catalog is empty.");
            else {
                for (Person p : PersonCatalog.people
                ) {
                    System.out.println(p);
                }
            }
            break;
            case 5:
                if(!VehicleCatalog.cars.isEmpty())System.out.println(VehicleCatalog.cars.values());
                else {
                    System.out.println("The car catalog is empty.");
                }
                break;
            case 6:
                if (!VehicleCatalog.trucks.isEmpty()) System.out.println(VehicleCatalog.trucks.values());
                else {
                    System.out.println("The truck catalog is empty.");
                }
                break;
        }
    }
}
