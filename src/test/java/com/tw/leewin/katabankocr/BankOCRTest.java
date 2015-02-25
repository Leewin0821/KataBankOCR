package com.tw.leewin.katabankocr;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankOCRTest {

    @Test
    public void should_get_correct_message_given_valid_and_legible_number() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("valid_and_legible_account_number.txt").getPath();
        BankOCR printer = new BankOCR();
        String expectedMessage = "345882865";

        //When
        String actualMessage = printer.printAccountNumber(filePath);

        //Then
        assertThat(actualMessage, is(expectedMessage));

    }

    @Test
    public void should_get_correct_message_given_invalid_and_legible_number() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("invalid_and_legible_account_number.txt").getPath();
        BankOCR printer = new BankOCR();
        String expectedMessage = "345882866  ERR";

        //When
        String actualMessage = printer.printAccountNumber(filePath);

        //Then
        assertThat(actualMessage, is(expectedMessage));

    }

    @Test
    public void should_get_correct_message_given_illegible_number() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("illegible_account_number.txt").getPath();
        BankOCR printer = new BankOCR();
        String expectedMessage = "3458?2865  ILL";

        //When
        String actualMessage = printer.printAccountNumber(filePath);

        //Then
        assertThat(actualMessage, is(expectedMessage));

    }
}