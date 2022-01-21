package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class SimpleTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenChildExistOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.add(2, 6));
    }

    @Test
    public void whenAddLeafNotBinaryTree() {
        Tree<Integer> tree = new SimpleTree<>(25);
        tree.add(25, 17);
        tree.add(25, 27);
        tree.add(25, 10);
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenAddLeafBinaryTree() {
        Tree<Integer> tree = new SimpleTree<>(25);
        tree.add(25, 17);
        tree.add(25, 27);
        tree.add(27, 10);
        tree.add(27, -2);
        tree.add(17, 5);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(14);
        assertFalse(tree.add(12,7));
    }

}