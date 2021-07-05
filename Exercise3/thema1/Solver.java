package Exercise3.thema1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solver {

    private static Scanner sudokuFile;

    /**
     * - Check args parameters
     * - Read sudoku puzzle file
     * - Create new Sudoku object by using solver()
     * - Display sudoku puzzle before and after been solved
     *
     * @param args arg[0], arg[1]
     */
    public static void main(String[] args) {

        int choice = validateArguments(args);                   //1.- Check and validate args parameters
        int[][] sudokuPuzzle = readFile(args[0]);               //2.- Read initial sudoku puzzle file with readFile()

        SudokuStructure structure = selectStructure(choice);
        Sudoku sudoku = new Sudoku(sudokuPuzzle, structure);    //3.- Create new Sudoku object


        sudoku.displaySudoku();                                 //4.- Display initial sudoku puzzle
        sudoku.solve();                                         //5.- Calls the .solve() to solve the puzzle


        if (sudoku.solve()) {
            sudoku.displaySudoku();                             //6.- Display solved sudoku puzzle, if true condition
            System.out.println(" #Sudoku puzzle is solved!#");
        } else {
            System.out.println("#Sudoku puzzle has no solution!#");
        }
    }

    /**
     * - Validates arguments given as program args from the user
     *
     * @param args String
     * @return int
     */
    private static int validateArguments(String[] args) {
        int choice = 0;

        // 1) check number of parameters, must be 2
        if (args.length < 2 || args[0].isBlank() || args[1].isBlank()) {
            System.out.println("Invalid number of arguments");
            System.exit(0);
        }
        // 2) check if args[1} is a right integer between 1,2,3,4
        try {
            choice = Integer.parseInt(args[1]);

            if (choice < 1 || choice > 4) {
                //when input is anything else than 1,2,3, or 4 it throws exception
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid structure number. You must type a number between 1 to 4");
            System.exit(0);
        }
        return choice;
    }


    /**
     * - Takes the args[0] and reads the file (.txt)
     * - Validates the file (.txt)
     *
     * @param filename String
     * @return int[][]
     */
    private static int[][] readFile(String filename) {
        int[][] sudokuPuzzle = new int[9][9];

        //1.- Validates that file exist
        try {
            sudokuFile = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        //2.- Validates that file is not empty
        if (!sudokuFile.hasNextLine()) {
            System.out.println("The File is empty");
            System.exit(0);
        } else {

            while (sudokuFile.hasNextLine()) {

                //3.- Iterates file lines and parses the numbers into 2d array sudoku puzzle[][]
                for (int i = 0; i < sudokuPuzzle.length; i++) {
                    String[] line = sudokuFile.nextLine().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        sudokuPuzzle[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
        }
        //4.- Return initial puzzle
        return sudokuPuzzle;
    }

    /**
     * (D)
     * 1 - ArrayList Class as Stack
     * 2 - ArrayList Class as Queue
     * 3 - Stack Class
     * 4 - LinkedList as Queue
     */
    private static SudokuStructure selectStructure(int method) {

        //According to the args[1] we gave, creates & returns Structure objects and prints the method to the terminal
        switch (method) {
            case 1:
                System.out.println("# Solving with ArrayList Class as Stack #");
                new AlsStackStructure();
                break;
            case 2:
                System.out.println("# Solving with ArrayList Class as Queue #");
                new AlsQueueStructure();
                break;
            case 3:
                System.out.println("# Solving with Stack Class #");
                new StackStructure();
                break;
            case 4:
                System.out.println("# Solving with LinkedList as Queue #");
                new LlQueueStructure();
                break;
        }
        //Need to return sth as default
        return new AlsStackStructure();
    }
}
