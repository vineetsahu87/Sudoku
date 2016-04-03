package com.sudoku.generator.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.sudohu.checker.SudokuChecker;
import com.sudohu.generator.SudokuDifficulty;
import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.impl.SudokuGeneratorImpl;
import com.sudohu.helper.SudokuHelper;

/**
 * Tests the {@link SudokuGeneratorImpl} functionality.
 * @author Vineet K Sahu
 *
 */
public class SudokuGeneratorImplTest {
    
    private SudokuGenerator sudokuGenerator;
    
    @Before
    public void setUp(){
        sudokuGenerator = new SudokuGeneratorImpl();    
    }
    
    @Test
    public void testGeneratePopulateBoard(){
        int[][] board = sudokuGenerator.generatePopulateBoard();
        
        Assert.assertTrue("SudokuGenerator generated a invalid board", SudokuChecker.isSolutionValidForSudoku(board));
    }
    
    @Test
    public void testEmptyFilledCellsWithSudokuDifficultyEasy(){
        int[][] board = sudokuGenerator.generatePopulateBoard();
        sudokuGenerator.emptyFilledCells(board, SudokuDifficulty.EASY);
        int numberOfEmptyCells = 0;
        
        for(int i=0; i<SudokuGenerator.BOARD_WIDTH; i++){
            for(int j=0; j<SudokuGenerator.BOARD_HEIGHT; j++){
                if(board[i][j] ==0){
                    numberOfEmptyCells++;
                }
            }
        }
        
        Assert.assertEquals("EmptyFilledCells created board with incorrect difficulty level.",
                             SudokuDifficulty.EASY.getValue(), numberOfEmptyCells);
        Assert.assertTrue("Invalid cells in the board", SudokuHelper.areCellsValidInBoard(board));
    }
    
    @Test
    public void testEmptyFilledCellsWithSudokuDifficultyMedium(){
        int[][] board = sudokuGenerator.generatePopulateBoard();
        sudokuGenerator.emptyFilledCells(board, SudokuDifficulty.MEDIUM);
        int numberOfEmptyCells = 0;
        
        for(int i=0; i<SudokuGenerator.BOARD_WIDTH; i++){
            for(int j=0; j<SudokuGenerator.BOARD_HEIGHT; j++){
                if(board[i][j] ==0){
                    numberOfEmptyCells++;
                }
            }
        }
        
        Assert.assertEquals("EmptyFilledCells created board with incorrect difficulty level.",
                             SudokuDifficulty.MEDIUM.getValue(), numberOfEmptyCells);
        Assert.assertTrue("Invalid cells in the board", SudokuHelper.areCellsValidInBoard(board));
    }

    @Test
    public void testEmptyFilledCellsWithSudokuDifficultyHard(){
        int[][] board = sudokuGenerator.generatePopulateBoard();
        sudokuGenerator.emptyFilledCells(board, SudokuDifficulty.HARD);
        
        int numberOfEmptyCells = 0;
        for(int i=0; i<SudokuGenerator.BOARD_WIDTH; i++){
            for(int j=0; j<SudokuGenerator.BOARD_HEIGHT; j++){
                if(board[i][j] ==0){
                    numberOfEmptyCells++;
                }
            }
        }
        
        Assert.assertEquals("EmptyFilledCells created board with incorrect difficulty level.",
                             SudokuDifficulty.HARD.getValue(), numberOfEmptyCells);
        Assert.assertTrue("Invalid cells in the board", SudokuHelper.areCellsValidInBoard(board));
    }
    
    @Test
    public void testGenerateSudokuPuzzle(){
        int[][] board = sudokuGenerator.generateSudokuPuzzle(SudokuDifficulty.EASY);
        
        int numberOfEmptyCells = 0;
        for(int i=0; i<SudokuGenerator.BOARD_WIDTH; i++){
            for(int j=0; j<SudokuGenerator.BOARD_HEIGHT; j++){
                if(board[i][j] ==0){
                    numberOfEmptyCells++;
                }
            }
        }
        
        Assert.assertEquals("Sudoku board created has incorrect difficulty level.",
                            SudokuDifficulty.EASY.getValue(), numberOfEmptyCells);
        Assert.assertTrue(SudokuHelper.areCellsValidInBoard(board));
        
    }
}
