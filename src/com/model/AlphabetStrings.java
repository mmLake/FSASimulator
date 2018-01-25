package com.model;

/**
 * Created by mayalake on 1/24/18.
 */
enum AlphabetStrings{
    letter() {
        public int numericVal(){return 0;}
    },

    digit(){
        public int numericVal(){return 1;}
    },
    hyph(){
        public int numericVal(){return 2;}
    },
    underscore(){
        public int numericVal(){return 3;}
    },
    period(){
        public int numericVal(){return 4;}
    },
    at(){
        public int numericVal(){return 5;}
    };

    public abstract int numericVal();
}