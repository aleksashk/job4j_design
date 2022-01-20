package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;

        expand();

        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        int number = hashCode;
        int tmp = 0;
        while (number >= 1) {
            tmp += number % 10;
            number /= 10;
        }
        return tmp % (capacity - 1);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        if (count >= capacity * LOAD_FACTOR) {
            capacity *= 2;
            table = new MapEntry[capacity];
            for (MapEntry<K, V> entry : table) {
                if (entry != null) {
                    int newIndex = indexFor(hash(entry.key.hashCode()));
                    table[newIndex] = entry;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int targetIndex = indexFor(hash(key.hashCode()));
        MapEntry<K, V> targetEntry = table[targetIndex];
        V result;
        if (targetEntry == null || !targetEntry.key.equals(key)) {
            result = null;
        } else {
            result = targetEntry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        int targetIndex = indexFor(hash(key.hashCode()));
        MapEntry<K, V> targetEntry = table[targetIndex];
        boolean result;
        if (targetEntry == null || !targetEntry.key.equals(key)) {
            result = false;
        } else {
            table[targetIndex] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int pointer = 0;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw  new ConcurrentModificationException();
                }
                while (pointer < table.length && table[pointer] != null) {
                    pointer++;
                }
                return pointer < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[pointer].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
