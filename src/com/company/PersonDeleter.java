package com.company;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PersonDeleter {

    public void deletePerson(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Which person do you want to delete?");
        try {
            String input = sc.next();

//            Iterator<Person> it = PersonCatalog.people.iterator();
//            while (it.hasNext()){
//                Person p = it.next();
//                if (input.equalsIgnoreCase(p.getName()) && p.getOwnedVehicles().isEmpty()){
//                    it.remove();
//                    System.out.println("Deletion completed successfully."); break;
//                }

            //PersonCatalog.people.removeIf(p -> p.getName().equals(input));

            for (int i = 0; i < PersonCatalog.people.size(); i++) {
                if (input.equalsIgnoreCase(String.valueOf(PersonCatalog.people.get(i).getName()))) {
                    Person p = PersonCatalog.people.get(i);
                    if (p.getOwnedVehicles().isEmpty()) {
                        PersonCatalog.people.remove(p);
                        System.out.println("Deletion completed successfully.");
                    } else {
                        System.out.println("You can't delete this person. This person is owner of vehicles.");
                    }
                    break;
                }
            }
        }catch(NullPointerException | InputMismatchException n){
                System.out.println("We could not find this person. Make sure you spell the name correctly.");
            }

    }

    public void deleteAllPeople(){
        PersonCatalog.people.clear();
        System.out.println("All people deleted successfully.");
    }

}
