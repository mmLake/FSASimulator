package com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayalake on 1/22/18.
 */
public class FsaReadInput {
    public static final String INPUT_FILE_PATH = "src/com/input.txt";
    BufferedReader bufferreader;

    public FsaReadInput(){
        try {
            bufferreader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Fsa setNextFsa(){
        try {
            String[] states;
            int[][] fsaTable;
            String[] finalStatesStr;
            String[] alphabetStr;
            ArrayList<String> testStringList = new ArrayList<String>();
            String transitionStr;
            String testStr;
            int colSize, rowSize;

            //read in # of states, final states, and alphabet
            states = new String[Integer.parseInt(bufferreader.readLine())];
            finalStatesStr = bufferreader.readLine().split(" ");
            alphabetStr = bufferreader.readLine().split(" ");

            //calculate fsa table (2d array) size
            colSize = states.length;
            rowSize = alphabetStr.length;
            fsaTable = new int[colSize][rowSize];

            //read in all transitions and populate fsa table
            while ((transitionStr = bufferreader.readLine()).startsWith("(")){
                String transitionVal = transitionStr.substring(1, transitionStr.length()-1);
                String[] transition = transitionVal.split(" ");

                fsaTable[Integer.parseInt(transition[0])][Integer.parseInt(transition[1])] = Integer.parseInt(transition[2]);
            }

            //read in test strings
            do{
                testStringList.add(transitionStr);
            }while (!(transitionStr = bufferreader.readLine()).startsWith("#"));

            //return fsa
            String [] testStrings = testStringList.toArray(new String[testStringList.size()]);
            ArrayList<Integer> alphabet = new ArrayList<Integer>();
            ArrayList<Integer> finalStates = new ArrayList<Integer>();
            for (String alpha : alphabetStr){
                int alphaVal = Integer.parseInt(alpha);
                if ((alphaVal >= 65 && alphaVal <= 90) || (alphaVal >= 97 && alphaVal <= 122)){//letter
                    alphaVal = AlphabetStrings.letter.numericVal();
                } else if (alphaVal >= 48 && alphaVal <= 57) { //digit
                    alphaVal = AlphabetStrings.digit.numericVal();
                } else if (alphaVal==95) { //underscore
                    alphaVal = AlphabetStrings.underscore.numericVal();
                } else if (alphaVal==46) { //period
                    alphaVal = AlphabetStrings.period.numericVal();
                } else if (alphaVal==45) { //hyph
                    alphaVal = AlphabetStrings.hyph.numericVal();
                } else if (alphaVal==64){ //@
                    alphaVal = AlphabetStrings.at.numericVal();
                }

                alphabet.add(alphaVal);
            }
            for (String finalState : finalStatesStr){
                finalStates.add(Integer.parseInt(finalState));
            }

            Fsa newFsa = new Fsa(fsaTable, alphabet, finalStates, testStrings);

            return newFsa;
        } catch (IOException ex) {
            return null;
        }
    }

}
