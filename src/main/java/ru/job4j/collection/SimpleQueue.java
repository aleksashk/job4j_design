package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private int sizeIn;
    private int sizeOut;
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        int counter = sizeIn;
        if (counter == 0) {
            throw new NoSuchElementException();
        }
        while (counter != 0) {
            out.push(in.pop());
            counter--;
            sizeOut++;
            sizeIn--;
        }
        sizeOut--;
        return out.pop();
    }

    public void push(T value) {
        int counter = sizeOut;
        if (counter != 0) {
            while (counter != 0) {
                in.push(out.pop());
                counter--;
                sizeOut--;
                sizeIn++;
            }
        }
        in.push(value);
        sizeIn++;
    }
}