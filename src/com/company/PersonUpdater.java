package com.company;

import java.util.Scanner;

public class PersonUpdater {


    public void updatePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the name of the person you want to update.");
        String input = sc.next();
        for (int i = 0; i < PersonCatalog.people.size(); i++) {
            if (input.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))) {
                Person p = PersonCatalog.people.get(i);
                System.out.println("Press 1 to change the town or 2 to change the vehicle.");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Type in the new town");
                    p.setCity(sc.next());
                    System.out.println("New town updated successfully.");
                } else if (choice == 2) {
                    updateVtoP(p);

                }break;
            }
        }
    }

    public void updateVtoP(Person p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the registration plate of the vehicle you want to delete.");
        String plate = sc.nextLine();
        if(VehicleCatalog.cars.get(plate) != null) {
            p.getOwnedVehicles().remove(VehicleCatalog.cars.get(plate));
            System.out.println("Vehicle deleted successfully.");
        } else {
            Vehicle v = VehicleCatalog.trucks.get(plate);
            p.getOwnedVehicles().remove(v);
            System.out.println("Vehicle deleted successfully.");
        }

        //delete a vehicle
        //create and assign
    }

}
