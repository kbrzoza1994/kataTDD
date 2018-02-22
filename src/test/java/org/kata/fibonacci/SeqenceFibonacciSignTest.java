package org.kata.fibonacci;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class SeqenceFibonacciSignTest {

    @Test
    public void shouldReturnNullWhenLessThan1Passed(){
        BigInteger value = SequenceFibonacciSign.GetValue(0);

        Assert.assertNull(value);
    }

    @Test
    public void shouldReturn1ForParameter2andParameter3(){
        Assert.assertEquals(SequenceFibonacciSign.GetValue(2),new BigInteger("1"));
        Assert.assertEquals(SequenceFibonacciSign.GetValue(3),new BigInteger("1"));
    }

    @Test
    public void shouldReturn34ForParameter10(){
        Assert.assertEquals(SequenceFibonacciSign.GetValue(10), new BigInteger("34"));
    }

    @Test
    public void checkIfValueForParameter101IsCorrect(){
        Assert.assertEquals(SequenceFibonacciSign.GetValue(101), new BigInteger("354224848179261915075"));
    }
}
