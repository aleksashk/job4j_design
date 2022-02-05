package ru.job4j.io.search;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileFinder extends SimpleFileVisitor<Path> {

    private final Predicate<String> condition;
    private final List<Path> pathList;

    public FileFinder(Predicate<String> condition) {
        this.condition = condition;
        this.pathList = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (condition.test(file.toString())) {
            pathList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return pathList;
    }
}