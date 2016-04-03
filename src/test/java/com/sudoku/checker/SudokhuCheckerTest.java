package com.sudoku.checker;

import org.junit.Test;
import org.junit.Assert;

import com.sudohu.checker.SudokuChecker;

/**
 * Tests {@link SudokuChecker} functionality.
 * @author Vineet K Sahu
 *
 */
public class SudokhuCheckerTest {

    @Test
    public void testValidateValuesInCellsWithInvalidSudokuRow(){
        int[][] invalidSudokuRow = {{9,8,7,6,5,4,3,2,10}};

        Assert.assertFalse("Vaidate Value in cells returned incorrect result",SudokuChecker.validateValuesInCells(invalidSudokuRow));
    }

    @Test
    public void testValidateValuesInCellsWithValidSudokuRow(){
        int[][] validSudokuRow = {{9,8,7,6,5,4,3,2,1}};

        Assert.assertTrue("Vaidate Value in cells returned incorrect result",SudokuChecker.validateValuesInCells(validSudokuRow));
    }


    @Test
    public void testValidateRows(){
        int[][] board = {{9,8,7,6,5,4,3,2,1},
                         {1,2,3,4,5,6,1,8,9}};

        Assert.assertTrue("Validate Row returned incorrect result.",SudokuChecker.validateRows(board, 0));
        Assert.assertFalse("Validate Row returned incorrect result.",SudokuChecker.validateRows(board, 1));
    }

    @Test
    public void testValidateColumns(){
        int[][] board = {{9,1},{8,2},{7,3},{6,4},{5,5},{4,1},{3,7},{2,8},{1,9}};
        Assert.assertTrue("Validate Column returned incorrect result.", SudokuChecker.validateColumns(board, 0));
        Assert.assertFalse("Validate Column returned incorrect result.", SudokuChecker.validateColumns(board, 1));
    }

    @Test
    public void testValidateGridsWithValidGrids(){
        int[][] sudokuBoard = new int[9][9];

        for(int i = 0; i < sudokuBoard.length; i = i + 3){
            for(int j = 0; j < sudokuBoard.length; j = j + 3){
                int value = 0;
                for(int baseRow = i; baseRow < i + 3; baseRow++){
                    for(int baseCol = j; baseCol < j + 3; baseCol++){
                        sudokuBoard[baseRow][baseCol] = ++value; 
                    }
                }
            }
        }

        Assert.assertTrue("ValidateGrids returned incorrect result", SudokuChecker.validateGrids(sudokuBoard));
    }

    @Test
    public void testValidateGridsWithInvalidGrids(){
        int[][] sudokuBoard = new int[9][9];

        for(int i = 0; i < sudokuBoard.length; i = i + 3){
            for(int j = 0; j < sudokuBoard.length; j = j + 3){
                int value = 0;
                for(int baseRow = i; baseRow < i + 3; baseRow++){
                    for(int baseCol = j; baseCol < j + 3; baseCol++){
                        sudokuBoard[baseRow][baseCol] = ++value; 
                    }
                }
            }
        }

        sudokuBoard[5][5] = sudokuBoard[3][3];

        Assert.assertFalse("ValidateGrids returned incorrect result", SudokuChecker.validateGrids(sudokuBoard));
    }

    @Test
    public void testIsSolutionValidForSudokuWithValidSudokuBoard(){
        int[][] sudokuBoard = {{9,4,1,3,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3},
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,8,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertTrue("isSudokuValid returned incorrect result.", SudokuChecker.isSolutionValidForSudoku(sudokuBoard));
    }
    
    @Test
    public void testIsSolutionValidForSudokuWithInvalidSudokuGrid(){
        int[][] sudokuBoard = {{9,4,1,6,3,7,8,2,5},
                               {3,2,6,1,5,8,4,9,7},
                               {7,5,8,2,4,9,6,1,3},
                               {2,6,8,1,7,4,3,5,9},
                               {1,1,4,5,3,9,6,8,2},
                               {3,9,5,8,6,2,4,7,1},
                               {4,1,3,5,9,6,7,8,2},
                               {2,6,5,8,7,3,9,4,1},
                               {9,8,7,1,2,4,5,3,6}};
        Assert.assertFalse("isSudokuValid returned incorrect result.", SudokuChecker.isSolutionValidForSudoku(sudokuBoard));
    }
}
