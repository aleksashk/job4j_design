package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("plane01"), is("Boing-747"));
        assertThat(config.value("plane02"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentsAndEmptyStrings() {
        String path = "./data/pair_with_comments_and_empty_strings.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("city"), is("Washington"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutFirstValue() {
        String path = "./data/pair_without_first_value.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutSecondValue() {
        String path = "./data/pair_without_second_value.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutSignEquals() {
        String path = "./data/pair_without_sign_equals.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithSignEqualsMoreThenOne() {
        String path = "./data/pair_with_sign_equals_more_then_one.properties";
        Config config = new Config(path);
        config.load();
    }
}