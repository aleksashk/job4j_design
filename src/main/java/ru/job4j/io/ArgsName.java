package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {

        isEmptyArgs(args.length);

        for (String str : args) {

            isContainsEquals(str);

            int firstInd = str.indexOf("=");

            isParameterHasValue(str, firstInd);

            values.put(str.substring(1, firstInd), str.substring(firstInd + 1));
        }
    }

    private void isParameterHasValue(String str, int firstInd) {
        if (str.substring(firstInd + 1).length() == 0) {
            throw new IllegalArgumentException("Value is empty");
        }
    }

    private void isContainsEquals(String str) {
        if (!str.contains("=")) {
            throw new IllegalArgumentException("Every parameter should have sign equals");
        }
    }

    private void isEmptyArgs(int lengthArgs) {
        if (lengthArgs == 0) {
            throw new IllegalArgumentException("Parameters didn't find");
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
