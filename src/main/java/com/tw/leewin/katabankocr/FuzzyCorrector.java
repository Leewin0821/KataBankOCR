package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
* Created by lwzhang on 2/25/15.
*/
public class FuzzyCorrector {

    private SimilarDigitMap similarDigitMap = SimilarDigitMap.getInstance();
    private List<String> validAccountNumberList = Lists.newArrayList();


    //TODO: Confirm whether need to display all alternative accountNumber options
    public List<String> getValidAccountNumbers(String accountNumber) {
        generateAlternativeAccountNumber(accountNumber);
        return validAccountNumberList;
    }

    private void generateAlternativeAccountNumber(String accountNumber) {
        for (int index = 0; index < accountNumber.length(); index++) {
            String currentDigit = String.valueOf(accountNumber.charAt(index));
            Collection<String> alternativeDigits = similarDigitMap.getAlternativeDigits(currentDigit);
            for (String alternativeDigit : alternativeDigits) {
                String alternativeAccountNumber = accountNumber.substring(0, index) +
                        alternativeDigit +
                        accountNumber.substring(index + 1);
                checkOriginalAccountNumber(alternativeAccountNumber);
            }
        }
    }

    private void checkOriginalAccountNumber(String accountNumber) {
        if (AccountNumberValidator.validate(accountNumber)) {
            validAccountNumberList.add(accountNumber);
        }
    }
}
