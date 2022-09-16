package com.codestates.basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BeforeAllTest {
    private static Map<String, String> map;

    @BeforeAll
    public static void initAll() {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "ADA");
        map.put("POT", "Polkadot");
        map.put("XRP", "Ripple");

        System.out.println("initialize Crypto Currency map");
    }

    @DisplayName("Test case 1")
    @Test
    public void beforeEachTest() {
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }



    @DisplayName("Test case 2")
    @Test
    public void beforeEachTest2() {
        assertDoesNotThrow(() -> getCryptoCurrency("ADA"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}
