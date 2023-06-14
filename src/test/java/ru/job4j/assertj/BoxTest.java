package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 50);
        String name = box.whatsThis();
        int number = box.getNumberOfVertices();
        assertThat(name).isEqualTo("Unknown object");
        assertThat(number).isEqualTo(box.getNumberOfVertices());
    }

    @Test
    void getNumberOfVertices() {
        Box box = new Box(4, 50);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void isExist() {
        Box box = new Box(4, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isEqualTo(true);
    }

    @Test
    void getArea() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(173.205, withPrecision(0.001d));
    }
}