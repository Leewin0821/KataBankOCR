package com.tw.leewin.katabankocr;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountNumberValidatorTest {

    private AccountNumberValidator validator = new AccountNumberValidator();

    @Test
    public void should_return_valid_given_valid_number() throws Exception {
        //Given
        String accountNumber = "345882865";
        String expectedNumber = "345882865";

        //When
        String result = validator.getValidAccountNumber(accountNumber);

        //Then
        assertThat(result, is(expectedNumber));
    }

    @Test
    public void should_return_valid_number_given_invalid_number() throws Exception {
        //Given
        String accountNumber = "200000000";
        String expectedNumber = "200800000";

        //When
        String result = validator.getValidAccountNumber(accountNumber);

        //Then
        assertThat(result, is(expectedNumber));
    }

}