package com.company;

import java.util.ArrayList;

public class PersonCatalog {

    static ArrayList<Person> people = new ArrayList<>();

    public static ArrayList<Person> personCatalog(Person person){
        people.add(person);
        return people;
    }


    public static void printPersonCatalog(ArrayList<Person> l){
        for (Person person: l) {
            System.out.println(person);
        }
    }

}
