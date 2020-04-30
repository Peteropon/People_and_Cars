package com.company;

import java.util.*;

public class PersonCreator {

    static Person person;

    public static Person addPerson(){
        Scanner sc = new Scanner(System.in);
        person = new Person();
        System.out.println("You are now registering a new person. \nPlease type in the person's name.");
        person.setName(getName());
        System.out.println("Please type in the person's age");
        person.setAge(getAge());
        System.out.println("Now please type in the town.");
        person.setCity(sc.next());
        PersonCatalog.people.add(person);
        PersonSaver.save(PersonCatalog.people);
        return person;
    }

    public static String getName() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if( s.matches("[A-Za-z]*") )
            return s;
        else {
            System.out.println("Invalid name. Please try again.");
            getName();
        }
        return s;
    }

    public static int getAge() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        if( s >= 18 )
            return s;
        else {
            System.out.println("Invalid age. Please try again.");
            getAge();
        }
        return s;
    }

}
