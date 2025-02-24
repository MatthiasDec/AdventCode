package org.answers.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {

    private final List<String> directions = new ArrayList<>();

    private String[][] map = null;


    private int xGuardPosition = 0;
    private int initialXGuardPosition = 0;
    private int yGuardPosition = 0;
    private int initialYGuardPosition = 0;

    private int guardDirectionIndex = 0;

    private String guardDirection = "U";

    private final int height = 130;

    private final int width = 130;

    private int score = 0;

    public Day6(){

    }

    public void initialize(){
        directions.add("U");
        directions.add("R");
        directions.add("D");
        directions.add("L");

        map = readMap();
    }

    public void run(){

        while((xGuardPosition != initialXGuardPosition && yGuardPosition != initialYGuardPosition) ||
                (xGuardPosition > 129 || yGuardPosition > 129)){
            iterate();
        }

    }

    public void iterate(){

        moveAndCountScore();
    }

    private void moveAndCountScore(){
        int x = xGuardPosition;
        int y = yGuardPosition;
        switch (guardDirection){
            case "U"->{
                if(xGuardPosition -1 <0){
                    return;
                }
            }
            case "R"->{

            }
            case "D"->{

            }
            case "L"->{

            }
            default -> {System.out.println("ERROR");}
        }


        if(".".equals(map[xGuardPosition][yGuardPosition])){
            score++;
            map[xGuardPosition][yGuardPosition] = "X";
        }
    }

    public int answer1(){
        return score;
    }

    public int answer2(){
        return 0;
    }

    public String[][] readMap(){
        final String guard = "^";
        String[][] map = new String[130][130];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("org/answers/resources/day6.txt"))) {
            String inputLine = reader.readLine();
            while (inputLine != null) {

                String[] line = inputLine.split("");

                if(inputLine.contains(guard)){
                    yGuardPosition = index;
                    initialYGuardPosition = yGuardPosition;
                    xGuardPosition = inputLine.indexOf(guard);
                    initialXGuardPosition = xGuardPosition;
                }
                map[index] = line;
                index++;
                inputLine = reader.readLine();
            }
        } catch (Exception e) {
            // nothing
        }

        return map;
    }
}
