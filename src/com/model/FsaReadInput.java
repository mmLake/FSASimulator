package com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayalake on 1/22/18.
 */
public class FsaReadInput {
    public final String INPUT_FILE_PATH = "src/com/input.txt";
    BufferedReader bufferreader;
    Fsa fsa;

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
            int numStates;
            int[][] fsaTable;
            String[] finalStatesStr;
            String[] alphabetStr;
            ArrayList<String> testStringList = new ArrayList<String>();
            String transitionStr;
            String alphaType = "binary"; //default assumption
            int colSize, rowSize;

            //read in # of states, final states, and alphabet
            numStates = Integer.parseInt(bufferreader.readLine());
            states = new String[numStates];
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
                int curSymbol = alphabetSymbolAsInt((transition[1]));

                fsaTable[Integer.parseInt(transition[0])][curSymbol] = Integer.parseInt(transition[2]);
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
                alphabet.add(alphabetSymbolAsInt(alpha));
            }
            for (String finalState : finalStatesStr){
                finalStates.add(Integer.parseInt(finalState));
            }
            for (AsciiSymbolStrings string : AsciiSymbolStrings.values()){
                if (alphabetStr[0].equals(string.toString())){
                    alphaType = string.type();
                }
            }

            fsa = new Fsa(numStates, fsaTable, alphabet, finalStates, testStrings, alphaType);
            return fsa;
        } catch (Exception ex) {
            return null;
        }
    }

    public int alphabetSymbolAsInt(String alpha){
        int alphaVal = -1;
        //an integer value alphabet
        try{
            alphaVal = Integer.parseInt(alpha);

        }//a string value alphabet
        catch(Exception e){
            for (AsciiSymbolStrings string : AsciiSymbolStrings.values()){
                if (alpha.equals(string.toString())){
                    alphaVal = string.getSymbolIntVal();
                }
            }
        }
        return alphaVal;
    }
}
