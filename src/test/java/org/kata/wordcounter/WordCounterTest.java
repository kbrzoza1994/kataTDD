package org.kata.wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class WordCounterTest {

    @Test
    public void emptyStringShouldReturnEmptyMap(){
        String test = "";

        Assert.assertEquals(WordCounter.Count(test), new HashMap<>());
    }

    @Test
    public void shouldReturnOneRecordWhenOneWordAdded(){
        String test = "test";

        Assert.assertEquals(WordCounter.Count(test).get("test"), new Integer(1));
    }

    @Test
    public void shouldReturnTwoWordsWhenTwoWordsSeparatedByComaAdded(){
        String test = "test,bruma";

        Assert.assertEquals(WordCounter.Count(test).get("test"), new Integer(1));
        Assert.assertEquals(WordCounter.Count(test).get("bruma"), new Integer(1));
    }

    @Test
    public void shouldReturnTwoWordsWhenTwoWordsSeparatedAnyDelimiterAdded(){
        String test = "test,234234,******bruma";

        Assert.assertEquals(WordCounter.Count(test).get("test"), new Integer(1));
        Assert.assertEquals(WordCounter.Count(test).get("bruma"), new Integer(1));
    }

    @Test
    public void shouldCountNumberOfTimesWordIsPassed(){
        String test = "test,..,.,.test.,,.,.test***********test++++test";

        Assert.assertEquals(WordCounter.Count(test).get("test"), new Integer(5));
    }

    @Test
    public void shouldCountVariousNumberOfDifferentWordsPassed(){
        String test = "**bruma*****test***bruma**.........alaska....janusz.///////bruma//test//''bruma'''''''';test;;;;;;bruma;;;;;;alaska;;++++++test++++bruma+++////////test/";

        Assert.assertEquals(WordCounter.Count(test).get("bruma"), new Integer(6));
        Assert.assertEquals(WordCounter.Count(test).get("janusz"), new Integer(1));
        Assert.assertEquals(WordCounter.Count(test).get("test"), new Integer(5));
        Assert.assertEquals(WordCounter.Count(test).get("alaska"), new Integer(2));
    }

    @Test
    public void shouldReturnFourOutputsWhenFourWordsPassed(){
        String test = "**bruma*****test***bruma**.........alaska....janusz.///////bruma//test//''bruma'''''''';test;;;;;;bruma;;;;;;alaska;;++++++test++++bruma+++////////test/";

        Assert.assertEquals(WordCounter.Count(test).size(), 4);
    }
}
