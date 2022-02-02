package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonEx1 {
    public static void main(String[] args) {
        final DrawingSet drawingSet = new DrawingSet(true, 4.17, new String[]{"pencils", "eraser"}, new Descriptions("Your first drawing set", 10558477L, "Black pencil, red pencil, white pencil, 2 erasers"));
        final Gson gson = new GsonBuilder().create();

        System.out.println(gson.toJson(drawingSet));

        final String drawingSetJson = "{"
                + "\"isAmateur\":true,"
                + "\"price\":4.17,"
                + "\"things\":"
                + "[\"pencils\",\"eraser\"],"
                + "\"descriptions\":"
                + "{"
                + "\"name\":\"Your first drawing set\","
                + "\"serialID\":10558477,"
                + "\"setComposition\":\"Black pencil, red pencil, white pencil, 2 erasers\""
                + "}"
                + "}";
        final DrawingSet drawingSetMod = gson.fromJson(drawingSetJson, DrawingSet.class);
        System.out.println(drawingSetMod);
    }
}
