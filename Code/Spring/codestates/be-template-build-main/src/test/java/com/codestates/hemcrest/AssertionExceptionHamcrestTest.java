package com.codestates.hemcrest;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionExceptionHamcrestTest {

    @DisplayName("throws NullPointerException when map.get()")
    @Test
    public void assertionThrowExceptionTest() {
        Throwable actualException = assertThrows(NullPointerException.class,
                () -> getCryptoCurrency("XRP"));

        assertThat(actualException.getCause(), is(equalTo(null)));
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
