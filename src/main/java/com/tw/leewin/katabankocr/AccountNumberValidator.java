package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by lwzhang on 2/24/15.
 */
public class AccountNumberValidator {

    private SimilarDigitMap similarDigitMap = SimilarDigitMap.getInstance();
    private List<String> validAccountNumberList = Lists.newArrayList();

    public static final int DIVISOR = 11;

    //TODO: Confirm whether need to display all alternative accountNumber options
    public String getValidAccountNumber(String accountNumber) {
        calculateCheckSum(accountNumber);
        if (validAccountNumberList.size() != 0) {
            return accountNumber;
        } else {
            generateAlternativeAccountNumber(accountNumber);
        }
        return validAccountNumberList.size() == 0 ? null : validAccountNumberList.get(0);
    }

    private void generateAlternativeAccountNumber(String accountNumber) {
        for (int index = 0; index < accountNumber.length(); index++) {
            String currentDigit = String.valueOf(accountNumber.charAt(index));
            Collection<String> alternativeDigits = similarDigitMap.getAlternativeDigits(currentDigit);
            for (String alternativeDigit : alternativeDigits) {
                String alternativeAccountNumber = accountNumber.substring(0, index) +
                                                  alternativeDigit +
                                                  accountNumber.substring(index + 1);
                calculateCheckSum(alternativeAccountNumber);
            }
        }
    }

    private void calculateCheckSum(String accountNumber) {
        int multiple = 9;
        int sum = 0;
        for (int number : createDigitsListGivenAccountNumber(accountNumber)) {
            sum += number * multiple;
            multiple--;
        }
        if (sum % DIVISOR == 0) {
            validAccountNumberList.add(accountNumber);
        }
    }

    private List<Integer> createDigitsListGivenAccountNumber(String accountNumber) {
        List<Integer> numberList = Lists.newArrayList();
        for (int index = 0; index < accountNumber.length(); index++) {
            int number = Integer.parseInt(String.valueOf(accountNumber.charAt(index)));
            numberList.add(number);
        }
        return numberList;
    }
}
