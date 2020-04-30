package com.company;

import java.io.Serializable;

public class Vehicle implements Serializable {
//kan bli abstrakt klass

    static final long serialVersionUID = 2454700210759152155L;
    private String brand, regPlate; //kan göra till final
    private String color;
    private Person owner;
    private int year;
    private int weight;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    private Engine engine;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Vehicle(){}

    public Vehicle(String brand, String color, String regPlate, Person owner, int year, int weight) {
        this.brand = brand;
        this.color = color;
        this.owner = owner;
        this.year = year;
        this.weight = weight;
        this.regPlate = regPlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public String getColor() {
        return color;
    }

    public Person getOwner() {
        return owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setRegPlate(String regPlate) {
        this.regPlate = regPlate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Vehicle {" +
                "brand= " + getBrand() +
                ", regPlate= " + getRegPlate() +
                ", engine= " + String.valueOf(getEngine()) +
                ", color= " + getColor() +
                ", year= " + getYear() +
                ", weight= " + getWeight() +
                '}';
    }

    public boolean equals(Object ob) {
        if(this == ob) return true;

        if(!(ob instanceof Car)) return false;
        Car that = (Car)ob;
        return this.getRegPlate().equals(that.getRegPlate()) &&
                this.getWeight() == that.getWeight();
    }

}
