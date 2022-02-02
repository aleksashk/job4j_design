package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(argsName);
    }

    public static void handle(ArgsName argsName) throws Exception {

        String src = argsName.get("path");
        String delim = argsName.get("delimiter");
        String dest = argsName.get("out");
        String[] filter = argsName.get("filter").split(",");

        Scanner scanner = new Scanner(new File(src));
        int[] indexes = new int[filter.length];

        String line = scanner.nextLine();
        String[] lineArray = line.split(delim);
        for (int i = 0, j = 0; j < indexes.length; i++) {
            if (filter[j].equals(lineArray[i])) {
                indexes[j] = i;
                j++;
            }
        }

        scanner.close();

        Scanner scanner1 = new Scanner(new File(src));
        if ("stdout".equals(dest)) {
            while (scanner1.hasNextLine()) {
                String[] lines = scanner1.nextLine().split(", ");
                for (int i = 0; i < indexes.length; i++) {
                    System.out.print(lines[indexes[i]]);
                    if (i != indexes.length - 1) {
                        System.out.print(delim);
                    } else {
                        System.out.println();
                    }
                }
            }
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(dest))) {
                while (scanner1.hasNextLine()) {
                    String[] lines = scanner1.nextLine().split(delim);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < indexes.length; i++) {
                        sb.append(lines[indexes[i]]);
                        if (i != indexes.length - 1) {
                            sb.append(delim);
                        }
                    }
                    writer.println(sb);
                }
            }
        }
    }
}
