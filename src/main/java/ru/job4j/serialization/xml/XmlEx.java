package ru.job4j.serialization.xml;

public class XmlEx {
    public static void main(String[] args) {
        Car porche = new Car(false, 1, "Green", new Engine("V8", 3.2, "petrol"), "40 gallons of petrol", "winter tire set");
    }
}
