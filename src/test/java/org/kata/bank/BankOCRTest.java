package org.kata.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.transfer.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankOCRTest {
    BankOCR bankOCR;

    @Before
    public void setUp(){
        bankOCR = new BankOCR();
    }

    @Test
    public void shouldReadAllZerosFromInput() {
        String testString = "000000000";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString,testOutput);
    }

    @Test
    public void shouldReadAllOnesFromInput(){
        String testString = "111111111";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllTwosFromInput(){
        String testString = "222222222";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }
    @Test
    public void shouldReadAllThreesFromInput(){
        String testString = "333333333";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllFoursFromInput(){
        String testString = "444444444";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllFivesFromInput(){
        String testString = "555555555";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllSixesFromInput(){
        String testString = "666666666";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllSevensFromInput(){
        String testString = "777777777";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllEightsFromInput(){
        String testString = "888888888";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadAllNinesFromInput(){
        String testString = "999999999";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }

    @Test
    public void shouldReadSeriesFromOneToNine(){
        String testString = "123456789";
        String testInput = examples(testString);
        String testOutput = bankOCR.convertToString(testInput);

        Assert.assertEquals(testString, testOutput);
    }


    @Test
    public void shouldHandleMoreThanOneInput(){
        String testString = "000000000 111111111 222222222 333333333 444444444 555555555 666666666 777777777 888888888 999999999";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 10; i++) {
            int j = 10*i;
            sb.append(examples(testString.substring(j, j + 9))).append(" ");
        }
        String testOutput = bankOCR.convertToString(sb.toString());

        Assert.assertEquals(testOutput, testString);
    }

    @Test
    public void shouldReturnPassedInputAsElementInListOfLongs(){
        String testString = "000000000";
        Long testNumber = Long.valueOf(testString);
        String testInput = examples(testString);
        List<Long> listOfNumbers = bankOCR.convertToListOfLongs(testInput);

        Assert.assertTrue(listOfNumbers.size()==1);
        Assert.assertEquals(listOfNumbers.get(0), testNumber);
    }

    @Test
    public void shouldReturnPassedNumbersAsListOfLongs(){
        String testString = "000000000 111111111 222222222 333333333 444444444 555555555 666666666 777777777 888888888 999999999";
        StringBuilder sb = new StringBuilder("");
        List<Long> listOfTestValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j = 10*i;
            sb.append(examples(testString.substring(j, j + 9)));
            listOfTestValues.add(Long.valueOf(testString.substring(j, j+9)));
        }

        List<Long> listOfNumbers = bankOCR.convertToListOfLongs(sb.toString());

        Assert.assertEquals(listOfNumbers.size(), listOfTestValues.size());
        for (int i = 0; i<listOfTestValues.size(); i++) {
            Assert.assertEquals(listOfTestValues.get(i), listOfNumbers.get(i));
        }
    }

    @Test
    public void shouldReturnOnlyValidNumbers(){
        String testString = "000000051";
        String testString1 = "000040053";

        List<Long> listOfTestValues = new ArrayList<>();
        listOfTestValues.add(Long.valueOf(testString));
        listOfTestValues.add(Long.valueOf(testString1));

        String testStringAsLine =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || || ||_   |" +
                "|_||_||_||_||_||_||_| _|  |" +
                "                           ";
        String testStringAsLine1 =
                " _  _  _  _     _  _  _  _ " +
                "| || || || ||_|| || ||_  _|" +
                "|_||_||_||_|  ||_||_| _| _|" +
                "                           ";
        String testStringAsLine2 =
                " _  _  _  _     _  _  _    " +
                "| || || || |  || || ||_   |" +
                "|_||_||_||_|  ||_||_| _|  |" +
                "                           ";
        String testStringAsLine3 =
                " _  _  _  _        _  _    " +
                "| || || || |  ||_|| ||_   |" +
                "|_||_||_||_|  |  ||_| _|  |" +
                "                           ";

        List<Long> listOfNumbers = bankOCR.convertToListOfLongs(testStringAsLine+testStringAsLine1+testStringAsLine2+testStringAsLine3);

        Assert.assertEquals(listOfNumbers.size(), listOfTestValues.size());
        Assert.assertEquals(listOfNumbers.get(0), listOfTestValues.get(0));
        Assert.assertEquals(listOfNumbers.get(1), listOfTestValues.get(1));
    }

    @Test
    public void shouldCreateFileWithNumbersEveryNumberHaveNoteIfIllegibleOfErrorWithCheckSum(){
        String testStringAsLine =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || || ||_   |" +
                "|_||_||_||_||_||_||_| _|  |" +
                "                           ";
        String testStringAsLine1 =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || ||_||_   |" +
                "|_||_||_||_||_||_||_| _|  |" +
                "                           ";
        String testStringAsLine2 =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || |  ||_   |" +
                "|_||_||_||_||_ | ||_| _|  |" +
                "                           ";
        String testStringAsLine3 =
                " _  _  _  _     _  _  _  _ " +
                "| || || || ||_|| || ||_  _|" +
                "|_||_||_||_|  ||_||_| _| _|" +
                "                           ";

        bankOCR.saveToFile(testStringAsLine+testStringAsLine1+testStringAsLine2+testStringAsLine3);

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("numbers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> listOfNumbers = new ArrayList<>();

        while (scanner.hasNext()){
            listOfNumbers.add(scanner.nextLine());
        }

        Assert.assertEquals(listOfNumbers.get(0), "000000051");
        Assert.assertEquals(listOfNumbers.get(1).split(" ")[1], "ERR");
        Assert.assertEquals(listOfNumbers.get(2).split(" ")[1], "ILL");
        Assert.assertEquals(listOfNumbers.get(2).substring(4, 7), "???");
        Assert.assertEquals(listOfNumbers.get(3), "000040053");

    }

    @Test
    public void shouldAddListOfPossibleNumbersIfNumberIsIllegibleOrError(){
        String testStringAsLine =
                " _  _  _  _  _  _  _  _    " +
                "| || ||_|| || || || ||_   |" +
                "|_||_||_||_||_||_||_| _|  |" +
                "                           ";
        String testStringAsLine1 =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || ||_||_   |" +
                "|_||_||_||_||_||_||_| _|  |" +
                "                           ";
        String testStringAsLine2 =
                " _  _  _  _  _  _  _  _    " +
                "| || || || || || |  ||_   |" +
                "|_||_||_||_||_ | ||_| _|  |" +
                "                           ";
        String testStringAsLine3 =
                " _  _  _  _     _  _  _  _ " +
                "| ||    || ||_|| || ||_  _|" +
                "|_||_||_||_|  ||_||_| _| _|" +
                "                           ";

        bankOCR.saveToFile(testStringAsLine + testStringAsLine1 + testStringAsLine2 + testStringAsLine3);

        Scanner scanner = null;
        List<String> listOfLines = new ArrayList<>();
        List<AccountHolder> listOfpossibleNumbers = new ArrayList<>();
        try {
            scanner = new Scanner(new File("numbers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext())
            listOfLines.add(scanner.nextLine());

        for (String line: listOfLines) {
            String[] split = line.split(" ");
            if (line.length()>16){
                String[] tempTable = split;
                listOfpossibleNumbers.add(
                        new AccountHolder(tempTable[0], tempTable[1], tempTable[2].substring(1,tempTable[2].length()-1).split(",")));
            }
            else if (line.length()>13){
                String[] tempTable = split;
                listOfpossibleNumbers.add(
                        new AccountHolder(tempTable[0], tempTable[1], new String[1]));
            }
            else{
                String[] tempTable = split;
                listOfpossibleNumbers.add(new AccountHolder(tempTable[0], "", new String[1]));
            }
        }

        Assert.assertEquals(listOfpossibleNumbers.get(0).getNumber(), "008000051");
        Assert.assertEquals(listOfpossibleNumbers.get(0).getCode(), "ERR");
        String[] possible1 = {"000000051"};
        Assert.assertEquals(listOfpossibleNumbers.get(0).getPossibleNumbers()[0], possible1[0]);

        Assert.assertEquals(listOfpossibleNumbers.get(1).getNumber(), "000000851");
        Assert.assertEquals(listOfpossibleNumbers.get(1).getCode(), "ERR");
        Assert.assertEquals(listOfpossibleNumbers.get(1).getPossibleNumbers().length, 2);

        Assert.assertEquals(listOfpossibleNumbers.get(2).getNumber(), "0000???51");
        Assert.assertEquals(listOfpossibleNumbers.get(2).getCode(), "ILL");
        Assert.assertEquals(listOfpossibleNumbers.get(2).getPossibleNumbers().length, 1);

        Assert.assertEquals(listOfpossibleNumbers.get(3).getNumber(), "0??040053");
        Assert.assertEquals(listOfpossibleNumbers.get(3).getCode(), "ILL");
        Assert.assertEquals(listOfpossibleNumbers.get(3).getPossibleNumbers()[0], "000040053");
    }



    private String examples(String input) {
        switch (input){
            case "000000000":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "| || || || || || || || || |" +
                        "|_||_||_||_||_||_||_||_||_|" +
                        "                           ";
            case "111111111":
                return  "                           " +
                        "  |  |  |  |  |  |  |  |  |" +
                        "  |  |  |  |  |  |  |  |  |" +
                        "                           ";
            case "222222222":
                return  " _  _  _  _  _  _  _  _  _ " +
                        " _| _| _| _| _| _| _| _| _|" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ " +
                        "                           ";
            case "333333333":
                return  " _  _  _  _  _  _  _  _  _ " +
                        " _| _| _| _| _| _| _| _| _|" +
                        " _| _| _| _| _| _| _| _| _|" +
                        "                           ";
            case "444444444":
                return  "                           " +
                        "|_||_||_||_||_||_||_||_||_|" +
                        "  |  |  |  |  |  |  |  |  |" +
                        "                           ";
            case "555555555":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ " +
                        " _| _| _| _| _| _| _| _| _|" +
                        "                           ";
            case "666666666":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ " +
                        "|_||_||_||_||_||_||_||_||_|" +
                        "                           ";
            case "777777777":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "  |  |  |  |  |  |  |  |  |" +
                        "  |  |  |  |  |  |  |  |  |" +
                        "                           ";
            case "888888888":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "|_||_||_||_||_||_||_||_||_|" +
                        "|_||_||_||_||_||_||_||_||_|" +
                        "                           ";
            case "999999999":
                return  " _  _  _  _  _  _  _  _  _ " +
                        "|_||_||_||_||_||_||_||_||_|" +
                        " _| _| _| _| _| _| _| _| _|" +
                        "                           ";
            case "123456789":
                return  "    _  _     _  _  _  _  _ " +
                        "  | _| _||_||_ |_   ||_||_|" +
                        "  ||_  _|  | _||_|  ||_| _|" +
                        "                           ";
            default:
                return null;
        }

    }


}
