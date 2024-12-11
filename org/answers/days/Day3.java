package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day3 {

    public static int answer1(){
        String value = processInput().toLowerCase();
        return computeInstruction(value);
    }

    public static int answer2(){
        String value = processInput().toLowerCase();
        String[] values = value.split("don't\\(\\)");

        int res = computeInstruction(values[0]);

        for(int i=1; i<values.length; i++){
            String[] split = values[i].split("do\\(\\)");
            if(split.length>1){
                for(int j=1; j<split.length; j++){
                    res+= computeInstruction(split[j]);
                }
            }

        }

        return res;
    }

    public static String processInput(){

        String res = "";
        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day3.txt"))) {

            res = reader.readLine();

        }catch(Exception e) {
            // nothing
        }
        return res;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private static int computeInstruction(String value){
        int res = 0;
        String[] splitInputList = value.split("mul\\(");

        for(String element : splitInputList){
            String[] cleanedElementList = element.split("\\)");
            String cleanedElement = cleanedElementList[0];

            String[] numbers = cleanedElement.split(",");

            if(numbers.length == 2 &&  isInteger(numbers[0]) && isInteger(numbers[1])){
                res+= Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
            }
        }

        return res;
    }

}
