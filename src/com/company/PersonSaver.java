package com.company;

import java.io.*;
import java.util.ArrayList;


public class PersonSaver {

    static File persons = new File("C:\\Users\\Petros Tsavdaridis\\Documents\\persons.bin");

    public static void save(ArrayList<Person> person){
        try (ObjectOutputStream out =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(persons)))){
            out.writeObject(PersonCatalog.people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(File file){
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(persons)))){
            PersonCatalog.people = (ArrayList<Person>) in.readObject();
            if(!PersonCatalog.people.isEmpty()) {
                System.out.println("Recovered list of people:");
                for (Person person : PersonCatalog.people) {
                    System.out.println(person);
                }
                System.out.println("---------------");
            } else System.out.println("There are no registered people saved.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
