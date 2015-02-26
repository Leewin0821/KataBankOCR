package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by lwzhang on 2/25/15.
 */
public class FuzzyCorrector {

    private SimilarDigitMap similarDigitMap = SimilarDigitMap.getInstance();
    private List<String> validAccountNumberSet = Lists.newLinkedList();

    public List<String> getValidAccountNumbers(String accountNumber) {
        generateAlternativeAccountNumber(accountNumber);
        return validAccountNumberSet;
    }

    private void generateAlternativeAccountNumber(String accountNumber) {
        for (int index = 0; index < accountNumber.length(); index++) {
            String currentDigit = String.valueOf(accountNumber.charAt(index));
            Collection<String> alternativeDigits = similarDigitMap.getAlternativeDigits(currentDigit);
            for (String alternativeDigit : alternativeDigits) {
                String alternativeAccountNumber = accountNumber.substring(0, index) +
                        alternativeDigit +
                        accountNumber.substring(index + 1);
                checkAccountNumberValidation(alternativeAccountNumber);
            }
        }
    }

    private void checkAccountNumberValidation(String accountNumber) {
        if (AccountNumberValidator.validate(accountNumber)) {
            validAccountNumberSet.add(accountNumber);
        }
    }
}
