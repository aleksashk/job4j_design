package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, String> duplicatesMap;

    public DuplicatesVisitor() {
        this.duplicatesMap = new HashMap<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        duplicatesMap.put(fileProperty, file.toAbsolutePath().toString());
        return FileVisitResult.CONTINUE;
    }

    public void showDuplicates() {
        for (Map.Entry<FileProperty, String> entry : duplicatesMap.entrySet()) {
            List<String> values = new ArrayList<>(List.of(entry.getValue()));
            if (values.size() > 1) {
                System.out.println("file: " + entry.getKey() + " found in: ");
                for (String str : values) {
                    System.out.println("\t" + str);
                }
            }
        }
    }
}
