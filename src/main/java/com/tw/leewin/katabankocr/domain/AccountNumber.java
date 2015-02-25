package com.tw.leewin.katabankocr.domain;

import static com.tw.leewin.katabankocr.DigitsParser.ILLEGIBLE_SYMBOL;

/**
 * Created by lwzhang on 2/24/15.
 */
public class AccountNumber {
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private String accountNumber;

    public boolean isIllegible() {
        return accountNumber.contains(ILLEGIBLE_SYMBOL);
    }
}
