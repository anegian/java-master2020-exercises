package Exercise3.thema1;

import java.util.LinkedList;

//implementation LinkedList as Queue
public class LlQueueStructure extends SudokuStructure {

    //initialize LinkedList candidates
    private LinkedList<int[][]> candidates = new LinkedList<>();

    /**
     * - Method to remove puzzle item form structure
     *
     * @return int[][]
     */
    @Override
    public int[][] popPuzzle() {
        return this.candidates.removeFirst();
    }

    /**
     * - Method to add puzzle item to structure
     *
     * @param puzzle int[][]
     */
    @Override
    public void pushPuzzle(int[][] puzzle) {
        this.candidates.addLast(puzzle);
    }

    /**
     * - Method to know if a structure is empty, has no elements
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.candidates.isEmpty();
    }

}
