package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("2 * 1 = 2\t\t3 * 1 = 3\t\t4 * 1 = 4\t\t5 * 1 = 5".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 2 = 4\t\t3 * 2 = 6\t\t4 * 2 = 8\t\t5 * 2 = 10".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 3 = 6\t\t3 * 3 = 9\t\t4 * 3 = 12\t\t5 * 3 = 15".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 4 = 8\t\t3 * 4 = 12\t\t4 * 4 = 16\t\t5 * 4 = 20".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 5 = 10\t\t3 * 5 = 15\t\t4 * 5 = 20\t\t5 * 5 = 25".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 6 = 12\t\t3 * 6 = 18\t\t4 * 24 = 4\t\t5 * 6 = 30".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 7 = 14\t\t3 * 7 = 21\t\t4 * 7 = 28\t\t5 * 7 = 35".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 8 = 16\t\t3 * 8 = 24\t\t4 * 8 = 32\t\t5 * 8 = 40".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 9 = 18\t\t3 * 9 = 27\t\t4 * 9 = 36\t\t5 * 9 = 45".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 * 10 = 20\t\t3 * 10 = 30\t\t4 * 10 = 40\t\t5 * 10 = 50".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 1 = 6\t\t7 * 1 = 7\t\t8 * 1 = 8\t\t9 * 1 = 9".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 2 = 12\t\t7 * 2 = 14\t\t8 * 2 = 16\t\t9 * 2 = 18".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 3 = 18\t\t7 * 3 = 21\t\t8 * 3 = 24\t\t9 * 3 = 27".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 4 = 24\t\t7 * 4 = 28\t\t8 * 4 = 32\t\t9 * 4 = 36".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 5 = 30\t\t7 * 5 = 35\t\t8 * 5 = 40\t\t9 * 5 = 45".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 6 = 36\t\t7 * 6 = 42\t\t8 * 6 = 48\t\t9 * 6 = 54".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 7 = 42\t\t7 * 7 = 49\t\t8 * 7 = 56\t\t9 * 7 = 63".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 8 = 48\t\t7 * 8 = 56\t\t8 * 8 = 64\t\t9 * 8 = 72".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 9 = 54\t\t7 * 9 = 63\t\t8 * 9 = 72\t\t9 * 9 = 81".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6 * 10 = 60\t\t7 * 10 = 70\t\t8 * 10 = 80\t\t9 * 10 = 90".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}