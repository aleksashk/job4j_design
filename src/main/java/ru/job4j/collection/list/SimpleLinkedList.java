package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> prevVal;
    private Node<E> nextVal;
    int size;
    int modCount;

    @Override
    public void add(E value) {
        Node<E> current = new Node<>(value, null);
        if (size == 0) {
            prevVal = current;
        } else {
            nextVal.nextRef = current;
        }
        nextVal = current;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = prevVal;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                break;
            }
            current = current.nextRef;
        }
        return current.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            Node<E> position = prevVal;

            @Override
            public boolean hasNext() {
                return position != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E value = position.getValue();
                position = position.nextRef;
                return value;
            }
        };
    }
}
