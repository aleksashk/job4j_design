package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> strings = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(strings).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsOnly("first", "second", "three", "four", "five")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .anyMatch(e -> e.equals("second"))
                .first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotNull()
                .hasSize(5)
                .contains("second")
                .doesNotContain("Garden", "Lemon")
                .containsAll(List.of("first", "second", "three", "four", "five"))
                .containsAnyOf("first", "Lamp", "map");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second", "three", "four", "five")
                .containsValues(0, 1, 2, 3, 4)
                .doesNotContainKey("Lemon")
                .doesNotContainValue(32)
                .containsEntry("first", 0);
    }
}