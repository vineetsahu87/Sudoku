package com.sudohu.solver.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sudohu.solver.SudokuSolver;

public class SudokuSolverRecursiveImpl implements SudokuSolver{

    private static final Logger LOGGER = Logger.getLogger(SudokuSolverRecursiveImpl.class.getName());
    
    public int[][] board;
    private long startTime;
    private long endTime;
    private long totalTime;

    public SudokuSolverRecursiveImpl(int[][] board){
        this.board = board;
    }
    
    /** 
     * Checks if num is an acceptable value for the given row 
     */
    protected boolean checkRow(int row, int num)
    {
        for(int col = 0; col < 9; col++){
            if(board[row][col] == num){
                return false;
            }
        }

        return true;
    }

    /** 
     * Checks if num is an acceptable value for the given column 
     */
    protected boolean checkCol(int col, int num)
    {
        for(int row = 0; row < 9; row++){
            if(board[row][col] == num){
                return false;
            }
        }
        return true;
    }

    /** 
     * Checks if num is an acceptable value for the box around row and col 
     */
    protected boolean checkBox(int row, int col, int num)
    {
        row = (row / 3) * 3 ;
        col = (col / 3) * 3 ;

        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if( board[row+r][col+c] == num){
                    return false;
                }
            }
        }

        return true;
    }


    /** 
     * The active part begins here 
     */
    @Override
    public int[][] call()
    {
        findSudokuSolution(board);
        return board;
    }

    @Override
    public boolean findSudokuSolution(int[][] board) {
        try{
            startTime = System.nanoTime();
            solve(0, 0) ;
        }
        catch(Exception e){
            totalTime = endTime - startTime;
            LOGGER.log(Level.FINER, "Total Execution Time: " + totalTime);
            return true;
        }
        return false;
    }
    
    /**
     *  Recursive function to find a valid number for one single cell
     */
    public void solve(int row, int col) throws Exception
    {   
        // Throw an exception to stop the process if the puzzle is solved
        if(row > 8){
            endTime = System.nanoTime();
            throw new Exception( "Solution found" ) ;
        }

        // If the cell is not empty, continue with the next cell
        if(board[row][col] != 0){
            next(row, col) ;
        } else {
            // Find a valid number for the empty cell
            for(int num = 1; num < 10; num++){
                if(checkRow(row,num) && checkCol(col,num) && checkBox(row,col,num)){
                    board[row][col] = num ;

                    // Delegate work on the next cell to a recursive call
                    next(row, col) ;
                }
            }

            // No valid number was found, clean up and return to caller
            board[row][col] = 0 ;
        }
    }

    /** 
     * Calls solve for the next cell 
     */
    public void next(int row, int col) throws Exception
    {
        if(col < 8){
            solve(row, col + 1) ;
        } else {
            solve(row + 1, 0) ;
        }
    }
}