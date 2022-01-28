package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class Analizy {
    public void unavailable(String source, String target) {
        StringJoiner rslString = new StringJoiner(System.lineSeparator());
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
                    rslString.add(startTimeBreakPosition[1] + ";" + endTimeBreakPosition[1]);
                }
                input = reader.readLine();
                writer.write(rslString.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./server_log.txt", "./unavailable.csv");
    }
}
