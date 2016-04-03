package com.sudohu.generator;

import com.sudohu.generator.impl.SudokuGeneratorImpl;

/**
 * The Factory class returns an instance of the {@link SudokuGenerator}.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuGeneratorFactory {

    /**
     * Creates and returns a new instance of SudokuGenerator. 
     * @return instance of {@link SudokuGenerator}
     */
    public static SudokuGenerator getSudokuGenerator(){
        SudokuGenerator sudokuGenerator = new SudokuGeneratorImpl();
        return sudokuGenerator;
    }
}
