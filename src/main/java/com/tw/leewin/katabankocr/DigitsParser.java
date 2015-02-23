package com.tw.leewin.katabankocr;

import java.io.*;

/**
 * Created by leewin on 15/2/19.
 */
public class DigitsParser {

    private static final int ACCOUNT_ROW_NUMBER = 3;
    private static final int ACCOUNT_COLUMN_NUMBER = 27;

    private char[][] symbolArray = new char[ACCOUNT_ROW_NUMBER][ACCOUNT_COLUMN_NUMBER];
    private SymbolToNumberMapper mapper = new SymbolToNumberMapper();

    public DigitsParser() {
    }

    public String parse(String filePath) throws IOException {
        initSymbolArray();
        initFile(filePath);
        return parseSymbols();
    }

    private String parseSymbols() {
        String symbols = "";
        for (int columnIndex = 0; columnIndex < ACCOUNT_COLUMN_NUMBER; columnIndex = columnIndex + 3) {
            String symbol = "";
            for (int rowIndex = 0; rowIndex < ACCOUNT_ROW_NUMBER; rowIndex++) {
                symbol += "" + symbolArray[rowIndex][columnIndex] +
                        symbolArray[rowIndex][columnIndex + 1] +
                        symbolArray[rowIndex][columnIndex + 2];
            }
            for (int index = 0; index < Numbers.values().length; index++) {
//                if (mapper.containsSymbol(symbol)){
//                    symbols += mapper.getNumber(symbol);
//                } else {
//                    symbols += "? ILL";
//                }
                if (symbol.equals(Numbers.values()[index].getSymbols())) {
                    symbols += Numbers.values()[index].getNumber();
                }
            }
        }
        return symbols;
    }

    private void initFile(String filePath) throws IOException {
        File file = new File(filePath);
        int rowIndex = -1;
        String inputLine = "";
        if (file.isFile() && file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((inputLine = bufferedReader.readLine()) != null) {
                rowIndex++;
                System.out.println(inputLine);
                for (int columnIndex = 0; columnIndex < inputLine.length(); columnIndex++) {
                    symbolArray[rowIndex][columnIndex] = inputLine.charAt(columnIndex);
                }
            }
            bufferedReader.close();
        } else {
            System.out.println("No such file!");
        }
    }

    private void initSymbolArray() {
        for (int rowIndex = 0; rowIndex < ACCOUNT_ROW_NUMBER; rowIndex++) {
            for (int columnIndex = 0; columnIndex < ACCOUNT_COLUMN_NUMBER; columnIndex++) {
                symbolArray[rowIndex][columnIndex] = ' ';
            }
        }
    }
}
