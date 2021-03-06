package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(path.toFile().getPath()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );

        isValidNumberOfArgs(args);
        ArgsName.of(args);

        ArgsName arguments = ArgsName.of(args);
        String sourceDirectory = arguments.get("d");
        Path sourceFile = Paths.get(sourceDirectory);

        checkSourceDirectory(sourceDirectory, sourceFile);

        String excludedFile = arguments.get("e").startsWith(".") ? arguments.get("e") : "." + arguments.get("e");
        String destinationDirectory = arguments.get("o");
        File destinationFile = new File(destinationDirectory);

        List<Path> search = Search.search(sourceFile, el -> !el.toFile().getName().endsWith(excludedFile));

        packFiles(search, destinationFile);
    }

    private static void checkSourceDirectory(String sourceDirectory, Path sourceFile) {
        if (sourceDirectory.isEmpty() || !sourceFile.toFile().exists()) {
            throw new IllegalArgumentException("wrong argument: " + sourceDirectory + ". Path " + sourceDirectory + " doesn't exist.");
        }
    }

    private static void isValidNumberOfArgs(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Number of parameters should be equals 3.");
        }
    }

}
