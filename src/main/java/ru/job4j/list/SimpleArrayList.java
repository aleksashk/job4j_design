package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements List<T> {
    private static final int DEFAULTCAPACITY = 10;
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        if (capacity >= 0) {
            this.container = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public SimpleArrayList() { }

    private void increaseSize() {
        if (size == 0) {
            container = (T[]) new Object[DEFAULTCAPACITY];
        }
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public void add(T value) {
        increaseSize();
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T temp = get(index);
        container[index] = newValue;
        modCount++;
        return temp;
    }

    @Override
    public T remove(int index) {
        T temp = get(index);
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(container, index + 1, container, index, newSize - index);
        }
        size = newSize;
        container[size] = null;
        modCount++;
        return temp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int position = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }
        };
    }
}
