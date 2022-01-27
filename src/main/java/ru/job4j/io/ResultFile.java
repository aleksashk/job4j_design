package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            StringBuilder sb = new StringBuilder();
            int[][] array = new int[10][10];
            for (int i = 2; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    array[i][j] = i * j;
                    sb.append(i).append(" * ").append(j).append(" = ").append(array[i][j]).append(System.lineSeparator());
                }
                sb.append(System.lineSeparator());
            }
            out.write(sb.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}