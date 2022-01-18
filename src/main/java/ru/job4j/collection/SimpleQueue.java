package ru.job4j.collection;

public class SimpleQueue<T> {
    private int size;
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        int counter = size;
        while (counter != 0) {
            out.push(in.pop());
            counter--;
        }
        T value = out.pop();
        counter = --size;
        while (counter != 0) {
            in.push(out.pop());
            counter--;
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}