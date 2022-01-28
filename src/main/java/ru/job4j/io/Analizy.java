package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class Analizy {
    public void unavailable(String source, String target) {
        String rslString = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            String[] startTimeBreakPosition = new String[2];
            String[] endTimeBreakPosition;
            boolean isAsleep = false;
            String input = reader.readLine();
            while (input != null && !input.isEmpty()) {
                if (!isAsleep && (input.startsWith("400") || input.startsWith("500"))) {
                    startTimeBreakPosition = input.split(" ");
                    isAsleep = true;
                }
                if (isAsleep && (input.startsWith("200") || input.startsWith("300"))) {
                    isAsleep = false;
                    endTimeBreakPosition = input.split(" ");
                    rslString = startTimeBreakPosition[1] + ";" + endTimeBreakPosition[1] + System.lineSeparator();
                }
                input = reader.readLine();
                writer.write(rslString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./server_log.txt", "./unavailable.csv");
    }
}
