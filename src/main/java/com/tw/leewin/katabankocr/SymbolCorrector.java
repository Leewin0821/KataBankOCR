package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by lwzhang on 2/26/15.
 */
public class SymbolCorrector {

    private List<String> validNumbersList = Lists.newArrayList();

    public List<String> recogniseSymbol(String invalidSymbol) {
        for (Numbers numbers : Numbers.values()){
            int difference = StringUtils.getLevenshteinDistance(invalidSymbol, numbers.getSymbols());
            if (difference == 1){
                validNumbersList.add(numbers.getNumber());
            }
        }
        return validNumbersList;
    }
}
