package com.tw.leewin.katabankocr;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lwzhang on 2/25/15.
 */
public class SimilarDigitMap {
    private Multimap<String, String> similarDigitMap = ArrayListMultimap.create();

    private static SimilarDigitMap ourInstance = new SimilarDigitMap();

    public static SimilarDigitMap getInstance() {
        return ourInstance;
    }

    private SimilarDigitMap() {
        init();
    }

    private void init() {
        similarDigitMap.put("0", "8");
        similarDigitMap.put("1", "7");
        similarDigitMap.put("3", "3");
        similarDigitMap.put("3", "9");
        similarDigitMap.put("5", "6");
        similarDigitMap.put("5", "9");
        similarDigitMap.put("6", "8");
        similarDigitMap.put("6", "5");
        similarDigitMap.put("7", "1");
        similarDigitMap.put("8", "0");
        similarDigitMap.put("8", "6");
        similarDigitMap.put("8", "9");
        similarDigitMap.put("9", "8");
        similarDigitMap.put("9", "3");
        similarDigitMap.put("9", "5");
    }

    public Collection<String> getAlternativeDigits(String originNumber) {
        return similarDigitMap.get(originNumber);
    }
}
