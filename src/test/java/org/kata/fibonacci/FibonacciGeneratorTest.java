package org.kata.fibonacci;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FibonacciGeneratorTest {


    @Test
    public void shouldReturnNullWhenTryToGetLessThan8Elements(){
        List<BigInteger> fibonacci = FibonacciGenerator.GenerateFor(4);

        Assert.assertNull(fibonacci);
    }

    @Test
    public void shouldReturnNullWhenTryToGetMoreThan50Elements(){
        List<BigInteger> fibonacci = FibonacciGenerator.GenerateFor(51);

        Assert.assertNull(fibonacci);
    }

    @Test
    public void shouldReturnExactNumberOfElementsThatWasPassedByUser(){
        int quantity = 19;

        List<BigInteger> fibonacci = FibonacciGenerator.GenerateFor(quantity);

        Assert.assertEquals(quantity, fibonacci.size());
    }

    @Test
    public void generateTheRightValuesForMaximumFibonacciSequence(){
        int quantity = 49;

        List<BigInteger> fibonacci = FibonacciGenerator.GenerateFor(quantity);
        List<BigInteger> fibonacciCheck = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            if (i==0)
                fibonacciCheck.add(new BigInteger("0"));
            else if (i==1)
                fibonacciCheck.add(new BigInteger("1"));
            else{
                fibonacciCheck.add(fibonacciCheck.get(i-1).add(fibonacciCheck.get(i-2)));
            }
            Assert.assertEquals(Objects.requireNonNull(fibonacci).get(i),fibonacciCheck.get(i));
        }
    }
}
