package com.tw.leewin.katabankocr;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FuzzyCorrectorTest {

    private FuzzyCorrector fuzzyCorrector = new FuzzyCorrector();

    @Test
    public void should_return_valid_number_given_invalid_number() throws Exception {
        //Given
        String accountNumber = "200000000";
        String expectedNumber = "200800000";

        //When
        List<String> resultList = fuzzyCorrector.getValidAccountNumbers(accountNumber);

        //Then
        assertThat(resultList.size(), is(1));
        assertThat(resultList.get(0), is(expectedNumber));
    }

    @Test
    public void should_return_multiple_valid_number_given_invalid_number() throws Exception {
        //Given
        String accountNumber = "888888888";
        String expectedNumber1 = "888886888";
        String expectedNumber2 = "888888880";
        String expectedNumber3 = "888888988";
        ImmutableList<String> immutableList = ImmutableList.of(expectedNumber1, expectedNumber2, expectedNumber3);

        //When
        List<String> resultList = fuzzyCorrector.getValidAccountNumbers(accountNumber);

        //Then
        assertThat(resultList.size(), is(3));
        assertTrue(immutableList.containsAll(resultList));
        assertTrue(resultList.containsAll(immutableList));
    }

}