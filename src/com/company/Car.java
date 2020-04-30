package com.company;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    public Car(String brand, String color, String regPlate, Person owner, int year, int weight) {
        super(brand, color, regPlate, owner, year, weight);
    }

    static final long serialVersionUID = 5393183503920278673L;

    @Override
    public String toString() {
        return "Car {" +
                "brand= " + getBrand() +
                ", regPlate= " + getRegPlate() +
                ", engine= " + String.valueOf(getEngine()) +
                ", color= " + getColor() +
                ", year= " + getYear() +
                ", weight= " + getWeight() +
                '}';
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    int passengers;

    public Car() {

    }

}
