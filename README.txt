To run the Sudoku project simply type the following command in the command line where the jar exists

USAGE : java -jar Sudoku-1.0.0.jar

By default if no arguments are passed then the difficulty level of the sudoku Puzzle would be Hard and it would 
use the iterative method to find the solution.

To specify the difficulty level of the sudoku puzzle the following arguments can be passed
- hard
- medium
- easy

USAGE : java -jar Sudoku-1.0.0.jar <DIFFICULTY_LEVEL>

USAGE EXAMPLE: java -jar Sudoku-1.0.0.jar hard


The second argument can be used to specify the type of solution to use to find the sudoku solution
- iterative
- recursive

USAGE : java -jar Sudoku-1.0.0.jar <DIFFICULTY_LEVEL> <SOLUTION_TYPE>

USAGE EXAMPLE: java -jar Sudoku-1.0.0.jar hard recursive

REQUIREMENTS:
JRE 1.7 or higher is recommended to run the jar since the project was compiled using JRE 1.7.0_80.

Maven was used to built the project. Make sure that maven is installed on the system and is set in the environment variables under M2_HOME.
For make the project ready for importing in eclipse use the following command in the command line:

    mvn eclipse:clean eclipse:eclipse

Once the command is successful the project is ready to be imported in the eclipse workspace.