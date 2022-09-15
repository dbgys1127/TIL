package com.codestates.hemcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HelloHamcrestTest {

    @DisplayName("Hello Junit Test using hamcrest")
    @Test
    public void assertionTest() {
        String expected = "Hello, World";
        String actual = "Hello, JUnit";


//        assertThat(actual, is(equalTo(expected)));
        assertThat(actual, is(not(equalTo(expected))));
    }
}
