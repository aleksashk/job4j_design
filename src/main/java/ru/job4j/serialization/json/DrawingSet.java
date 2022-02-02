package ru.job4j.serialization.json;

import org.json.JSONObject;

import java.util.Arrays;

public class DrawingSet {
    private Boolean isAmateur;
    private double price;
    private String[] things;
    private Descriptions descriptions;

    public DrawingSet(Boolean isAmateur, double price, String[] things, Descriptions descriptions) {
        this.isAmateur = isAmateur;
        this.price = price;
        this.things = things;
        this.descriptions = descriptions;
    }

    public DrawingSet(Boolean isAmateur, double price, String[] things) {
        this.isAmateur = isAmateur;
        this.price = price;
        this.things = things;
    }

    public Boolean getAmateur() {
        return isAmateur;
    }

    public void setAmateur(Boolean amateur) {
        isAmateur = amateur;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getThings() {
        return things;
    }

    public void setThings(String[] things) {
        this.things = things;
    }

    public Descriptions getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Descriptions descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "DrawingSet{"
                + "isAmateur=" + isAmateur
                + ", price=" + price
                + ", things=" + Arrays.toString(things)
                + ", descriptions=" + descriptions
                + '}';
    }

    public static void main(String[] args) {
        DrawingSet drawingSet = new DrawingSet(true, 2.15, new String[]{"pencils", "pen"}, new Descriptions("Drawin set for kids", 1244, "Black pencil, red pencil, green pen"));
        Descriptions descriptions = new Descriptions("Drawin set for kids", 1244, "Black pencil, red pencil, green pen");
        drawingSet.setDescriptions(descriptions);

        System.out.println(new JSONObject(drawingSet));
    }
}
