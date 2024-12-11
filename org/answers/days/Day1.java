package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    public static int answer1(){
        Map<Integer, ArrayList<Integer>> input = processInput();
        ArrayList<Integer> list1 = input.get(1);
        ArrayList<Integer> list2 = input.get(2);

        int res = 0;
        for(int i = 0; i<1000; i++){
            res += Math.abs(list1.get(i)-list2.get(i));
        }

        return res;
    }

    public static int answer2(){
        Map<Integer, ArrayList<Integer>> input = processInput();
        ArrayList<Integer> list1 = input.get(1);
        ArrayList<Integer> list2 = input.get(2);

        int res = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        int coefficient = 0;

        while(pointer1 != 999){
            int value1 = list1.get(pointer1);
            int value2 = list2.get(pointer2);

            if(value1 == list2.get(pointer2)){
                coefficient += 1;
                if(pointer2 == 999){
                    pointer1 = 999;
                }
                pointer2 += 1;
            }else{
                res += value1 * coefficient;
                if(value1>value2){
                    pointer2+=1;
                }else{
                    pointer1+=1;
                }
                coefficient = 0;
            }

        }

        return res;
    }

    public static Map<Integer, ArrayList<Integer>> processInput(){

        HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day1.txt"))) {

            String line = reader.readLine();
            while(line != null){
                String[] inputs = line.split(" {3}");

                if(inputs.length == 2){
                    res1.add(Integer.valueOf(inputs[0]));
                    res2.add(Integer.valueOf(inputs[1]));
                    line = reader.readLine();
                }
            }

        }catch(Exception e) {
            // nothing
        }

        Collections.sort(res1);
        Collections.sort(res2);

        res.put(1, res1);
        res.put(2, res2);
        return res;
    }


}
