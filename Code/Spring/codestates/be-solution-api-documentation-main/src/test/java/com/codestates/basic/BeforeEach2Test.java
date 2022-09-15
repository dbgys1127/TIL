package com.codestates.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BeforeEach2Test {
    private Map<String, String> map;

    @BeforeEach
    public void init() {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "ADA");
        map.put("POT", "Polkadot");
    }

    @DisplayName("Test case 1")
    @Test
    public void beforeEachTest() {
        map.put("XRP", "Ripple");
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    @DisplayName("Test case 2")
    @Test
    public void beforeEachTest2() {
        System.out.println(map);
//        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
        assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}
