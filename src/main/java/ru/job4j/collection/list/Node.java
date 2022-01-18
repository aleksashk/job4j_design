package ru.job4j.collection.list;

public class Node<E> {
    E value;
    Node<E> nextRef;

    public Node(E value, Node<E> nextRef) {
        this.value = value;
        this.nextRef = nextRef;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<E> nextRef) {
        this.nextRef = nextRef;
    }
}
