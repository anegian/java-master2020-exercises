package Exercise3.thema1;

import java.util.Stack;

//implementation Stack as Stack
public class StackStructure extends SudokuStructure {

    //initialize Stack candidates
    private Stack<int[][]> candidates = new Stack();

    /**
     * - Method to remove puzzle item form structure
     *
     * @return int[][]
     */
    @Override
    public int[][] popPuzzle() {
        return this.candidates.pop();
    }

    /**
     * - Method to add puzzle item to structure
     *
     * @param puzzle int[][]
     */
    @Override
    public void pushPuzzle(int[][] puzzle) {
        this.candidates.push(puzzle);
    }

    /**
     * - Method to know if a structure is empty, has no elements
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.candidates.empty();
    }

}
