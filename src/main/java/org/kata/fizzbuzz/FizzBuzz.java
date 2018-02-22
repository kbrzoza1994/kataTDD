package org.kata.fizzbuzz;

import java.lang.reflect.GenericArrayType;
import java.util.List;

public class FizzBuzz {
    public String GenerateFizzBuzz() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 101; i++) {
            sb.append(isFizzBuzz(i));
            if (i<100)
                sb.append(",");
        }

        return sb.toString();
    }

    private String isFizzBuzz(int i) {
        if (isDivideByThree(i) && isDivideByFive(i))
            return "fizzbuzz";
        if (isDivideByThree(i))
            return "fizz";
        if (isDivideByFive(i))
            return "buzz";
        return String.valueOf(i);
    }

    private boolean isDivideByFive(int i) {
        return i%5==0;
    }

    private boolean isDivideByThree(int i) {
        return i%3==0;
    }

}
