package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEqualTo("Tetrahedron");
    }

    @Test
    void getNumberOfVerticesIs4() {
        Box box = new Box(4, 50);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4)
                .isNotZero();
    }

    @Test
    void isExist() {
        Box box = new Box(4, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isEqualTo(true)
                .isNotEqualTo(false);
    }

    @Test
    void getAreaWith4Vertex() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(173.205, withPrecision(0.001d))
                .isNotEqualTo(200);
    }
}