package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ModelTest {
    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean result = model.isCondition();
        assertThat(result).isTrue();

        Model model1 = new Model(1, 6.234d, "I am learning Java", false);
        String result1 = model1.getLine();
        assertThat(result1).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("Java")
                .isEqualTo("I am learning Java");

    }
}