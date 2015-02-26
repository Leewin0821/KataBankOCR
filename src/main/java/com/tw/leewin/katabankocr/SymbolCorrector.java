package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
import com.tw.leewin.katabankocr.domain.AccountNumber;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by lwzhang on 2/26/15.
 */
public class SymbolCorrector {

    private List<String> validNumbersList = Lists.newArrayList();

    private List<String> recogniseSymbol(String invalidSymbol) {
        for (Numbers numbers : Numbers.values()){
            int difference = StringUtils.getLevenshteinDistance(invalidSymbol, numbers.getSymbols());
            if (difference == 1){
                validNumbersList.add(numbers.getNumber());
            }
        }
        return validNumbersList;
    }

    public List<String> recogniseAccountNumber(AccountNumber accountNumber) {
        List<String> illegibleSymbolList = accountNumber.getIllegibleSymbolList();
        for (String illegibleSymbol : illegibleSymbolList){
            List<String> legibleSymbolList = recogniseSymbol(illegibleSymbol);
        }
    }
}
