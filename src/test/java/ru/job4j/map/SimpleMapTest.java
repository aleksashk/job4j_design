package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleMapTest {

    @Test
    public void whenPutNotNull() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "Sunday"));
        assertFalse(map.put(1, "Sunday"));
    }

    @Test
    public void whenGetKey() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(55, "fifty five");
        String expected = "fifty five";
        String actual = map.get(55);
        assertEquals(expected, actual);
    }

    @Test
    public void whenKeyNotExist() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(5, "five");
        String expected = null;
        String actual = map.get(55);
        assertEquals(expected, actual);
    }

    @Test
    public void whenRemoveEntry() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(5, "five");
        assertTrue(map.remove(5));
    }

    @Test
    public void whenDidntRemoveEntry() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(5, "five");
        assertFalse(map.remove(55));
    }

}