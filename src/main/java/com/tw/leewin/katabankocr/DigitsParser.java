package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by leewin on 15/2/19.
 */
public class DigitsParser {

    private LinkedList<String> symbolList = Lists.newLinkedList();

    public DigitsParser() {
    }

    public int parse(String filePath) throws IOException {
        File file = new File(filePath);
        String inputLine = "";
        if (file.isFile() && file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((inputLine = bufferedReader.readLine()) != null) {
                symbolList.add(inputLine);
            }
            bufferedReader.close();
        } else {
            System.out.println("No such file!");
        }
        String symbols = "";
        for (String symbol : symbolList){
            symbols += symbol;
        }
        for (int index=0; index<Numbers.values().length; index++){
            if (symbols.equals(Numbers.values()[index].getSymbols())){
                return Numbers.values()[index].getNumber();
            }
        }
        return -1;
    }
}
