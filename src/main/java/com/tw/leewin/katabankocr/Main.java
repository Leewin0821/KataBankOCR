package com.tw.leewin.katabankocr;

/**
 * Created by lwzhang on 3/2/15.
 */
public class Main {

    private static final String FILE_PATH = "/Users/lwzhang/IdeaProjects/KataBankOCR/src/main/rescources/ocr_text_file.txt";

    public static void main(String [] args){
        BankOCR bankOCR = new BankOCR();
        System.out.println(bankOCR.printAccountNumber(FILE_PATH));
    }
}
