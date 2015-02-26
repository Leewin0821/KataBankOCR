package com.tw.leewin.katabankocr;

import com.tw.leewin.katabankocr.domain.AccountNumber;

import java.util.List;

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
            // TODO handle '?'
            List<String> legibleNumbers = new SymbolCorrector().recogniseAccountNumber(accountNumber);

        }
        if (!AccountNumberValidator.validate(accountNumberMessage)){
            List<String> validAccountNumbers = new AccountNumberCorrector().getValidAccountNumbers(accountNumberMessage);
            if (validAccountNumbers.size() == 1){
                return validAccountNumbers.get(0);
            } else if (validAccountNumbers.size() == 0){
                accountNumberMessage += ERR_SUFFIX;
                return accountNumberMessage;
            } else {
                String optionsAccountNumbers = " AMB "+validAccountNumbers.toString();
                accountNumberMessage += optionsAccountNumbers;
                return accountNumberMessage;
            }
        } else {
            return accountNumberMessage;
        }
    }
}
