package com;

import com.model.Fsa;
import com.model.FsaReadInput;
import com.model.FsaWriteOutput;

public class Main {

    public static void main(String[] args) {
        FsaReadInput input = new FsaReadInput();
        Fsa fsa = input.setNextFsa();
        System.out.println("FSA ALPHA " + fsa.getAlphabet());
        FsaWriteOutput output = new FsaWriteOutput();

        output.appendToFile(fsa);
    }
}
