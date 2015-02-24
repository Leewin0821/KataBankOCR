package com.tw.leewin.katabankocr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwzhang on 2/24/15.
 */
public class DigitsFileReader {
    private static DigitsFileReader ourInstance = new DigitsFileReader();

    public static DigitsFileReader getInstance() {
        return ourInstance;
    }

    private DigitsFileReader() {
    }

    public List<String> readDigitFile(String filePath) throws IOException {
        File file = new File(filePath);
        String inputLine = "";
        ArrayList<String> list = new ArrayList<String>();
        if (file.isFile() && file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
                list.add(inputLine);
            }
            bufferedReader.close();
        } else {
            System.out.println("No such file!");
        }
        return list;
    }

}
