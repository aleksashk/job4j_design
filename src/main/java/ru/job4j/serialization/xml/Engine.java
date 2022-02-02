package ru.job4j.serialization.xml;

public class Engine {
    String name;
    double volume;
    String typeOfOil;

    public Engine(String name, double volume, String typeOfOil) {
        this.name = name;
        this.volume = volume;
        this.typeOfOil = typeOfOil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getTypeOfOil() {
        return typeOfOil;
    }

    public void setTypeOfOil(String typeOfOil) {
        this.typeOfOil = typeOfOil;
    }
}
