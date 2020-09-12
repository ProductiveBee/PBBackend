package com.example.pbbackend.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskScore {
    private static final int basePointLevel = 10;
    private static final int basePenaltyLevel = 5;

    //Hashmap contains task percentage corresponding to 1/0 if they were done or not
    // consists the score from the database
    // returns the final score directly store in database
    public static int taskScoreCalculation(HashMap<Double,Integer> tasks, boolean familyTime,int score){
        int percentageOfWorkDone = 0 ;
        Iterator itr = tasks.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry mapElement = (Map.Entry) itr.next();
            percentageOfWorkDone += (double) mapElement.getKey() * (int) mapElement.getValue();
        }

        score = (percentageOfWorkDone*basePointLevel) - ((1 - percentageOfWorkDone)* basePenaltyLevel);
        if(familyTime){
            score += 2;
        }
        return score;
    }

    public static int streakScoreCalculation(int score, int noOfStreakDays){
        return score + noOfStreakDays;
    }

}
