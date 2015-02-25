package com.tw.leewin.katabankocr;

import com.tw.leewin.katabankocr.domain.AccountNumber;

/**
 * Created by lwzhang on 2/24/15.
 */
public class BankOCR {

    private static final String ILL_SUFFIX = "  ILL";
    private static final String ERR_SUFFIX = "  ERR";

    public String printAccountNumber(String filePath) {

        AccountNumber accountNumber = new DigitsParser().parse(filePath);

        String accountNumberMessage = accountNumber.getAccountNumber();

        if (accountNumber.isIllegible()){
            accountNumberMessage += ILL_SUFFIX;
            return accountNumberMessage;
        }
//        String validAccountNumber = FuzzyCorrector.getValidAccountNumber(accountNumber.getAccountNumber());
//        if (validAccountNumber == null){
//            accountNumberMessage += ERR_SUFFIX;
//        } else {
//            accountNumberMessage += validAccountNumber;
//        }
        return accountNumberMessage;
    }
}
