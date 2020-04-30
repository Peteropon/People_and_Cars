package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    static final long serialVersionUID = 4596823035029707222L;
    private String name, city;
    private int age;
    private ArrayList<Vehicle> ownedVehicles = new ArrayList<>();

    public ArrayList<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }


    public void setOwnedVehicles(Vehicle c) {
        ownedVehicles.add(c);
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) this.age = age;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name: " + name +
                ", city: " + city +
                ", age: " + age + ", vehicles owned: " + ownedVehicles +
                '}';
    }
}
