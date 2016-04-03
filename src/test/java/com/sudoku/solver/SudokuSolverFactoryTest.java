package com.sudoku.solver;

import org.junit.Test;
import org.junit.Assert;

import com.sudohu.solver.SudokuSolver;
import com.sudohu.solver.SudokuSolverFactory;
import com.sudohu.solver.impl.SudokuSolverIterativeImpl;
import com.sudohu.solver.impl.SudokuSolverRecursiveImpl;

/**
 * Tests {@link SudokuSolverFactory}.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuSolverFactoryTest {

    @Test
    public void testGetSudokuSolverWithIterativeSolution(){
        int[][] board = {};
        String solutionType = "iterative";
        SudokuSolver sudokuSolver = SudokuSolverFactory.getSudokuSolver(board, solutionType);
    
        Assert.assertTrue("SudokuSolverFactory returned incorrect instance of sudokuSolver",
                           sudokuSolver instanceof SudokuSolverIterativeImpl);
    }
    
    @Test
    public void testGetSudokuSolverWithRecursiveSolution(){
        int[][] board = {};
        String solutionType = "recursive";
        SudokuSolver sudokuSolver = SudokuSolverFactory.getSudokuSolver(board, solutionType);
    
        Assert.assertTrue("SudokuSolverFactory returned incorrect instance of sudokuSolver",
                          sudokuSolver instanceof SudokuSolverRecursiveImpl);
    }
}
