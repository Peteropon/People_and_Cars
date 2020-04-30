package com.company;

import java.io.Serializable;

public class El extends Engine implements Serializable {

    static final long serialVersionUID = -8020213160952186359L;

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    private double consumption;
    private int batterySize, enginePower;


    public El() {
    }

    @Override
    public String toString() {
        return "Electric";
    }
}
