package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tw.leewin.katabankocr.domain.AccountNumber;
import org.apache.commons.lang3.StringUtils;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lwzhang on 2/26/15.
 */
public class SymbolCorrector {

    private List<String> validNumbersList = Lists.newArrayList();

    private List<String> recogniseSymbol(String invalidSymbol) {
        for (Numbers numbers : Numbers.values()) {
            int difference = StringUtils.getLevenshteinDistance(invalidSymbol, numbers.getSymbols());
            if (difference == 1) {
                validNumbersList.add(numbers.getNumber());
            }
        }
        return validNumbersList;
    }

    public List<String> recogniseAccountNumber(AccountNumber accountNumber) {

        //TODO: Finish Arrange & Combination of multiple illegible symbols
        String accountNumberStr = accountNumber.getAccountNumber();
        Map<Integer, String> illegibleSymbolMap = accountNumber.getIllegibleSymbolMap();
        List<String> accountNumberList = Lists.newArrayList();

        Integer index = illegibleSymbolMap.keySet().iterator().next();
        List<String> legibleSymbolList = recogniseSymbol(illegibleSymbolMap.get(index));
        for (String legibleSymbol : legibleSymbolList){
            accountNumberList.add(StringUtils.overlay(accountNumberStr, legibleSymbol, index, index + 1));
        }
        return accountNumberList;
    }
}
