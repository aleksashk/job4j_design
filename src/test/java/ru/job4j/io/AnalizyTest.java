package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenStringStartsWith400() throws IOException {
        File source = folder.newFile("source.log");
        File target = folder.newFile("target.log");

        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("500 10:59:01");
            writer.println("400 11:01:02");
            writer.println("200 11:02:02");
        }

        StringBuilder expected = new StringBuilder();
        expected.append("10:57:01").append(";").append("11:02:02");
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder actual = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                actual.append(line);
            }
        }
        assertEquals(expected, actual);
    }
}