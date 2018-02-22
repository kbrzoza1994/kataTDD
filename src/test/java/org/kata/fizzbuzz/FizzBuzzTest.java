package org.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzTest {

    @Test
    public void startValueIs1(){
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.GenerateFizzBuzz();
        System.out.println(result.charAt(0));
        Assert.assertTrue(result.charAt(0)=='1');
    }

    @Test
    public void firstFizzAtPlace2(){
        List<String> listOfResults = getListOfStrings();

        Assert.assertFalse(listOfResults.get(0).equals("fizz"));
        Assert.assertFalse(listOfResults.get(1).equals("fizz"));
        Assert.assertTrue(listOfResults.get(2).equals("fizz"));
    }

    @Test
    public void firstBuzzAtPlace4(){
        List<String> listOfResults = getListOfStrings();

        Assert.assertFalse(listOfResults.get(0).equals("buzz"));
        Assert.assertFalse(listOfResults.get(1).equals("buzz"));
        Assert.assertFalse(listOfResults.get(2).equals("buzz"));
        Assert.assertFalse(listOfResults.get(3).equals("buzz"));
        Assert.assertTrue(listOfResults.get(4).equals("buzz"));
    }

    @Test
    public void firstFizzBuzzAtPlace14(){
        List<String> listOfResults = getListOfStrings();

        for (int i = 0; i < 14; i++) {
            Assert.assertFalse(listOfResults.get(i).equals("fizzbuzz"));
        }
        Assert.assertTrue(listOfResults.get(14).equals("fizzbuzz"));
    }

    @Test
    public void startsWithOneCommaTwoCommaFizz(){
        List<String> listOfResults = getListOfStrings();

            Assert.assertEquals(listOfResults.get(0), "1");
            Assert.assertEquals(listOfResults.get(1), "2");
            Assert.assertEquals(listOfResults.get(2), "fizz");

    }

    @Test
    public void endsWithNinenyEightComaFizzComaBuzz(){
        List<String> listOfResults = getListOfStrings();

        Assert.assertEquals(listOfResults.get(97), "98");
        Assert.assertEquals(listOfResults.get(98), "fizz");
        Assert.assertEquals(listOfResults.get(99), "buzz");
    }

    private List<String> getListOfStrings() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String res = fizzBuzz.GenerateFizzBuzz();
        return Arrays.asList(res.split(","));
    }

}
