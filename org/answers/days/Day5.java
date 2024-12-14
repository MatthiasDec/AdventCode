package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day5 {


    public static int answer1(){
        int sum = 0;

        List<int[]> updatesInput = processUpdatesInput();

        for(int[] updateInput : updatesInput){

            if(isCorrect(updateInput)){
                int medianIndex = updateInput.length/2;
                int medianNumber = updateInput[medianIndex];
                sum+= medianNumber;
            }
        }
        return sum;
    }

    public static int answer2(){
        int sum = 0;

        List<int[]> updatesInput = processUpdatesInput();

        for(int[] updateInput : updatesInput){

            if(!isCorrect(updateInput)){
                int medianIndex = updateInput.length/2;

                int[] fixedUpdateInput = fixUpdateInputTotal(updateInput);

                int medianNumber = fixedUpdateInput[medianIndex];
                sum+= medianNumber;
            }
        }
        return sum;
    }

    public static boolean isCorrect(int[] inputArray) {

        List<Integer> inputList = Arrays.stream(inputArray).boxed().toList();

        try (BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day5_1.txt"))) {
            String inputLine = reader.readLine();
            while (inputLine != null) {

                String[] sliptNumbersAsString = inputLine.split("\\|");
                int small = Integer.parseInt(sliptNumbersAsString[0]);
                int big = Integer.parseInt(sliptNumbersAsString[1]);

                if (inputList.contains(small) && inputList.contains(big) && inputList.indexOf(small) > inputList.indexOf(big)) {
                    return false;
                }
                inputLine = reader.readLine();
            }
            return true;
        } catch (Exception e) {
            // nothing
        }
        return false;
    }

    public static int[] fixUpdateInputTotal(int[] inputArray){
        List<Integer> inputList = fixUpdateInputOnce(Arrays.stream(inputArray).boxed().toList());
        List<Integer> fixedOnceInputList = fixUpdateInputOnce(inputList);
        int maxIterations = 50;
        int iterationCount = 0;

        while(!fixedOnceInputList.equals(inputList) || iterationCount < maxIterations){
            inputList = fixedOnceInputList;
            fixedOnceInputList =  fixUpdateInputOnce(inputList);
            iterationCount ++;
        }

        return inputList.stream().mapToInt(i->i).toArray();
    }

    public static List<Integer> fixUpdateInputOnce(List<Integer> inputList){

        try (BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day5_1.txt"))) {
            String inputLine = reader.readLine();
            while (inputLine != null) {

                String[] sliptNumbersAsString = inputLine.split("\\|");
                int small = Integer.parseInt(sliptNumbersAsString[0]);
                int big = Integer.parseInt(sliptNumbersAsString[1]);

                if (inputList.contains(small) && inputList.contains(big) && inputList.indexOf(small) > inputList.indexOf(big)) {
                    int indexSmall = inputList.indexOf(small);
                    int indexBig = inputList.indexOf(big);
                    inputList.set(indexSmall, big);
                    inputList.set(indexBig, small);
                }
                inputLine = reader.readLine();
            }
        } catch (Exception e) {
            // nothing
        }
        return inputList;
    }


    /*
    public static boolean isCorrect(int[] updateInput, List<Integer> processedPageOrderInput){

        int index = 0;
        List<Integer> updateInputClean = Arrays.stream(updateInput).boxed().collect(Collectors.toList());
        updateInputClean.retainAll(processedPageOrderInput);

        for(int page : processedPageOrderInput){

            if(index == updateInputClean.size()){
                System.out.println(Arrays.toString(updateInput) + " cleand to " + updateInputClean.toString() + " is correct ");
                return true;
            }

            if(page == updateInputClean.get(index)){
                index += 1;
            }
        }

        if(index == updateInputClean.size()){
            System.out.println(Arrays.toString(updateInput) + " cleand to " + updateInputClean.toString() +  " is correct");
        }else{
            System.out.println(Arrays.toString(updateInput) + " cleand to " + updateInputClean.toString() +  " is incorrect");
        }
        return index == updateInputClean.size();
    }

    public static List<Integer> processPageOrderInput(List<Integer> processedPageOrderInput){

        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day5_1.txt"))) {
            String inputLine = reader.readLine();
            while(inputLine != null){

                String[] numbers = inputLine.split("\\|");
                int number1 = Integer.parseInt(numbers[0]);
                int number2 = Integer.parseInt(numbers[1]);

                if(!processedPageOrderInput.contains(number1) && !processedPageOrderInput.contains(number2)){
                    //put the unknown numbers at the end
                    processedPageOrderInput.add(number1);
                    processedPageOrderInput.add(number2);

                }else if(!processedPageOrderInput.contains(number1) && processedPageOrderInput.contains(number2)){
                    //put number1 before number2
                    int index2 = processedPageOrderInput.indexOf(number2);
                    if(index2 == 1 ){
                        processedPageOrderInput.add(1, number1);
                    }
                    else if(index2 == 0){
                        processedPageOrderInput.add(0, number1);
                    }else{
                        processedPageOrderInput.add(index2 - 1, number1);
                    }
                }else if(processedPageOrderInput.contains(number1) && !processedPageOrderInput.contains(number2)){
                    //put number2 before number1
                    int index1 = processedPageOrderInput.indexOf(number1);
                    processedPageOrderInput.add(index1 +1, number2);
                }else{
                    // check their index
                    int index1 = processedPageOrderInput.indexOf(number1);
                    int index2 = processedPageOrderInput.indexOf(number2);

                    if(index1 > index2){
                        // transmute the two numbers
                        processedPageOrderInput.set(index1, number2);
                        processedPageOrderInput.set(index2, number1);
                    }

                }
                inputLine = reader.readLine();
            }

        }catch(Exception e) {
            // nothing
        }

        return processedPageOrderInput;
    }
*/
    public static List<int[]> processUpdatesInput(){
        ArrayList<int[]> res = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day5_2.txt"))) {

            String inputLine = reader.readLine();
            while(inputLine != null){
                res.add(Arrays.stream(inputLine.split(",")).mapToInt(Integer::parseInt).toArray());
                inputLine = reader.readLine();
            }

        }catch(Exception e) {
            // nothing
        }
        return res;
    }

}
