package com.sudohu.solver;

import java.util.concurrent.Callable;

/**
 * The SudokuSolver interface can be implemented by any class
 * providing an Sudoku Solution given a 9 X 9 sudoku board.
 * 
 * @author Vineet K Sahu
 *
 */
public interface SudokuSolver extends Callable<int[][]>{
    
    /**
     * Searches for the sudoku solution for the given board.
     * @param board - Sudoku board to be solved
     * @return true if the solution is found false otherwise.
     */
    public boolean findSudokuSolution(int[][] board);
}
