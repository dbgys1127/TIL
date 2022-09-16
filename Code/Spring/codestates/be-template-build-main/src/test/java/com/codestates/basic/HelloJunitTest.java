package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HelloJunitTest {

    @DisplayName("Hello Junit Test")
    @Test
    public void assertionTest() {
        String expected = "Hello, World";
        String actual = "Hello, JUnit";

//        assertEquals(expected, actual);
        assertNotEquals(expected, actual);
    }
}
