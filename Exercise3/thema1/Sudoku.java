package Exercise3.thema1;

public class Sudoku {

    private int[][] puzzle;
    private SudokuStructure structure;

    /**
     * - Constructor assigns this.puzzle & this.structure and adds the initial puzzle to the structure
     *
     * @param sudokuPuzzle int[][]
     * @param structure    SudokuStructure
     */
    public Sudoku(int[][] sudokuPuzzle, SudokuStructure structure) {

        this.puzzle = sudokuPuzzle;
        this.structure = structure;
        this.structure.pushPuzzle(sudokuPuzzle);
    }

    /**
     * - Prints the sudoku board in an easy to read format.
     */
    public void displaySudoku() {

        System.out.println("\n   *** SUDOKU PUZZLE *** ");

        for (int[] ints : this.puzzle) {
            System.out.print("\n");
            for (int j = 0; j < this.puzzle.length; j++) {
                if (ints[j] == 0) {
                    System.out.print(" X ");  //print X instead of 0(zero)
                } else {
                    System.out.print(" " + ints[j] + " ");
                }
            }
        }
        System.out.println("\n");
    }

    /**
     * - Iterates array to check for empty cells (0)
     *
     * @param array int[][]
     * @return boolean
     */
    private boolean hasEmptyCells(int[][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array.length; column++) {
                if (array[row][column] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * - Takes an array and returns its copy
     *
     * @param array int[][]
     * @return copy of array
     */
    private int[][] copyArray(int[][] array) {

        //local variable to assign given array's elements
        int[][] copiedArray = new int[array.length][array.length];

        //Iterates given array as parameter and copies its elements to a brand new array
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array.length; column++) {

                copiedArray[row][column] = array[row][column];
            }
        }
        return copiedArray;
    }

    /**
     * - Checks if a number is in the row
     * @param row    int
     * @param number int
     * @return boolean
     */
    private boolean isInRow(int row, int number, int[][] puzzle) {

        for (int i = 0; i < puzzle.length; i++)
            if (puzzle[row][i] == number)
                return true;

        return false;
    }

    /**
     * - Checks if a number is in the column
     * @param column int
     * @param number int
     * @return boolean
     */
    private boolean isInColumn(int column, int number, int[][] puzzle) {

        for (int i = 0; i < puzzle.length; i++)
            if (puzzle[i][column] == number)
                return true;

        return false;
    }

    /**
     * - Checks if a number is in the sub grid (3x3)
     *
     * @param row    int
     * @param column int
     * @param number int
     * @return boolean
     */
    private boolean isInSubGrid(int row, int column, int number, int[][] puzzle) {

        int xNew = row - row % 3;
        int yNew = column - column % 3;

        for (int x = xNew; x < xNew + 3; x++) {

            for (int y = yNew; y < yNew + 3; y++) {

                if (puzzle[x][y] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * - Gathers all 3 checks together
     * - If check passed, the possible number respects the rules os sudoku
     *
     * @param puzzle int[][]
     * @param row    int
     * @param column int
     * @param number int
     * @return boolean
     */
    private boolean followTheRules(int[][] puzzle, int row, int column, int number) {

        return !this.isInRow(row, number, puzzle) && !this.isInColumn(column, number, puzzle) && !this.isInSubGrid(row, column, number, puzzle);
    }

    /**
     * - This method uses the Main Algorithm to solve Sudoku puzzle
     * - Uses the methods of the structure implementations to add or remove elements from data structures
     * and check if the structure is empty
     *
     * @return boolean
     */
    public boolean solve() {

        //1.- While structure is not empty
        while (!structure.isEmpty()) {

            // 2. Remove an element from structure
            int[][] currentPuzzle = structure.popPuzzle();   // 2. remove last element from stack

            //3.- Iterate currentPuzzle
            for (int row = 0; row < currentPuzzle.length; row++) {
                for (int column = 0; column < currentPuzzle.length; column++) {

                    //4.- If there is an empty cell...
                    if (currentPuzzle[row][column] == 0) {

                        //5.- Try possible numbers from 1-9
                        for (int number = 1; number <= currentPuzzle.length; number++) {

                            //6.- If a possible number was found that respects the rules
                            if (this.followTheRules(currentPuzzle, row, column, number)) {

                                //7.- Mutate the puzzle by adding the possible number
                                int[][] newPuzzle = this.copyArray(currentPuzzle);
                                newPuzzle[row][column] = number;

                                //8.- Add the new item to the structure if it is not solved
                                structure.pushPuzzle(newPuzzle);

                                //9.- Recurse to check if the puzzle is solved, return true if so
                                if (this.solve()) {
                                    return true;
                                }
                            }
                        }
                        //10. If there are more empty cells the puzzle is not solved yet
                        if (this.hasEmptyCells(currentPuzzle)) {
                            return false;
                        }
                    }
                }
            }
            //11. If puzzle has a solution, assigns the solved puzzle to this.puzzle
            this.puzzle = currentPuzzle;
        }
        //12. Return true, puzzle solved  [.solve()=true]
        return true;
    }
}