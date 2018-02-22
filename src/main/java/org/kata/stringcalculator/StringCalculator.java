package org.kata.stringcalculator;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static int getSum(String test) throws NegativesNotAllowedException {
        int sum = 0;

        if (test.isEmpty())
            return 0;

        String temp = test.replaceAll("[^\\d-]",",");
        List<String> listOfTestValues = Arrays.asList(temp.split(","));

        for (String value: listOfTestValues) {
            if (!value.isEmpty()) {
                if (value.charAt(0)!='-') {
                    if (value.length()<4)
                    sum += Integer.valueOf(value);
                }
                else
                        throw new NegativesNotAllowedException("negatives not allowed");

            }
        }
        return sum;
    }
}
