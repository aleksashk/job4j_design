package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) throws Exception {

        checkNumberOfArgs(args);

        ArgsName argsName = ArgsName.of(args);

        isArgsCorrect(argsName);

        CSVReader.handle(argsName);
    }

    private static void isArgsCorrect(ArgsName argsName) {
        if (!argsName.get("path").endsWith(".csv") || !Path.of(argsName.get("path")).toFile().exists()) {
            throw new IllegalArgumentException("Wrong source file name");
        }
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Wrong delimiter");
        }
        if (!("stdout".equals(argsName.get("out")))) {
            if (!argsName.get("out").endsWith(".csv")) {
                throw new IllegalArgumentException("Wrong destination");
            }
        }
        if (argsName.get("filter") == null || argsName.get("filter").isEmpty()) {
            throw new IllegalArgumentException("Wrong filter");
        }
    }

    private static void checkNumberOfArgs(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Number of parameters doesn't equals 4");
        }
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
                String[] lines = scanner1.nextLine().split(delim);
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
