package org.kata.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator {

    public static List<BigInteger> GenerateFor(int i) {
        if (i<8 || i>50)
            return null;

        List<BigInteger> fibonacci = new ArrayList<>();
        fibonacci.add(new BigInteger("0"));
        fibonacci.add(new BigInteger("1"));

        for (int j = 2; j < i; j++) {
            fibonacci.add(fibonacci.get(j-2).add(fibonacci.get(j-1)));
        }

        return fibonacci;
    }
}
