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
    private Map<FileProperty, List<Path>> duplicatesMap;

    public DuplicatesVisitor() {
        this.duplicatesMap = new HashMap<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!duplicatesMap.containsKey(fileProperty)) {
            duplicatesMap.put(fileProperty, new ArrayList<>());
        }
        duplicatesMap.get(fileProperty).add(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    public void showDuplicates() {
        for (Map.Entry<FileProperty, List<Path>> entry : duplicatesMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("file [" + entry.getKey().getName() + "] found in: ");
                for (Path path : entry.getValue()) {
                    System.out.println("\t" + path.toAbsolutePath());
                }
            }
        }
    }
}
