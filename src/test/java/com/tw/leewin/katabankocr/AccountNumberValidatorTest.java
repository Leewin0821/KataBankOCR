package com.tw.leewin.katabankocr;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountNumberValidatorTest {

    @Test
    public void should_return_true_given_valid_number() throws Exception {
        //Given
        String accountNumber = "345882865";

        //When
        Boolean result = AccountNumberValidator.validate(accountNumber);

        //Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_given_invalid_number() throws Exception {
        //Given
        String accountNumber = "345882866";

        //When
        Boolean result = AccountNumberValidator.validate(accountNumber);

        //Then
        assertFalse(result);
    }

    @Test
    public void testName() throws Exception {


    }
}