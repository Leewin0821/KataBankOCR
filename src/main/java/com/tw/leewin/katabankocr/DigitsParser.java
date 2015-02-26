package com.tw.leewin.katabankocr;

import com.google.common.collect.Maps;
import com.tw.leewin.katabankocr.domain.AccountNumber;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.tw.leewin.katabankocr.SymbolArray.ACCOUNT_COLUMN_NUMBER;
import static com.tw.leewin.katabankocr.SymbolArray.ACCOUNT_ROW_NUMBER;

/**
 * Created by leewin on 15/2/19.
 */
public class DigitsParser {

    public static final String ILLEGIBLE_SYMBOL = "?";
    private SymbolArray symbolArray = new SymbolArray();
    private SymbolToNumberMapper mapper = new SymbolToNumberMapper();
    private AccountNumber accountNumber = new AccountNumber();

    public AccountNumber parse(String filePath) {
        List<String> symbolsList = DigitsFileReader.getInstance().readDigitFile(filePath);
        symbolArray.saveSymbols(symbolsList);
        return parseSymbols();
    }

    private AccountNumber parseSymbols() {
        String symbols = "";
        for (int columnIndex = 0; columnIndex < ACCOUNT_COLUMN_NUMBER; columnIndex = columnIndex + 3) {
            String symbol = "";
            for (int rowIndex = 0; rowIndex < ACCOUNT_ROW_NUMBER; rowIndex++) {
                symbol += "" + symbolArray.getSymbol(rowIndex, columnIndex) +
                        symbolArray.getSymbol(rowIndex, columnIndex + 1) +
                        symbolArray.getSymbol(rowIndex, columnIndex + 2);
            }
            if (mapper.containsSymbol(symbol)){
                symbols += mapper.getNumber(symbol);
            } else {
                symbols += ILLEGIBLE_SYMBOL;
            }
        }
        accountNumber.setAccountNumber(symbols);
        return accountNumber;
    }

}
