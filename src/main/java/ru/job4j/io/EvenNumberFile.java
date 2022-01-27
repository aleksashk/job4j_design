package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = fis.read()) != -1) {
                sb.append((char) read);
            }
            String[] numbers = sb.toString().split(System.lineSeparator());
            for (String str : numbers) {
                if (Integer.parseInt(str) % 2 == 0) {
                    System.out.println("Number " + Integer.parseInt(str) + " is even");
                } else {
                    System.out.println("Number " + Integer.parseInt(str) + " is odd");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
