package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
import com.tw.leewin.katabankocr.domain.AccountNumber;

import java.util.List;

/**
 * Created by lwzhang on 2/24/15.
 */
public final class AccountNumberValidator {

    private final String accountNumber;

    public AccountNumberValidator(String accountNumber) {

        this.accountNumber = accountNumber;
    }

    private static final int DIVISOR = 11;

    public boolean validate() {
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
