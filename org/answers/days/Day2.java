package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day2 {

    public static int answer1(){

        Map<Integer, ArrayList<Integer>> inputs = processInput();
        int res = 0;

        for (var entry : inputs.entrySet()) {
            int value =isReportSafe(entry.getValue());
            res += value;
        }
        return res;

    }

    public static int answer2(){

        Map<Integer, ArrayList<Integer>> inputs = processInput();
        int res = 0;

        for (var entry : inputs.entrySet()) {
            ArrayList<Integer> input = entry.getValue();
            int inputChecksum = 0;
            for(int i=0; i< input.size(); i++){
                if(inputChecksum == 0){
                    ArrayList<Integer> truncatedInput = (ArrayList<Integer>) input.clone();
                    truncatedInput.remove(i);
                    inputChecksum += isReportSafe(truncatedInput);
                }
            }
            if(inputChecksum > 0){
                res+=1;
            }
        }
        return res;
    }

    private static int isReportSafe(List<Integer> input){
        int res = 0;
        int initialValue = input.get(0);
        int nextValue = input.get(1);
        int length = input.size();

        boolean desc;

        if(initialValue == nextValue){
            return res;
        }

        desc = initialValue > nextValue;
        if(desc){
            for(int i=1; i<length; i++){
                nextValue = input.get(i);
                if(initialValue <= nextValue || initialValue - nextValue > 3){
                    return 0;
                }
                initialValue = nextValue;
            }
            return 1;

        }else{
            for(int i=1; i<length; i++){
                nextValue = input.get(i);
                if(initialValue >= nextValue || nextValue - initialValue > 3){
                    return 0;
                }
                initialValue = nextValue;
            }
            return 1;

        }
    }

    public static Map<Integer, ArrayList<Integer>> processInput(){

        HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
        int index = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day2.txt"))) {

            String line = reader.readLine();
            while(line != null){
                String[] inputs = line.split(" ");
                res.put(index, Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new)));
                index ++;
                line = reader.readLine();
            }

        }catch(Exception e) {
            // nothing
        }
        return res;
    }

}
