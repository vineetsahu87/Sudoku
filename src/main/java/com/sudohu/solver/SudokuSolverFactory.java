package com.sudohu.solver;

import com.sudohu.solver.impl.SudokuSolverIterativeImpl;
import com.sudohu.solver.impl.SudokuSolverRecursiveImpl;

public class SudokuSolverFactory {

    public static SudokuSolver getSudokuSolver(int[][] board, String type){
        if(("Recursive").equalsIgnoreCase(type)){
            return new SudokuSolverRecursiveImpl(board);
        }else if(("Iterative").equalsIgnoreCase(type)){
            return new SudokuSolverIterativeImpl(board);
        }
        return new SudokuSolverIterativeImpl(board);
    }
}
