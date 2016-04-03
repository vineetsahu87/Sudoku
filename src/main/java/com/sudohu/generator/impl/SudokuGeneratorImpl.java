package com.sudohu.generator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sudohu.generator.SudokuDifficulty;
import com.sudohu.generator.SudokuGenerator;

/**
 * Implements the {@link SudokuGenerator} interface.
 * 
 * @author Vineet K Sahu
 *
 */
public class SudokuGeneratorImpl implements SudokuGenerator {
        
    @Override
    public int[][] generatePopulateBoard(){
        int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];
        int row = 0;
        int col = 0;
        List<Integer> validValues = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            validValues.add(i);
        }

        Collections.shuffle(validValues);

        while(true){
            for(int i=0; i<validValues.size(); i++){
                if(isValueValidForCell(board, row, col, validValues.get(i))){
                    board[row][col] = validValues.get(i);
                    if(row == (BOARD_WIDTH-1) && col == (BOARD_HEIGHT-1)){
                        return board;
                    }else if(row == (BOARD_WIDTH-1) && col != (BOARD_HEIGHT-1)){            
                        row = 0;
                        col = col + 1;
                    }else{
                        row = row + 1;
                    }
                }
            }
            board[row][col] = 0;
        }
    }

    @Override
    public void emptyFilledCells(int[][] board, SudokuDifficulty difficultyLevel){
        double remainingClues = BOARD_WIDTH * BOARD_HEIGHT;
        double remainingEmptyCells = (double)difficultyLevel.getValue();

        for(int row=0; row<BOARD_WIDTH; row++){
            for(int col=0; col<BOARD_HEIGHT; col++){
                double emptyCellChance = remainingEmptyCells/remainingClues;                
                if(Math.random() <= emptyCellChance){
                    board[row][col] = 0;
                    remainingEmptyCells--;
                }
                remainingClues--;
            }
        }
    }
    
    @Override
    public int[][] generateSudokuPuzzle(SudokuDifficulty difficulty){       
        int[][] board = generatePopulateBoard();
        emptyFilledCells(board, difficulty);
        return board;
    }
    
    /**
     *Given a cell's coordinates and a possible number for that cell,
     *determine if that number can be inserted into said cell legally.
     *
     *@param board the sudoku board
     *@param row   row value of cell
     *@param col   column value of cell
     *@param value The value to check in said cell.
     *
     *@return True if current is legal, false otherwise.
     */
    private boolean isValueValidForCell(final int[][] board, final int row, final int col, final int value) {
        //Check if the value is valid for the row 
        for(int i=0; i< BOARD_WIDTH; i++) {
            if(value == board[row][i])
                return false;
        }
        //Check if the value is valid for the column
        for(int i=0; i< BOARD_HEIGHT; i++) {
            if(value == board[i][col])
                return false;
        }
        
        //Check if the value is valid for the 3x3 block.
        int cornerX = 0;
        int cornerY = 0;
        if(row > 2){
            if(row > 5){
                cornerX = 6;
            }else{
                cornerX = 3;
            }
        }
        if(col > 2){
            if(col > 5){
                cornerY = 6;
            }else{
                cornerY = 3;
            }
        }
        for(int i=cornerX; i<cornerX+3; i++){
            for(int j=cornerY; j<cornerY+3; j++){
                if(value == board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
