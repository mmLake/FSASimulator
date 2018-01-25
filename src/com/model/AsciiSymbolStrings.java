package com.model;

/**
 * Created by mayalake on 1/24/18.
 */
enum AsciiSymbolStrings {
    letter(0){
        public String type(){
            return "letter";
        }
    },
    digit(1){
        public String type(){
            return "letter";
        }
    },
    hyph(2){
        public String type(){
            return "letter";
        }
    },
    underscore(3){
        public String type(){
            return "letter";
        }
    },
    period(4){
        public String type(){
            return "letter";
        }
    },
    at(5){
        public String type(){
            return "letter";
        }
    },
    n(0){
        public String type(){
            return "money";
        }
    },
    d(1){
        public String type(){
            return "money";
        }
    },
    q(2){
        public String type(){
            return "money";
        }
    },
    s(3){
        public String type(){
            return "money";
        }
    },
    a(0){
        public String type(){
            return "ab";
        }
    },
    b(1){
        public String type(){
            return "ab";
        }
    };

    public abstract String type();
    private final int symbolIntVal;

    AsciiSymbolStrings(int symbolIntVal){
        this.symbolIntVal = symbolIntVal;
    }

    public int getSymbolIntVal(){
        return this.symbolIntVal;
    }

}