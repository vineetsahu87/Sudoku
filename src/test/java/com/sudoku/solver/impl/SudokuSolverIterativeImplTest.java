package com.sudoku.solver.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.sudohu.checker.SudokuChecker;
import com.sudohu.generator.SudokuDifficulty;
import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.SudokuGeneratorFactory;
import com.sudohu.solver.impl.SudokuSolverIterativeImpl;

/**
 * Tests the {@link SudokuSolverIterativeImpl} functionality.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuSolverIterativeImplTest {

    private int[][] board;
    private SudokuSolverIterativeImpl sudokuSolverImpl;
    
    @Before
    public void setUp(){
        SudokuGenerator sudokuGenerator = SudokuGeneratorFactory.getSudokuGenerator();
        board = sudokuGenerator.generateSudokuPuzzle(SudokuDifficulty.HARD);
        sudokuSolverImpl = new SudokuSolverIterativeImpl(board);
    }
    
    @Test
    public void testGetEmptyCellList(){
        int[][] grid = {{0,3,0},{1,0,0},{0,0,5}};
        int[][] expected = {{0,0},{0,2},{1,1},{1,2},{2,0},{2,1}};
        
        int[][] actual = sudokuSolverImpl.getEmptyCellList(grid);
        
        Assert.assertArrayEquals("getEmptyCellList returned incorrect result", expected, actual);
    }
    
    @Test
    public void testFindSudokuSolution(){       
        sudokuSolverImpl.findSudokuSolution(board);
        
        Assert.assertTrue("The findSudokuSolution found incorrect soultion.", SudokuChecker.isSolutionValidForSudoku(board));
    }
}
