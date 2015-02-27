package com.tw.leewin.katabankocr;

import com.google.common.collect.Maps;
import com.tw.leewin.katabankocr.domain.AccountNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class SymbolCorrectorTest {

    @Test
    public void should_get_correct_number_given_illegible_symbol_file() throws Exception {
        //Given
        SymbolCorrector symbolCorrector = new SymbolCorrector();
        AccountNumber accountNumber = new AccountNumber();
        accountNumber.setAccountNumber("?23456789");
        Map<Integer,String> illegibleSymbolMap = Maps.newHashMap();
        illegibleSymbolMap.put(0, "    _|  |");
        accountNumber.setIllegibleSymbolMap(illegibleSymbolMap);

        //When
        List<String> actualNumbers = symbolCorrector.recogniseAccountNumber(accountNumber);

        //Then
        assertThat(actualNumbers.size(), is(2));
        assertThat(actualNumbers.get(0), is("123456789"));
        assertThat(actualNumbers.get(1), is("423456789"));
    }

//    @Test
//    public void should_get_correct_number_given_multiple_illegible_symbol_file() throws Exception {
//        //Given
//        SymbolCorrector symbolCorrector = new SymbolCorrector();
//        AccountNumber accountNumber = new AccountNumber();
//        accountNumber.setAccountNumber("?234?6789");
//        Map<Integer,String> illegibleSymbolMap = Maps.newHashMap();
//        illegibleSymbolMap.put(0, "    _|  |");
//        illegibleSymbolMap.put(4, " _  _  _|");
//        accountNumber.setIllegibleSymbolMap(illegibleSymbolMap);
//
//        //When
//        List<String> actualNumbers = symbolCorrector.recogniseAccountNumber(accountNumber);
//
//        //Then
//        assertThat(actualNumbers.size(), is(4));
//        assertThat(actualNumbers.get(0), is("123456789"));
//        assertThat(actualNumbers.get(1), is("123436789"));
//        assertThat(actualNumbers.get(2), is("423456789"));
//        assertThat(actualNumbers.get(3), is("423436789"));
//    }
}