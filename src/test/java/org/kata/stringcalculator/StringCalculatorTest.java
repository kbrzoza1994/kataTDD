package org.kata.stringcalculator;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnZeroWhenEmptyStringPassed() throws NegativesNotAllowedException {
        String test = "";

        Assert.assertEquals(StringCalculator.getSum(test), 0);
    }

    @Test
    public void shouldReturnPassedValueWhenOnlyOneNumberPassed() throws NegativesNotAllowedException {
        String test = "14";

        Assert.assertEquals(StringCalculator.getSum(test), Integer.parseInt(test));
    }

    @Test
    public void shouldAddTwoNumbersSeparatedByComma() throws NegativesNotAllowedException {
        String test = "14,14";

        Assert.assertEquals(StringCalculator.getSum(test), 28);
    }

    @Test
    public void shouldAddMoreThanTwoNumbersSeparatedByCommas() throws NegativesNotAllowedException {
        String test = "14,14,14,14,14,14";

        Assert.assertEquals(StringCalculator.getSum(test), 84);
    }

    @Test
    public void shouldAddAnyValuesSeparatedByAnyDelimiter() throws NegativesNotAllowedException {
        String test = "14''''''14....14/////14/;['14,,14";

        Assert.assertEquals(StringCalculator.getSum(test), 84);
    }

    @Test
    public void shouldReturnMessageWhenPassNegativeParameter() throws NegativesNotAllowedException {
        String test = "14/////////////////14****************14**-14++++++++++14..............14";

        exception.expect(NegativesNotAllowedException.class);
        exception.expectMessage("negatives not allowed");

        StringCalculator.getSum(test);
    }

    @Test
    public void numbersGraterThanOneThousandShouldBeIgnored() throws NegativesNotAllowedException {
        String test = "14/////////////////14***********14*****14**1414++++++++++14..............14";

        Assert.assertEquals(StringCalculator.getSum(test), 84);
    }
}
