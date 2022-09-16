package com.codestates.basic;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionExceptionTest {

    @DisplayName("throws NullPointerException when map.get()")
    @Test
    public void assertionThrowExceptionTest() {
        assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP"));
    }

    @DisplayName("does not throw any Exception when map.get()")
    @Test
    public void assertionDoesNotThrowExceptionTest() {
        assertDoesNotThrow(() -> getCryptoCurrency("BTC"));
    }


    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit).toUpperCase();
    }
}
