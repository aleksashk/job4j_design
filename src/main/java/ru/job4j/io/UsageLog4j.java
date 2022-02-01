package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        byte byteVar = 12;
        char charVar = 65;
        short shortVar = 5412;
        int intVar = 4_565_887;
        long longVar = 32L;
        float floatVar = 0.12f;
        double doubleVar = 341.59;
        boolean booleanVar = true;

        LOG.debug("byteVar = {}, charVar = {}, shortVar = {}, intVar = {}, longVar = {}, floatVar = {}, doubleVar = {}, booleanVar = {}", byteVar, charVar, shortVar, intVar, longVar, floatVar, doubleVar, booleanVar);
    }
}