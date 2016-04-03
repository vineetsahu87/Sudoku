package com.sudohu.generator;

/**
 * The Enum class defines the difficulty level of the 
 * sudoku puzzle.<br/> <br/>
 *
 * Easy contains 40 blank cells.<br/>
 * Medium contains 50 blank cells.<br/>
 * Hard contains 65 blank cells.<br/>
 *  
 * @author Vineet K Sahu
 *
 */
public enum SudokuDifficulty{
    EASY(40),
    MEDIUM(50),
    HARD(65);
    
    int value;
    
    private SudokuDifficulty(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}