package org.kata.wordcounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordCounter {
    public static HashMap<String, Integer> Count(String test) {
        HashMap<String, Integer> mapOfWords = new HashMap<>();
        if (test.isEmpty())
        return mapOfWords;

        String temp = test.replaceAll("[^a-zA-Z]", ",");
        List<String> listOfStrings = Arrays.asList(temp.split(","));

        for (String value: listOfStrings) {
            if (!value.isEmpty()){
                if (mapOfWords.containsKey(value)){
                    Integer val = mapOfWords.get(value)+1;
                    mapOfWords.replace(value, val);
                }else{
                    mapOfWords.put(value, 1);
                }
            }
        }
        return mapOfWords;

    }
}
