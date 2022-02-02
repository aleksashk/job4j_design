package ru.job4j.serialization.xml;

public class Car {
    boolean isTruck;
    int numberOfPassengers;
    String color;
    Engine engine;
    String[] bonuses;

    public Car(boolean isTruck, int numberOfPassengers, String color, Engine engine, String[] bonuses) {
        this.isTruck = isTruck;
        this.numberOfPassengers = numberOfPassengers;
        this.color = color;
        this.engine = engine;
        this.bonuses = bonuses;
    }

    public boolean isTruck() {
        return isTruck;
    }

    public void setTruck(boolean truck) {
        isTruck = truck;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
