package com.company;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {
    public Truck(String brand, String color, String regPlate, Person owner, int year, int weight) {
        super(brand, color, regPlate, owner, year, weight);
    }

    @Override
    public String toString() {
        return "Truck {" +
                "brand= " + getBrand()  +
                ", regPlate= " + getRegPlate() +
                ", engine= " + String.valueOf(getEngine()) +
                ", color= " + getColor() +
                ", year= " + getYear() +
                ", load capacity= " + getLoadCapacity() +
                ", weight= " + getWeight() +
                '}';
    }

    static final long serialVersionUID = 8496596763703440427L;

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    int loadCapacity;

    public Truck() {

    }

}
