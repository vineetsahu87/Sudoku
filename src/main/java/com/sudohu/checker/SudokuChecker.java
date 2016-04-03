package com.sudohu.checker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class checks whether the sudoku solution is valid.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuChecker {
    
    private static final Logger LOGGER = Logger.getLogger(SudokuChecker.class.getName());
    
    /**
     * Checks if the solution for the sudoku puzzle is valid.
     * @param sudokuBoard - the solved sudoku board
     * @return true if the solution is valid, false otherwise
     */
    public static boolean isSolutionValidForSudoku(final int[][] sudokuBoard){
        if(!validateValuesInCells(sudokuBoard)){
            LOGGER.log(Level.SEVERE, "Sudoku Board contains invalid values.");
            return false;
        }
        
        for(int row=0; row<sudokuBoard.length; row++){
            if(!validateRows(sudokuBoard, row)){
                LOGGER.log(Level.SEVERE, "Sudoku Board contains invalid values in row :" + row);
                return false;
            }
        }
        
        for(int column=0; column < sudokuBoard.length; column++){
            if(!validateColumns(sudokuBoard, column)){
                LOGGER.log(Level.SEVERE, "Sudoku Board contains invalid values in column :" + column);
                return false;
            }
        }
        
        if(!validateGrids(sudokuBoard)){
            LOGGER.log(Level.SEVERE, "Sudoku Board contains invalid 3X3 girds.");
            return false;
        }
        
        return true;
    }

    /**
     * Checks if all the cells have valid values.
     * @param sudokuBoard - the filled sudoku board
     * @return true if the all the values are valid, false otherwise.
     */
    public static boolean validateValuesInCells(final int[][] sudokuBoard){
        for(int i=0; i < sudokuBoard.length ; i++){
            for(int j=0; j < sudokuBoard[0].length; j++){
                if(sudokuBoard[i][j] < 1 || sudokuBoard[i][j] > 9){                 
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Validate that the row in the sudoku board is valid i.e. there are no 
     * duplicate values in the row.
     * @param sudokuBoard - the filled sudoku board
     * @param row - the row to validate
     * @return true if the row has valid values, false otherwise.
     */
    public static boolean validateRows(final int[][] sudokuBoard, final int row){
        boolean[] arr = new boolean[sudokuBoard[0].length];
        int value = 0;
        for(int i = 0; i < sudokuBoard[0].length; i++){
            value = sudokuBoard[row][i] - 1;
            if(!arr[value]){
                arr[value] = true;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Validate that the column in the sudoku board is valid i.e. there are no 
     * duplicate values in the column.
     * @param sudokuBoard - the filled sudoku board
     * @param column - the column to validate
     * @return true if the column has valid values, false otherwise.
     */
    public static boolean validateColumns(final int[][] sudokuBoard, final int column){
        boolean[] arr = new boolean[sudokuBoard.length];
        int value = 0;
        for(int i = 0; i < sudokuBoard.length; i++){
            value = sudokuBoard[i][column] - 1;
            if(!arr[value]){
                arr[value] = true;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Validates that all the 3X3 grids are validate.
     * @param sudokuBoard - the filled sudoku board
     * @return true if all the 3X3 grid are valid, false otherwise
     */
    public static boolean validateGrids(final int[][]sudokuBoard){
        
        for(int i = 0; i < sudokuBoard.length; i = i + 3){
            for(int j = 0; j < sudokuBoard.length; j = j + 3){
                if(!validate3X3Grid(sudokuBoard, i, j)){
                    return false;
                }
            }           
        }
        return true;
    }
    
    /**
     * Validates that the 3X3 grids is validate.
     * @param sudokuBoard - the filled sudoku board
     * @param baseRow - the base row for the grid.
     * @param baseCol - the base column for the grid
     * @return true if the 3X3 grid is valid, false otherwise.
     */
    private static boolean validate3X3Grid(final int[][] sudokuBoard, final int baseRow, final int baseCol){
        boolean[] arr = new boolean[sudokuBoard.length];
        for(int i = baseRow; i < baseRow + 3; i++){
            for(int j = baseCol; j < baseCol + 3; j++){
                int value = sudokuBoard[i][j] - 1;
                if(!arr[value]){
                    arr[value] = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
