package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {


    public static int answer1(){
        final String word = "XMAS";

        Map<Integer, String[]> input = processInput();

        for(int i=0; i< input.size(); i++){
            String[] line = input.get(i);
            for(int j=0; j<input.get(0).length; j++){
                String character = line[j];
                if("X".equals(character)){

                    System.out.println("x: " + j + " , y: " + i);

                }
            }
        }


        return 0;
    }

    public static Map<Integer, String[]> processInput(){

        Map<Integer, String[]> res = new HashMap<>();

        int colIndex = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day4.txt"))) {

            String inputLine = reader.readLine();
            while(inputLine != null){
                String[] line = inputLine.split("");

                res.put(colIndex, line);

                colIndex++;
                inputLine = reader.readLine();
            }

        }catch(Exception e) {
            // nothing
        }
        return res;
    }


}
