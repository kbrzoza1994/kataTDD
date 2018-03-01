package org.kata.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankOCR {
    public String convertToString(String testInput) {
        return converter(testInput);
    }

    public ArrayList<Long> convertToListOfLongs(String testInput){
        List<String> listOfStrings = Arrays.asList(converter(testInput).split(" "));
        ArrayList<Long> listOfLongs = new ArrayList<>();

        for (String number:listOfStrings) {
            if (isntIllegible(number)){
                if (isCorrect(number))
                    listOfLongs.add(Long.valueOf(number));
            }
        }
        return listOfLongs;
    }

    private boolean isntIllegible(String number) {
        if (!number.contains("?"))
            return true;
        return false;
    }

    private boolean isCorrect(String number) {
        int checkSum = 0;
        for (int i = 0; i < number.length(); i++) {
            checkSum += Integer.parseInt(number.substring(i,i+1))*(number.length()-i);
        }
        return checkSum%11==0;
    }

    private String converter(String testInput) {
        StringBuilder output = new StringBuilder("");
        int quantityOfNumbers = testInput.length()/107;

        for (int k = 0; k < quantityOfNumbers; k++) {
            for (int i = k*108; i < k*108+27; i += 3) {
                int j = i + 3;
                int number = getNumber(testInput.substring(i, j) + testInput.substring(i + 27, j + 27) + testInput.substring(i + 54, j + 54));
                if (number!=-1)
                output.append(number);
                else
                    output.append("?");
            }
            if (k!=quantityOfNumbers-1)
            output.append(" ");
        }
        return output.toString();
    }

    private int getNumber(String oneCharacter){
        switch (oneCharacter){
            case " _ " +
                 "| |" +
                 "|_|":
                return 0;

            case "   " +
                 "  |" +
                 "  |":
                return 1;

            case " _ " +
                 " _|" +
                 "|_ ":
                return 2;

            case " _ " +
                 " _|" +
                 " _|":
                return 3;

            case "   " +
                 "|_|" +
                 "  |":
                return 4;

            case " _ " +
                 "|_ " +
                 " _|":
                return 5;

            case " _ " +
                 "|_ " +
                 "|_|":
                return 6;

            case " _ " +
                 "  |" +
                 "  |":
                return 7;

            case " _ " +
                 "|_|" +
                 "|_|":
                return 8;

            case " _ " +
                 "|_|" +
                 " _|":
                return 9;
            default:
                return -1;
        }
    }

    public void saveToFile(String s) {
        String numbers = convertToString(s);

        List<String> listOfNumbers = Arrays.asList(numbers.split(" "));

        try {
            PrintWriter printWriter = new PrintWriter("numbers.txt");

            for (String number: listOfNumbers) {
                if (number.contains("?"))
                    printWriter.println(number + " ILL" + " [" + getPossibleNumbers(number) + "]");
                else if (isCorrect(number))
                    printWriter.println(number);
                else
                    printWriter.println(number + " ERR" + " [" + getPossibleNumbers(number) + "]");
            }

            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private String getPossibleNumbers(String number) {
        int x01  = -1;
        int x02 = -1;
        String possibleNumbers = "";
        for (int j = 0; j < number.length(); j++) {
            if (number.charAt(j)=='?') {
                if (j==0)
                    x01 = 0;
                else if (x01==-1)
                    x01 = j;
                else if (x02>-1)
                    return "";
                else
                    x02 = j;
            }

        }

        if (x01 == -1){
            possibleNumbers = checkPossibleNumbers(number, new StringBuilder(""));
        }

        else if (x02 == -1){
            possibleNumbers = checkPossibleNumbersIll(number, new StringBuilder(""), x01);
        }else if (x02 > -1){
            possibleNumbers = checkPossibleNumbersIll(number, new StringBuilder(""), x01, x02);
        }else{

        }

        return possibleNumbers;
    }

    private String checkPossibleNumbersIll(String number, StringBuilder possibleNumbers, int x01) {
        for (int i = 0; i < 10; i++) {
            if (isCorrect(number.substring(0,x01) + i + number.substring(x01+1)))
                possibleNumbers.append(number.substring(0, x01)).append(i).append(number.substring(x01 + 1)).append(",");
        }
        return possibleNumbers.deleteCharAt(possibleNumbers.length()-1).toString();
    }

    private String checkPossibleNumbersIll(String number, StringBuilder possibleNumbers, int x01, int x02) {
        for (int j = 0; j < 10; j++) {
            number = number.substring(0,x01) + j + number.substring(x01+1);
            for (int k = 0; k < 10; k++) {
                number = number.substring(0,x02) + k + number.substring(x02+1);
                if (isCorrect(number))
                    possibleNumbers.append(number).append(",");
            }
        }
        return possibleNumbers.deleteCharAt(possibleNumbers.length()-1).toString();
    }

    private String checkPossibleNumbers(String number, StringBuilder possibleNumbers) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i)-'1'=='1') {
                if (isCorrect(number.substring(0,i) + "7" + number.substring(i+1)))
                                    possibleNumbers.append(number.substring(0, i)).append("7").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)-'2'=='2'){
                if (isCorrect(number.substring(0,i) + "5" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("5").append(number.substring(i + 1)).append(",");

            }else if (number.charAt(i)=='3'){
                if (isCorrect(number.substring(0,i) + "9" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("9").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "5" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("5").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='5'){
                if (isCorrect(number.substring(0,i) + "9" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("9").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "3" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("3").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='6'){
                if (isCorrect(number.substring(0,i) + "8" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("8").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "9" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("9").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='7'){
                if (isCorrect(number.substring(0,i) + "1" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("1").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='8'){
                if (isCorrect(number.substring(0,i) + "0" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("0").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "6" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("6").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "9" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("9").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='9'){
                if (isCorrect(number.substring(0,i) + "0" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("0").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "6" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("6").append(number.substring(i + 1)).append(",");
                if (isCorrect(number.substring(0,i) + "8" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("8").append(number.substring(i + 1)).append(",");
            }else if (number.charAt(i)=='0'){
                if (isCorrect(number.substring(0,i) + "8" + number.substring(i+1)))
                    possibleNumbers.append(number.substring(0, i)).append("8").append(number.substring(i + 1)).append(",");
            }

        }
        return possibleNumbers.deleteCharAt(possibleNumbers.length()-1).toString();
    }
}
