/**
 * TOBE: Contains data of a die; number of sides, their first roll and second roll
 */


package com.github.diceroller;

import java.util.Random;

public class DieData {

    // declaring atts
    private int numberOfSides;
    private int firstResult;
    private int secondResult;
    private Random rand = new Random();

    public DieData (){
        numberOfSides = 0;
        firstResult = 0;
        secondResult = 0;
    }

    public void setNumberOfSides(int numbSide){
        numberOfSides = numbSide;
    }

    public int getNumberOfSides(){
        return numberOfSides;
    }

    public int rollDieOnce(){
        // since the results will be from 0, add one to shift the value by 1 unit
        return rand.nextInt(numberOfSides)+1;
    }

    public int[] rollDieTwice(){
        firstResult = rand.nextInt(numberOfSides)+1;
        secondResult = rand.nextInt(numberOfSides)+1;

        return new int[]{firstResult,secondResult};
    }
}
