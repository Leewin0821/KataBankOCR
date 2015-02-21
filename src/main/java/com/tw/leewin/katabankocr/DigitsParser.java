package com.tw.leewin.katabankocr;

import java.io.*;

/**
 * Created by leewin on 15/2/19.
 */
public class DigitsParser {

    public DigitsParser() {
    }

    public String parse(String filePath) throws IOException {
        File file = new File(filePath);
        String inputLine = "";
        String result = "";
        if (file.isFile() && file.exists()){
            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((inputLine = bufferedReader.readLine()) != null){
                result += inputLine;
            }
            bufferedReader.close();
        } else {
            System.out.println("No such file!");
        }
        return result;
    }
}
