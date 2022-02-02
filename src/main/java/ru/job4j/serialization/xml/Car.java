package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private boolean isTruck;

    @XmlAttribute
    private int numberOfPassengers;

    @XmlAttribute
    private String color;

    Engine engine;

    @XmlElementWrapper(name = "bonuses")
    @XmlElement(name = "bonus")
    String[] bonuses;

    public Car() {
    }

    public Car(boolean isTruck, int numberOfPassengers, String color, Engine engine, String... bonuses) {
        this.isTruck = isTruck;
        this.numberOfPassengers = numberOfPassengers;
        this.color = color;
        this.engine = engine;
        this.bonuses = bonuses;
    }

    @Override
    public String toString() {
        return "Car{"
                + "isTruck=" + isTruck
                + ", numberOfPassengers="
                + numberOfPassengers
                + ", color='" + color + '\''
                + ", engine=" + engine
                + ", bonuses=" + Arrays.toString(bonuses)
                + '}';
    }

}
