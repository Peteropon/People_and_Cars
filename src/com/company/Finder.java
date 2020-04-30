package com.company;

import java.util.Scanner;

public class Finder {

    public void findPerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the name of the person you are looking for");
        String input = sc.next();
        for (int i = 0; i < PersonCatalog.people.size(); i++) {
            if (input.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))){
                System.out.println(PersonCatalog.people.get(i).toString() + "\r\n");
            }
        }

//        for (Person p: PersonCatalog.people) {
//            if(input.equals(p.getName()))
//                return p;
//        }
//        return null;
//        PersonCatalog.people.stream().filter()
    }

    public void findCar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the registration plate of the car you are looking for");
        String input = sc.next();
        if(VehicleCatalog.cars.containsKey(input)){
            System.out.println(VehicleCatalog.cars.get(input) + "\r\n");
        } else {
            System.out.println("We can't find this vehicle.");
        }
    }

    public void findTruck(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the registration plate of the truck you are looking for");
        String input = sc.next();
        if(VehicleCatalog.trucks.containsKey(input)){
            System.out.println(VehicleCatalog.trucks.get(input) + "\r\n");
        } else {
            System.out.println("We can't find this vehicle.");
        }
    }

}
