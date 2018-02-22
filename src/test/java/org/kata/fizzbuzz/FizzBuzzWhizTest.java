package org.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzWhizTest {

    @Test
    public void firstElementshouldBeOne(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(0), "1");
    }

    @Test
    public void secondElementShouldBeWhiz(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(1), "whiz");
    }

    @Test
    public void ThirdElementShouldBeFizzWhiz(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(2), "fizzwhiz");
    }

    @Test
    public void FourthValueShouldBeFour(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(3), "4");
    }

    @Test
    public void shouldStartWithOneCommaWhizCommaFizzWhizzCommaFour(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(0), "1");
        Assert.assertEquals(listOfStrings.get(1), "whiz");
        Assert.assertEquals(listOfStrings.get(2), "fizzwhiz");
        Assert.assertEquals(listOfStrings.get(3), "4");
    }

    @Test
    public void shouldEndWithWhizCommaNinetyEightCommaFizzCommaBuzz(){
        List<String> listOfStrings = getListOfStrings();

        Assert.assertEquals(listOfStrings.get(96), "whiz");
        Assert.assertEquals(listOfStrings.get(97), "98");
        Assert.assertEquals(listOfStrings.get(98), "fizz");
        Assert.assertEquals(listOfStrings.get(99), "buzz");
    }

    private List<String> getListOfStrings() {
        FizzBuzzWhiz fizzBuzzWhiz = new FizzBuzzWhiz();

        return Arrays.asList(fizzBuzzWhiz.Generate().split(","));
    }
}
