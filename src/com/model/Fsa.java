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
    private String fsaAlphaType;

    public Fsa(int[][] fsaTable, ArrayList<Integer> alphabet, ArrayList<Integer> finalStates, String[] testStrings, String fsaAlphaType){
        this.fsaTable = fsaTable;
        this.alphabet = alphabet;
        this.finalStates = finalStates;
        this.testStrings = testStrings;
        this.fsaAlphaType = fsaAlphaType;
    }

    //fsa algorithm
    public String acceptTestString(String testStr){
        Boolean accepted = false;
        int state = 0; //initial state is always set to 0.
        char[] testString = testStr.toCharArray();
        for(char symbol : testString){
            int symbolVal = numericSymbolVal(symbol);
            //check if symbol is in alphabet
            if (alphabet.contains(symbolVal)) {
                state = fsaTable[state][symbolVal];

                if (state == -1) {
                    accepted = false;
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

    public int numericSymbolVal(char val){
        int value = -1;
        if (fsaAlphaType.equals(AsciiSymbolStrings.letter.type())) {
            if ((val >= 65 && val <= 90) || (val >= 97 && val <= 122)) {//letter
                value = AsciiSymbolStrings.letter.getSymbolIntVal();
            } else if (val >= 48 && val <= 57) { //digit
                value = AsciiSymbolStrings.digit.getSymbolIntVal();
            } else if (val == 95) { //underscore
                value = AsciiSymbolStrings.underscore.getSymbolIntVal();
            } else if (val == 46) { //period
                value = AsciiSymbolStrings.period.getSymbolIntVal();
            } else if (val == 45) { //hyph
                value = AsciiSymbolStrings.hyph.getSymbolIntVal();
            } else if (val == 64) { //@
                value = AsciiSymbolStrings.at.getSymbolIntVal();
            }
        } else if (fsaAlphaType.equals(AsciiSymbolStrings.n.type())){
            if (val == 'n'){
                value = AsciiSymbolStrings.n.getSymbolIntVal();
            } else if (val == 'd'){
                value = AsciiSymbolStrings.d.getSymbolIntVal();
            } else if (val == 'q'){
                value = AsciiSymbolStrings.q.getSymbolIntVal();
            } else if (val == 's'){
                value = AsciiSymbolStrings.s.getSymbolIntVal();
            }
        } else if (fsaAlphaType.equals(AsciiSymbolStrings.a.type())) {
            if (val == 'a') {
                value = AsciiSymbolStrings.a.getSymbolIntVal();
            } else if (val == 'b') {
                value = AsciiSymbolStrings.b.getSymbolIntVal();
            }
        }else {
            value = Character.getNumericValue(val);
        }
        return value;
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


    public void setFsaAlphaType(String fsaAlphaType) {
        this.fsaAlphaType = fsaAlphaType;
    }
}
