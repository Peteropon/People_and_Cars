package com.company;

import java.io.Serializable;

public class Bensin extends Engine implements Serializable {

    static final long serialVersionUID = 2784781589783348482L;

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getDepositSize() {
        return depositSize;
    }

    public void setDepositSize(int depositSize) {
        this.depositSize = depositSize;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    private double fuelConsumption;
    private int gears, depositSize, enginePower;


    public Bensin() {
    }

    @Override
    public String toString() {
        return "Bensin";
    }
}
