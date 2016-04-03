package com.sudohu.solver.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sudohu.exceptions.NoSolutionFoundException;
import com.sudohu.helper.SudokuHelper;
import com.sudohu.solver.SudokuSolver;

/**
 * The Class gives an iterative implementation for {@link SudokuSolver}
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuSolverIterativeImpl implements SudokuSolver{
    
    private static final Logger LOGGER = Logger.getLogger(SudokuSolverIterativeImpl.class.getName());
    
    public int[][] board;
    
    public SudokuSolverIterativeImpl(int[][] board){
        this.board = board;
    }
        
    /**
     * Obtain a list of empty cells from the board
     * 
     * @param board - board for which empty cells have to be found
     * 
     * @return 2D array containing the position of the empty cells
     */
    public int[][] getEmptyCellList(final int[][] board) {
        // Determine the number of empty cells
        int numberofEmptyCells = 0;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    numberofEmptyCells++;
                }
            }

        }

        // Store empty cell positions into emptyCellList
        int[][] emptyCellList = new int[numberofEmptyCells][2];
        int count = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 0) {
                    emptyCellList[count][0] = i;
                    emptyCellList[count++][1] = j;
                }
            }
        }

        return emptyCellList;
    }
    
    @Override
    public boolean findSudokuSolution(int[][] board) {
        int[][] emptyCellList = getEmptyCellList(board);

        if (emptyCellList.length == 0){
            return true;
        }

        int k = 0; // Start from the first free cell
        while (true) {
            int row = emptyCellList[k][0];
            int col = emptyCellList[k][1];

            if (board[row][col] == 0){
                board[row][col] = 1; // Assign free cell number 1
            }

            if (SudokuHelper.isCellValidInBoard(row, col, board)) {
                if (k + 1 == emptyCellList.length) {
                    return true;
                } else {
                    k++;
                }
            } else if (board[row][col] < 9) {
                // Assign the free cell the next possible value
                board[row][col] = board[row][col] + 1;

            } else { //backtrack
                while (board[row][col] == 9) {
                    if (k == 0) {
                        return false;
                    }
                    board[row][col] = 0;
                    k--; // Backtrack to the preceding free cell
                    row = emptyCellList[k][0];
                    col = emptyCellList[k][1];
                }
                board[row][col] = board[row][col] + 1;
            }
        }
    }
    
    @Override
    public int[][] call() throws Exception {
        long startTime = System.nanoTime();
        if (!findSudokuSolution(board)) {
            throw new NoSolutionFoundException("No Solution Found for the Sudoku Puzzle.");
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        LOGGER.log(Level.FINER, "Total Exceution Time : " + totalTime);
        return board;
    }
}