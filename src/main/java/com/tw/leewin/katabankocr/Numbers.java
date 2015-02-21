package com.tw.leewin.katabankocr;

/**
 * Created by leewin on 15/2/21.
 */
public enum Numbers {
    ONE("  |  |", 1), FOUR("|_|  |", 4);

    private String symbols;
    private int number;

    Numbers(String symbols, int number) {
        this.symbols = symbols;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }
}
