package com.sudohu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sudohu.checker.SudokuChecker;
import com.sudohu.generator.SudokuDifficulty;
import com.sudohu.generator.SudokuGenerator;
import com.sudohu.generator.SudokuGeneratorFactory;
import com.sudohu.helper.SudokuHelper;
import com.sudohu.solver.SudokuSolver;
import com.sudohu.solver.SudokuSolverFactory;

/**
 * Main Class for executing Sudoku implementations.<br/>
 * 
 * The class can take in 2 arguments <br/>
 * 
 * First argument is for the Difficulty level of the sudoku puzzle to solve.<br/>
 * <ul>
 * <li>hard (Default)</li>
 * <li>medium</li>
 * <li>easy</li>
 * </ul>
 *  
 * Second argument is for the implementation to use for solving the sudoku puzzle.<br/> 
 * <ul>
 * <li>iterative (Default)</li>
 * <li>recursive</li>
 * </ul>
 * 
 * It will generate the sudoku board with the given difficulty level, check if the 
 * sudoku puzzle is valid for solving. Then solve the puzzle by using the implementation
 * method and finally check if the solution found is valid. <br/>
 * 
 * @author Vineet K Sahu
 *
 */
public class Sudoku {

    private static final Logger LOGGER = Logger.getLogger(Sudoku.class.getName());

    public static void main(String[] args) {

        SudokuGenerator sudokuGenerator = SudokuGeneratorFactory.getSudokuGenerator();

        SudokuDifficulty difficultyLevel = SudokuDifficulty.HARD;

        if(args.length > 0){
            if(("easy").equalsIgnoreCase(args[0])){
                difficultyLevel = SudokuDifficulty.EASY;
            }else if(("Medium").equalsIgnoreCase(args[0])){
                difficultyLevel = SudokuDifficulty.MEDIUM;
            }
            else{
                difficultyLevel = SudokuDifficulty.HARD;
            }
        }

        int[][] board = sudokuGenerator.generateSudokuPuzzle(difficultyLevel);

        if (!SudokuHelper.areCellsValidInBoard(board)){
            LOGGER.log(Level.SEVERE, "Invalid Sudoku Board. Cannot be solved");
        }

        LOGGER.log(Level.INFO, "Solving Sudoku Board");
        SudokuHelper.printBoard(board);

        String solverType = null;
        if(args.length > 1){
            solverType = args[1];
        }

        SudokuSolver sudokuSolver = SudokuSolverFactory.getSudokuSolver(board, solverType);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<int[][]> task = executorService.submit(sudokuSolver);
        
        try {
            board = task.get();
            LOGGER.log(Level.INFO, "Solved Sudoku Board");
            SudokuHelper.printBoard(board);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.SEVERE, "Error Occured while trying to get the Sudoku solution", e);
        }

        SudokuChecker.isSolutionValidForSudoku(board);
        executorService.shutdown();
    }

}
