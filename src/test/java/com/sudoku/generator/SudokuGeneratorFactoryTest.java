package com.sudoku.generator;

import org.junit.Test;
import org.junit.Assert;

import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.SudokuGeneratorFactory;
import com.sudohu.generator.impl.SudokuGeneratorImpl;

/**
 * Tests {@link SudokuGeneratorFactory}.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuGeneratorFactoryTest {

    @Test
    public void testGetSudokuGenerator(){
        SudokuGenerator sudokuGenerator = SudokuGeneratorFactory.getSudokuGenerator();
    
        Assert.assertTrue("SudokuGeneratorFactory returned incorrect instance of sudokuGenerator",
                         sudokuGenerator instanceof SudokuGeneratorImpl);
    }
}
