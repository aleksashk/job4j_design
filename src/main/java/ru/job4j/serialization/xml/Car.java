package ru.job4j.serialization.xml;

public class Car {
    boolean isTruck;
    int numberOfPassengers;
    String Color;
    Engine engine;
    String[] bonuses;

    public Car(boolean isTruck, int numberOfPassengers, String color, Engine engine, String[] bonuses) {
        this.isTruck = isTruck;
        this.numberOfPassengers = numberOfPassengers;
        Color = color;
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
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
