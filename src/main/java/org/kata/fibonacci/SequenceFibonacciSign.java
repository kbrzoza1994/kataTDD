package org.kata.fibonacci;

import java.math.BigInteger;

public class SequenceFibonacciSign {
    public static BigInteger GetValue(int i) {
        if (i<1)
            return null;
        else if (i==1)
            return new BigInteger("0");
        else if (i==2)
            return new BigInteger("1");
        else{
            BigInteger var1 = new BigInteger("0");
            BigInteger var2 = new BigInteger("1");
            BigInteger res = new BigInteger("1");
            for (int j = 0; j < i-3; j++) {
                var1 = var2;
                var2 = res;
                res = var1.add(var2);
            }
            return res;
        }
    }
}
