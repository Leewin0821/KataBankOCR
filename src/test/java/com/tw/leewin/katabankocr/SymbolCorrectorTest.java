package com.tw.leewin.katabankocr;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SymbolCorrectorTest {

    @Test
    public void should_get_correct_number_given_illegible_symbol_file() throws Exception {
        //Given
        String invalidSymbol = "    _|  |";
        String expectNumber1 = "1";
        String expectNumber2 = "4";
        SymbolCorrector symbolCorrector = new SymbolCorrector();

        //When
        List<String> actualNumbers = symbolCorrector.recogniseSymbol(invalidSymbol);

        //Then
        assertThat(actualNumbers.size(), is(2));
        assertThat(actualNumbers.get(0), is(expectNumber1));
        assertThat(actualNumbers.get(1), is(expectNumber2));
    }
}