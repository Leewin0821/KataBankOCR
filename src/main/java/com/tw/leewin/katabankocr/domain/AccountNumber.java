package com.tw.leewin.katabankocr.domain;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

import static com.tw.leewin.katabankocr.DigitsParser.ILLEGIBLE_SYMBOL;

/**
 * Created by lwzhang on 2/24/15.
 */
public class AccountNumber {

    public AccountNumber() { }

    public AccountNumber(Map<Integer, String> illegibleSymbolMap, String accountNumber) {
        this.illegibleSymbolMap = illegibleSymbolMap;
        this.accountNumber = accountNumber;
    }

    public Map<Integer, String> getIllegibleSymbolMap() {
        return illegibleSymbolMap;
    }

    private Map<Integer, String> illegibleSymbolMap = Maps.newHashMap();

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

    public void setIllegibleSymbolMap(Map<Integer, String> illegibleSymbolMap) {
        this.illegibleSymbolMap = illegibleSymbolMap;
    }
}
