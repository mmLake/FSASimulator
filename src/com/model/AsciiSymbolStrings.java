package com.model;

/**
 * Created by mayalake on 1/24/18.
 */
enum AsciiSymbolStrings {
    letter(0),
    digit(1),
    hyph(2),
    underscore(3),
    period(4),
    at(5);

    private final int symbolIntVal;

    AsciiSymbolStrings(int symbolIntVal){
        this.symbolIntVal = symbolIntVal;
    }

    public int getSymbolIntVal(){
        return this.symbolIntVal;
    }

}