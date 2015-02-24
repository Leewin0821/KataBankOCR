package com.tw.leewin.katabankocr;

import java.util.List;

/**
 * Created by lwzhang on 2/24/15.
 */
public class SymbolArray {

    public static final int ACCOUNT_ROW_NUMBER = 3;
    public static final int ACCOUNT_COLUMN_NUMBER = 27;

    private char[][] symbolArray = new char[ACCOUNT_ROW_NUMBER][ACCOUNT_COLUMN_NUMBER];

    public SymbolArray() {
        initSymbolArray();
    }

    private void initSymbolArray() {
        for (int rowIndex = 0; rowIndex < ACCOUNT_ROW_NUMBER; rowIndex++) {
            for (int columnIndex = 0; columnIndex < ACCOUNT_COLUMN_NUMBER; columnIndex++) {
                symbolArray[rowIndex][columnIndex] = ' ';
            }
        }
    }

    public void setSymbol(int row, int column, char symbol) {
        symbolArray[row][column] = symbol;
    }

    public char getSymbol(int row, int column) {
        return symbolArray[row][column];
    }

    public void saveSymbols(List<String> symbolsList) {
        int rowIndex = -1;
        for (String inputLine : symbolsList) {
            rowIndex++;
            for (int columnIndex = 0; columnIndex < inputLine.length(); columnIndex++) {
                char character = inputLine.charAt(columnIndex);
                setSymbol(rowIndex, columnIndex, character);
            }
        }

    }
}
