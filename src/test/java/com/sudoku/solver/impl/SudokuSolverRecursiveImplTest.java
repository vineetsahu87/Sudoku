package com.sudoku.solver.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.sudohu.checker.SudokuChecker;
import com.sudohu.generator.SudokuDifficulty;
import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.SudokuGeneratorFactory;
import com.sudohu.solver.impl.SudokuSolverRecursiveImpl;

/**
 * Test the {@link SudokuSolverRecursiveImpl} functionality.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuSolverRecursiveImplTest {

    private int[][] board;
    private SudokuSolverRecursiveImpl sudokuSolverRecursiveImpl;
    
    @Before
    public void setUp(){
        SudokuGenerator sudokuGenerator = SudokuGeneratorFactory.getSudokuGenerator();
        board = sudokuGenerator.generateSudokuPuzzle(SudokuDifficulty.HARD);
        sudokuSolverRecursiveImpl = new SudokuSolverRecursiveImpl(board);
    }
    
    @Test
    public void testFindSudokuSolution(){
        sudokuSolverRecursiveImpl.findSudokuSolution(board);
        
        Assert.assertTrue("The findSudokuSolution found incorrect soultion.", SudokuChecker.isSolutionValidForSudoku(board));
    }
}
