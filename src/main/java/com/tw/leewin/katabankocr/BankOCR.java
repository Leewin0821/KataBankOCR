package com.tw.leewin.katabankocr;

import com.google.common.collect.Lists;
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
            return printAccountNumberWithIllegibleSymbol(accountNumber);
        } else if (!new AccountNumberValidator(accountNumberMessage).validate()){
            return printAccountNumberWithWrongValidation(accountNumber);
        }
        return accountNumberMessage;
    }

    private String printAccountNumberWithWrongValidation(AccountNumber accountNumber) {
        String accountNumberMessage = accountNumber.getAccountNumber();
        List<String> validAccountNumbers = new AccountNumberCorrector().getValidAccountNumbers(accountNumberMessage);
        return preparePrintFormat(accountNumberMessage, validAccountNumbers, ERR_SUFFIX);
    }

    private String printAccountNumberWithIllegibleSymbol(AccountNumber accountNumber) {
        List<String> validNumberList = Lists.newArrayList();
        if (accountNumber.isIllegible()){
            List<String> legibleNumbers = new SymbolCorrector().recogniseAccountNumber(accountNumber);
            for (String legibleNumber : legibleNumbers){
                if (new AccountNumberValidator(legibleNumber).validate()){
                    validNumberList.add(legibleNumber);
                }
            }
        }
        return preparePrintFormat(accountNumber.getAccountNumber(),validNumberList, ILL_SUFFIX);
    }

    private String preparePrintFormat(String accountNumberMessage, List<String> validAccountNumbers, String type) {
        if (validAccountNumbers.size() == 1){
            return validAccountNumbers.get(0);
        } else if (validAccountNumbers.size() == 0){
            accountNumberMessage += type;
            return accountNumberMessage;
        } else {
            String optionsAccountNumbers = " AMB "+validAccountNumbers.toString();
            accountNumberMessage += optionsAccountNumbers;
            return accountNumberMessage;
        }
    }
}
