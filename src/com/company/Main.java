package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PersonSaver.load(PersonSaver.persons);
        VehicleSaver.loadCars(VehicleSaver.cars);
        VehicleSaver.loadTrucks(VehicleSaver.trucks);

        MenuOption.crudMenu();
        PersonSaver.save(PersonCatalog.people);
        VehicleSaver.saveCars(VehicleCatalog.cars);
        VehicleSaver.saveTrucks(VehicleCatalog.trucks);

//        Main main = new Main();
//        Scanner sc = new Scanner(System.in);
//        ArrayList<MenuOption2> am = new ArrayList<>();
//        am.add(new MenuOption2("one", ()-> System.out.println("Pressed one")));
//        am.add(new MenuOption2("two", main::two));
//        for (MenuOption2 mo: am  ) {
//            System.out.println(mo.title);
//        }
//        int val = sc.nextInt();
//        am.get(val-1).menuOptionInterface.method();
//        String userName = System.getProperty("user.name");
//        System.out.println("Creator: "+userName);






    }

    public void two(){

    }

}
