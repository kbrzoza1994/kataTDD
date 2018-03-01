package org.kata.bank;

public class AccountHolder {
    private String number;
    private String code;
    private String[] possibleNumbers;

    public AccountHolder(String number, String code, String[] possibleNumbers) {
        this.number = number;
        this.code = code;
        this.possibleNumbers = possibleNumbers;
    }

    public String getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }

    public String[] getPossibleNumbers() {
        return possibleNumbers;
    }
}
