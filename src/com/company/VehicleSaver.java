package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VehicleSaver {

    static File cars = new File("C:\\Users\\Petros Tsavdaridis\\Documents\\cars.bin");
    static File trucks = new File("C:\\Users\\Petros Tsavdaridis\\Documents\\trucks.bin");


    public static void saveCars(HashMap<String, Car> c){
        try (ObjectOutputStream out1 =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(cars))))
        {
            out1.writeObject(VehicleCatalog.cars);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTrucks(HashMap<String, Truck> t){
        try (ObjectOutputStream out1 =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(trucks))))
        {
            out1.writeObject(VehicleCatalog.trucks);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void loadCars(File file){
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(cars)))){
            VehicleCatalog.cars = (HashMap<String, Car>) in.readObject();
            if (!VehicleCatalog.cars.isEmpty()) {
                System.out.println("Recovered cars:");
                System.out.println(VehicleCatalog.cars.values());
                System.out.println("---------------");
            }
            else System.out.println("There are no cars saved.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadTrucks(File file){
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(trucks)))){
            VehicleCatalog.trucks = (HashMap<String, Truck>) in.readObject();
            if (!VehicleCatalog.trucks.isEmpty()) {
                System.out.println("Recovered trucks:");
                System.out.println(VehicleCatalog.trucks.values());
                System.out.println("---------------");
            }
            else System.out.println("There are no trucks saved.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
