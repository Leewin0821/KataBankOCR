package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by lwzhang on 2/24/15.
 */
public class AccountNumberValidator {

    public static final int DIVISOR = 11;

    public boolean validate(String accountNumber) {
        int multiple = 9;
        int sum = 0;
        for (int number : createDigitsListGivenAccountNumber(accountNumber)) {
            sum += number * multiple;
            multiple--;
        }
        return sum % DIVISOR == 0;
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
