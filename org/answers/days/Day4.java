package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {


    public static int answer1(){
        int resp = 0;

        Map<Integer, String[]> input = processInput();
        int height = input.size();
        int width = input.get(0).length;



        for(int i=0; i< height; i++){
            String[] line = input.get(i);
            for(int j=0; j< width; j++){
                String character = line[j];
                if("X".equals(character)){
                    // direction N
                    if(i>=3){
                        if("M".equals(input.get(i-1)[j]) && "A".equals(input.get(i-2)[j]) && "S".equals(input.get(i-3)[j])){
                            resp++;
                        }
                    }

                    // direction S
                    if(i<=height-4){
                        if("M".equals(input.get(i+1)[j]) && "A".equals(input.get(i+2)[j]) && "S".equals(input.get(i+3)[j])){
                            resp++;
                        }
                    }

                    // direction W
                    if(j>=3){
                        if("M".equals(input.get(i)[j-1]) && "A".equals(input.get(i)[j-2]) && "S".equals(input.get(i)[j-3])){
                            resp++;
                        }
                    }

                    // direction E
                    if(j<=width-4){
                        if("M".equals(input.get(i)[j+1]) && "A".equals(input.get(i)[j+2]) && "S".equals(input.get(i)[j+3])){
                            resp++;
                        }
                    }

                    // direction NW
                    if(i>=3 && j>=3){
                        if("M".equals(input.get(i-1)[j-1]) && "A".equals(input.get(i-2)[j-2]) && "S".equals(input.get(i-3)[j-3])){
                            resp++;
                        }
                    }

                    // direction NE
                    if(i>=3 && j<=width-4){
                        if("M".equals(input.get(i-1)[j+1]) && "A".equals(input.get(i-2)[j+2]) && "S".equals(input.get(i-3)[j+3])){
                            resp++;
                        }
                    }

                    // direction SW
                    if(i<=height-4 && j>=3){
                        if("M".equals(input.get(i+1)[j-1]) && "A".equals(input.get(i+2)[j-2]) && "S".equals(input.get(i+3)[j-3])){
                            resp++;
                        }
                    }

                    // direction SE
                    if(i<=height-4 && j<=width-4){
                        if("M".equals(input.get(i+1)[j+1]) && "A".equals(input.get(i+2)[j+2]) && "S".equals(input.get(i+3)[j+3])){
                            resp++;
                        }
                    }
                }
            }
        }
        return resp;
    }

    public static int answer2(){
        int resp = 0;

        Map<Integer, String[]> input = processInput();
        int height = input.size();
        int width = input.get(0).length;

        for(int i=1; i< height-1; i++) {
            String[] line = input.get(i);
            for (int j = 1; j < width-1; j++) {
                String character = line[j];
                if ("A".equals(character)) {

                    // MM up
                    if("M".equals(input.get(i-1)[j-1]) && "M".equals(input.get(i-1)[j+1]) && "S".equals(input.get(i+1)[j-1]) && "S".equals(input.get(i+1)[j+1])){
                        resp++;
                    }

                    // MM down
                    if("M".equals(input.get(i+1)[j-1]) && "M".equals(input.get(i+1)[j+1]) && "S".equals(input.get(i-1)[j-1]) && "S".equals(input.get(i-1)[j+1])){
                        resp++;
                    }

                    // MM west
                    if("M".equals(input.get(i-1)[j-1]) && "M".equals(input.get(i+1)[j-1]) && "S".equals(input.get(i-1)[j+1]) && "S".equals(input.get(i+1)[j+1])){
                        resp++;
                    }

                    // MM east
                    if("M".equals(input.get(i-1)[j+1]) && "M".equals(input.get(i+1)[j+1]) && "S".equals(input.get(i-1)[j-1]) && "S".equals(input.get(i+1)[j-1])){
                        resp++;
                    }
                }
            }
        }
        return resp;
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
