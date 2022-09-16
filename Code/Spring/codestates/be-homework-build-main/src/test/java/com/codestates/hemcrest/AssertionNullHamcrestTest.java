package com.codestates.hemcrest;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AssertionNullHamcrestTest {

    @DisplayName("AssertionNull() Test")
    @Test
    public void assertNotNullTest() {
        String currencyName = getCryptoCurrency("ETH");

        assertThat(currencyName, is(notNullValue()));
//        assertThat(currencyName, is(nullValue()));
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }
}
