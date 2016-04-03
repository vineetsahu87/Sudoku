package com.sudohu.generator;

/**
 * The interface should be implemented by a class which provides 
 * method to generate the sudo board with diffculty level defined
 * in {@link SudokuDifficulty}.
 * 
 * @author Vineet K Sahu
 *
 */
public interface SudokuGenerator {
    
    public static final int BOARD_WIDTH = 9;
    public static final int BOARD_HEIGHT = 9;
    
    /**
     * Returns a board populated with valid value which is a valid sudoku board.
     * @return a board with dimensions of BOARD_WIDTH and BOARD_HEIGHT
     */
    public int[][] generatePopulateBoard();
    
    /**
     *Given a completed board, replace a given amount of cells with 0s
     *(to represent blanks) 
     * @param board - A board with dimension of BOARD_HEIGHT and BOARD_WIDTH
     * @param difficultyLevel - the difficulty level for the board to create.
     * @return board - a partially completed 9x9 Sudoku board
     */
    public void emptyFilledCells(int[][] board, SudokuDifficulty difficultyLevel);
    
    /**
     * The method generates a board with the given difficulty level.
     *@param difficulty the number of blank spaces to insert
     *@return board - a partially completed 9x9 Sudoku board
     */
    public int[][] generateSudokuPuzzle(SudokuDifficulty difficulty);
}
