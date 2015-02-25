package com.tw.leewin.katabankocr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DigitsParserTest {
    private DigitsParser digitsParser;

    @Before
    public void setUp() throws Exception {
        digitsParser = new DigitsParser();
    }

    @After
    public void tearDown() throws Exception {
        digitsParser = null;
    }


    @Test
    public void should_return_correct_digits_given_with_same_numbers() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("same_numbers.txt").getPath();
        String expectedResult = "888888888";

        //When
        String actualResult = digitsParser.parse(filePath).getAccountNumber();

        //Then
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_return_correct_digits_given_different_numbers() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("different_numbers.txt").getPath();
        String expectedResult = "123456789";

        //When
        String actualResult = digitsParser.parse(filePath).getAccountNumber();

        //Then
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_return_correct_digits_given_single_error_number() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("single_error_number.txt").getPath();
        String expectedResult = "12345678?";

        //When
        String actualResult = digitsParser.parse(filePath).getAccountNumber();

        //Then
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_return_correct_digits_given_multiple_error_numbers() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("multiple_error_numbers.txt").getPath();
        String expectedResult = "12?45?789";

        //When
        String actualResult = digitsParser.parse(filePath).getAccountNumber();

        //Then
        assertThat(actualResult, is(expectedResult));
    }

//    @Test
//    public void should_return_correct_digits_given_similar_number() throws Exception {
//        //Given
//        String filePath = getClass().getClassLoader().getResource("similar_number.txt").getPath();
//        String expectedResult = "123456789";
//
//        //When
//        String actualResult = digitsParser.parse(filePath).getAccountNumber();
//
//        //Then
//        assertThat(actualResult, is(expectedResult));
//    }

}