package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Find {

    public static void main(String[] args) throws IOException {

        checkArgs(args);
        ArgsName argsName = ArgsName.of(args);
        search(argsName);

    }

    private static void checkDirectory(Path directory) {
        if (!directory.toFile().exists() || !directory.toFile().isDirectory()) {
            throw new IllegalArgumentException("Please check your first parameter: is it exists and is it folder");
        }
    }

    private static void checkArgs(String[] args) {
        if (args.length != 4
                || !args[0].startsWith("-d=")
                || !args[1].startsWith("-n=")
                || !args[2].startsWith("-t=")
                || !args[3].startsWith("-o=")) {
            throw new IllegalArgumentException("Wrong parameters. Usage -d=\"c://Users//Aleksandr//Desktop//X\" -n=\"*.txt\" -t=mask -o=\"resultFileFinder.txt\"\n d - directory for search\n n - file name\n t - type for searching mask/name\n o - file name for report");
        }
    }

    private static FileFinder findOption(ArgsName argsName) {

        if ("mask".equals(argsName.get("t"))) {
            String mask = argsName.get("n");
            if (mask.contains("*")) {
                mask = mask.replaceAll("\\*", "\\.*");
            } else if (mask.contains("?")) {
                mask = mask.replace("\\?", "\\w{1}");
            }
            Pattern pattern = Pattern.compile(mask);
            return new FileFinder(e -> pattern.matcher(e).find());
        }

        return new FileFinder(e -> e.endsWith(argsName.get("n")));
    }

    public static void search(ArgsName argsName) throws IOException {

        Path directory = Paths.get(argsName.get("d"));
        checkDirectory(directory);

        FileFinder searchType = findOption(argsName);
        String report = argsName.get("o");

        Files.walkFileTree(directory, searchType);
        List<Path> list = searchType.getPaths();

        writeToFile(report, list);

    }

    private static void writeToFile(String report, List<Path> list) throws IOException {
        try (PrintWriter writer = new PrintWriter(report)) {
            for (Path path : list) {
                writer.println(path.toString());
            }
        }
    }
}
