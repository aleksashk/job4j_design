package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean result = false;
        for (T item : set) {
            if (Objects.equals(value, item)) {
                return result;
            }
        }
        result = true;
        set.add(value);
        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = true;
        for (T item : set) {
            if (Objects.equals(value, item)) {
                return result;
            }
        }
        result = false;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}