package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class FileFinder {
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String msg = "Enter parameters: -d=\"c://Users//Aleksandr//Desktop//X\" -n=\"*.txt\" -t=mask -o=\"resultFileFinder.txt\"\n d - directory for search \n n - file name\n t - type for searching mask\\name\n o - file name for report";

        System.out.println(msg);

        checkNumberOfArgs(args);

        ArgsName argsName = ArgsName.of(args);

        isArgsCorrect(argsName);

        FileFinder.handle(argsName);
    }

    private static void isArgsCorrect(ArgsName argsName) {
        if (!Paths.get(argsName.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Wrong source path");
        }
        if (argsName.get("n").split("\\.")[0] == null
                || argsName.get("n").split("\\.")[0].isEmpty()
                || argsName.get("n").split("\\.")[1] == null
                || argsName.get("n").split("\\.")[1].isEmpty()
                || argsName.get("n").split("\\.")[1].length() != 3) {
            throw new IllegalArgumentException("Wrong source file name");
        }
        if (!("mask".equals(argsName.get("t")))) {
            if (!"name".equals(argsName.get("t"))) {
                throw new IllegalArgumentException("Wrong search type");
            }
        }
        if (argsName.get("o").split("\\.")[0] == null
                || argsName.get("o").split("\\.")[0].isEmpty()
                || argsName.get("o").split("\\.")[1] == null
                || argsName.get("o").split("\\.")[1].isEmpty()
                || argsName.get("o").split("\\.")[1].length() != 3) {
            throw new IllegalArgumentException("Wrong destination file name");
        }
    }

    private static void checkNumberOfArgs(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Number of parameters doesn't equals 4");
        }
    }

    public static void handle(ArgsName argsName) throws Exception {

        String directoryName = argsName.get("d");
        String fileName = argsName.get("n");
        String typeSearch = argsName.get("t");
        String resultFileName = argsName.get("o");

        File directory = new File(directoryName);
        File[] filesStr = directory.listFiles();

        ifDirectoryEmpty(directoryName, filesStr);

        checkDirectory(fileName, resultFileName, filesStr, typeSearch);
    }

    private static void ifDirectoryEmpty(String directoryName, File[] filesStr) {
        if (filesStr == null || filesStr.length == 0) {
            throw new NoSuchElementException("Directory " + directoryName + " is empty");
        }
    }

    private static void checkDirectory(String fileName, String resultFileName, File[] filesStr, String typeSearch) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName))) {
            for (File file : filesStr) {
                if (file.isDirectory()) {
                    File[] tempDir = file.listFiles();
                    ifDirectoryEmpty(file.getName(), tempDir);
                    checkDirectory(fileName, resultFileName, tempDir, typeSearch);
                }
                if (file.isFile()) {
                    if ("name".equals(typeSearch) && file.getName().endsWith(fileName)) {
                        builder.append(file).append(System.lineSeparator());
                    } else if ("mask".equals(typeSearch) && file.getName().contains(fileName.replaceAll("\\*", ""))) {
                        builder.append(file).append(System.lineSeparator());
                    }
                }
            }
            writer.write(builder.toString());
        }
    }
}
