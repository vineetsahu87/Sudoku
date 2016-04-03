package com.sudohu.helper;

/**
 * Helper class with general methods that can be 
 * used across the project.
 * 
 * @author Vineet K Sahu
 */
public class SudokuHelper {

    /**
     * Print the board in the console
     * @param board - board to be printed
     */
    public static void printBoard(int[][] board)
    {
        for(int i=0; i<board.length + 1; i++){
            if(i%3 ==0){
                System.out.println("----------------------------------");
            }
            for(int j=0; j<board[0].length + 1 ; j++){
                if(j%3 == 0 && i < board.length){
                    System.out.print("| ");
                }
                if(i < board.length && j < board[0].length){
                    System.out.print(board[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Check whether the fixed cells are valid in the board
     * 
     * @param board - the entire sudoku board
     * 
     * @return true if the cell is valid in board false otherwise.
     */
    public static boolean areCellsValidInBoard(final int[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] < 0 || board[i][j] > 9 ||
                        (board[i][j] != 0 && !isCellValidInBoard(i, j, board))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether board[i][j] is valid in the board
     * 
     * @param row - row number of the board to validate
     * @param col - column number of the board to validate
     * @param board - the entire sudoku board
     * 
     * @return true if the cell is valid in board false otherwise.
     */
    public static boolean isCellValidInBoard(final int row, final int col, final int[][] board) {
        if(!checkRow(row,col,board)){
            return false;
        }
        if(!checkColumn(row,col,board)){
            return false;
        }
        if(!check3X3Grid(row,col,board)){
            return false;
        }
        return true;
    }

    /**
     * Checks if cell is an acceptable value for the given row
     * 
     * @param row - row number of the board to validate
     * @param column - column number of the board to validate
     * @param board - the entire sudoku board
     * 
     * @return true if the cell is valid in board false otherwise.
     */
    private static boolean checkRow(final int row, final int column, final int[][] board)
    {
        for (int i = 0; i < board.length; i++){
            if (i != column && board[row][i] == board[row][column]){
                return false;
            }
        }
        return true ;
    }

    /**
     * Checks if cell is an acceptable value for the given column
     * 
     * @param row - row number of the board to validate
     * @param column - column number of the board to validate
     * @param board - the entire sudoku board
     * 
     * @return true if the cell is valid in board false otherwise.
     */
    private static boolean checkColumn(final int row, final int column, final int[][] board)
    {
        for (int i = 0; i < board[0].length; i++){
            if (i != row && board[i][column] == board[row][column]){
                return false;
            }
        }

        return true ;
    }

    /**
     * Checks if cell is an acceptable value for the box around row and col
     * 
     * @param row - row number of the board to validate
     * @param column - column number of the board to validate
     * @param board - the entire sudoku board
     *  
     * @return true if the cell is valid in board false otherwise.
     */
    private static boolean check3X3Grid(final int row, final int column, final int[][] board)
    {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++){
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++){
                if (i != row && j != column && board[row][column] == board[i][j]){
                    return false;
                }
            }
        }
        return true ;
    }
}
