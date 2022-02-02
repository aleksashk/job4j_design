package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private double volume;

    @XmlAttribute
    private String typeOfOil;

    public Engine() {
    }

    public Engine(String name, double volume, String typeOfOil) {
        this.name = name;
        this.volume = volume;
        this.typeOfOil = typeOfOil;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name='" + name + '\''
                + ", volume=" + volume
                + ", typeOfOil='" + typeOfOil + '\''
                + '}';
    }
}
