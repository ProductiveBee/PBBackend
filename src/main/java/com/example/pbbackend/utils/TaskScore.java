package com.example.pbbackend.utils;

import java.util.ArrayList;

public class TaskScore {
    private static final int basePointLevel = 10;
    private static final int basePenaltyLevel = 5;
    public static int taskScoreCalculation(ArrayList<Integer> taskDistribution, ArrayList<Integer> taskCompletion, boolean familyTime){
        int percentageOfWorkDone = 0 ;
        for(int i = 0 ; i < taskDistribution.size(); i++){
            percentageOfWorkDone += taskDistribution.get(i)*taskCompletion.get(i);
        }
        int score = (percentageOfWorkDone*basePointLevel) - ((1 - percentageOfWorkDone)* basePenaltyLevel);
        if(familyTime){
            score += 2
        }
        return score;
    }
}
