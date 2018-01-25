package com.model;

import java.util.ArrayList;

/**
 * Created by mayalake on 1/22/18.
 */
public class Fsa {
    private int[][] fsaTable; //trap states represented as -1
    private ArrayList<Integer> alphabet;
    private ArrayList<Integer> finalStates;
    private String [] testStrings;

    public Fsa(int[][] fsaTable, ArrayList<Integer> alphabet, ArrayList<Integer> finalStates, String[] testStrings){
        this.fsaTable = fsaTable;
        this.alphabet = alphabet;
        this.finalStates = finalStates;
        this.testStrings = testStrings;
    }

    //fsa algorithm
    public String acceptTestString(String testStr){
        Boolean accepted = false;
        int state = 0; //initial state is always set to 0.
        char[] testString = testStr.toCharArray();
        for(char symbol : testString){
            int symbolVal = Character.getNumericValue(symbol);
            //check if symbol is in alphabet
            if (alphabet.contains(Character.getNumericValue(symbol))) {
                state = fsaTable[state][symbolVal];

                if (state == -1) {
                    break;
                }
            }
            if (!(testString[testStr.length()-1] == symbol)){
                accepted = false;
            } else if(finalStates.contains(state)){
                accepted = true;
            } else {
                accepted = false;
            }
        }
        return (accepted? "Accept" : "Reject");
    }


    public int[][] getFsaTable() {
        return fsaTable;
    }

    public ArrayList<Integer> getAlphabet() {
        return alphabet;
    }

    public ArrayList<Integer> getFinalStates() {
        return finalStates;
    }

    public String[] getTestStrings() {
        return testStrings;
    }
}
