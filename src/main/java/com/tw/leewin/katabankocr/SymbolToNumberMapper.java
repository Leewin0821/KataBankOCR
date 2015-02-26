package com.tw.leewin.katabankocr;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by leewin on 15/2/24.
 */
public class SymbolToNumberMapper {
    private BiMap<String, String> multiMap = HashBiMap.create();

    public SymbolToNumberMapper() {
        initMultiMap();
    }

    private void initMultiMap() {
        for (Numbers numbers : Numbers.values()) {
            String symbol = numbers.getSymbols();
            String number = numbers.getNumber();
            multiMap.put(symbol, number);
        }
    }

    public boolean containsSymbol(String symbol) {
        return multiMap.containsKey(symbol);
    }

    public String getNumber(String symbol) {
        return multiMap.get(symbol);
    }

}
