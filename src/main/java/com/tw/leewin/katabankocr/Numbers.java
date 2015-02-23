package com.tw.leewin.katabankocr;

/**
 * Created by leewin on 15/2/21.
 */
public enum Numbers {
    ZERO(" _ | ||_|", "0"),
    ONE("     |  |", "1"),
    TWO(" _  _||_ ", "2"),
    THREE(" _  _| _|", "3"),
    FOUR("   |_|  |", "4"),
    FIVE(" _ |_  _|", "5"),
    SIX(" _ |_ |_|", "6"),
    SEVEN(" _   |  |", "7"),
    EIGHT(" _ |_||_|", "8"),
    NINE(" _ |_| _|", "9");

    private String symbols;
    private String number;

    Numbers(String symbols, String number) {
        this.symbols = symbols;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void mber(String number) {
        this.number = number;
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }
}
