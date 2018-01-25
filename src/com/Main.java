/*
Maya Lake
Compile java files, which must be in same directory.
Execute main method.
 */

package com;

import com.model.Fsa;
import com.model.FsaReadInput;
import com.model.FsaWriteOutput;

public class Main {

    public static void main(String[] args) {
        FsaReadInput input = new FsaReadInput();
        Fsa fsa;
        FsaWriteOutput output = new FsaWriteOutput();

        while ((fsa  = input.setNextFsa()) != null){
            output.appendToFile(fsa);
        }
    }
}
