package org.kata.fizzbuzz;

public class FizzBuzzWhiz {
    public String Generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 101; i++) {
            sb.append(isFizzBuzzWhiz(i));
            if (i < 100)
                sb.append(",");
        }

        return sb.toString();
    }

    private String isFizzBuzzWhiz(int i) {
        if (isPrime(i))
            return isFizzBuzz(i) + "whiz";
        else{
            String res = isFizzBuzz(i);
            if (res.isEmpty())
                return String.valueOf(i);
            else
                return res;
        }
    }

    private String isFizzBuzz(int i) {
        if (isDivideByThree(i) && isDivideByFive(i))
            return "fizzbuzz";
        if (isDivideByThree(i))
            return "fizz";
        if (isDivideByFive(i))
            return "buzz";
        return "";
    }

    private boolean isDivideByFive(int i) {
        return i % 5 == 0;
    }

    private boolean isDivideByThree(int i) {
        return i % 3 == 0;
    }

    private boolean isPrime(int i) {
        if (i == 0 || i == 1)
            return false;
        else if (i == 2)
            return true;
        else {
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    return false;
            }
            return true;
        }
    }
}
