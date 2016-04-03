package com.sudoku.helper;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.SudokuGeneratorFactory;
import com.sudohu.helper.SudokuHelper;

/**
 * Test {@link SudokuHelper} functionality.
 * @author Vineet K Sahu
 *
 */
public class SudokuHelperTest {

    @Ignore
    public void testPrintBoard(){
        SudokuGenerator sudokuGenerator = SudokuGeneratorFactory.getSudokuGenerator();
        int[][] board = sudokuGenerator.generatePopulateBoard();
        
        SudokuHelper.printBoard(board);
    }
    
    @Test
    public void testAreCellsValidInBoardWithValidBoard(){
        int[][] sudokuBoard = {{9,4,1,3,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3}, 
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,8,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertTrue("areCellsValidInBoard returned incorrect result.", 
                   SudokuHelper.areCellsValidInBoard(sudokuBoard));     
    }
    
    @Test
    public void testAreCellsValidInBoardWithInvalidBoard(){
        int[][] sudokuBoard = {{9,9,1,3,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3}, 
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,8,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertFalse("areCellsValidInBoard returned incorrect result.", 
                   SudokuHelper.areCellsValidInBoard(sudokuBoard));     
    }
    
    @Test
    public void testIsCellValidInBoardWithValidValue(){
        int[][] sudokuBoard = {{9,4,1,3,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3}, 
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,8,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertTrue("isCellValidInBoard returned incorrect result.", 
                           SudokuHelper.isCellValidInBoard(0, 3, sudokuBoard));
    }
    
    @Test
    public void testIsCellValidInBoardWithInvalidRow(){
        int[][] sudokuBoard = {{9,4,1,8,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3}, 
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,0,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertFalse("isCellValidInBoard returned incorrect result.", 
                            SudokuHelper.isCellValidInBoard(0, 3, sudokuBoard));
    }
    
    @Test
    public void testIsCellValidInBoardWithInvalidColumn(){
        int[][] sudokuBoard = {{9,4,1,3,2,6,7,5,8},
                               {6,3,7,1,5,8,2,4,9},
                               {8,2,5,4,9,7,6,1,3}, 
                               {2,6,8,7,1,4,3,9,5},
                               {1,7,4,5,3,9,8,6,2},
                               {3,5,9,6,8,2,4,7,1},
                               {4,1,3,2,6,5,9,8,7},
                               {5,9,6,3,7,3,1,2,4},
                               {7,8,2,9,4,1,5,3,6}};
        Assert.assertFalse("isCellValidInBoard returned incorrect result.", 
                            SudokuHelper.isCellValidInBoard(0, 3, sudokuBoard));
    }
    
    @Test
    public void testIsCellValidInBoardWithInvalid3X3Grid(){
        int[][] sudokuBoard = {{9,4,1,3,2,6,7,5,8},
                               {0,0,0,1,5,8,0,0,0},
                               {0,0,0,4,3,7,0,0,0}, 
                               {0,0,0,0,0,0,0,0,0},
                               {0,0,0,0,0,0,0,0,0},
                               {0,0,0,0,0,0,0,0,0},
                               {0,0,0,0,0,0,0,0,0},
                               {0,0,0,0,0,0,0,0,0},
                               {0,0,0,0,0,0,0,0,0}};
        Assert.assertFalse("isCellValidInBoard returned incorrect result.", 
                            SudokuHelper.isCellValidInBoard(0, 3, sudokuBoard));
    }
}
