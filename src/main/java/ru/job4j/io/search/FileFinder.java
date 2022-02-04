package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;

public class FileFinder {

    private static void isArgsCorrect(ArgsName argsName) {

        if (!Paths.get(argsName.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Wrong source path");
        }

        if (!("mask".equals(argsName.get("t")))) {
            if (!"name".equals(argsName.get("t"))) {
                throw new IllegalArgumentException("Wrong search type");
            }
        }
    }

    private static boolean checkNumberOfArgs(String[] args) {
        boolean result = true;
        if (args.length != 4) {
            String msg = "Enter parameters: -d=\"c://Users//Aleksandr//Desktop//X\" -n=\"*.txt\" -t=mask -o=\"resultFileFinder.txt\"\n d - directory for search \n n - file name\n t - type for searching mask\\name\n o - file name for report";

            System.out.println(msg);
            result = false;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        if (!checkNumberOfArgs(args)) {
            return;
        }

        ArgsName argsName = ArgsName.of(args);

        isArgsCorrect(argsName);

        searchFile(argsName);
    }

    private static void searchFile(ArgsName argsName) throws IOException {
        Path dir = Paths.get(argsName.get("d"));
        String searchType = argsName.get("t");
        String file = argsName.get("n");
        String report = argsName.get("o");

        if ("mask".equals(searchType)) {
            SearcherByMask searcher = new SearcherByMask(file, report);
            Files.walkFileTree(dir, searcher);
            searcher.getReport();
        } else if ("name".equals(searchType)) {
            SearcherByName searcher = new SearcherByName(file, report);
            Files.walkFileTree(dir, searcher);
            searcher.getReport();
        }
    }
}

class SearcherByName extends SimpleFileVisitor<Path> {

    public static StringBuilder builder = new StringBuilder();

    private final String fileName;
    private final String report;

    public SearcherByName(String fileName, String report) {
        this.fileName = fileName;
        this.report = report;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Predicate<Path> predicate = path -> path.toFile().getName().equals(fileName);

        if (predicate.test(file)) {
            builder.append(file.toAbsolutePath()).append(System.lineSeparator());
        }

        return FileVisitResult.CONTINUE;
    }

    public void getReport() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(report))) {
            writer.write(builder.toString());
        }
    }
}

class SearcherByMask extends SimpleFileVisitor<Path> {

    public static StringBuilder builder = new StringBuilder();

    private final String mask;
    private final String report;

    public SearcherByMask(String mask, String report) {
        this.mask = mask;
        this.report = report;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Predicate<Path> predicate = path -> path.toFile().getName().contains(mask);

        if (predicate.test(file)) {
            builder.append(file.toAbsolutePath()).append(System.lineSeparator());
        }

        return FileVisitResult.CONTINUE;
    }

    public void getReport() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(report))) {
            writer.write(builder.toString());
        }
    }
}
