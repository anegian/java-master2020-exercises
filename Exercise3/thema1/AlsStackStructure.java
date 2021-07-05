package Exercise3.thema1;

import java.util.ArrayList;

//implementation Arraylist as Stack
public class AlsStackStructure extends SudokuStructure {

    //initialize Arraylist candidates
    private ArrayList<int[][]> candidates = new ArrayList<>();

    /**
     * - Method to remove puzzle item form structure
     *
     * @return int[][]
     */
    @Override
    public int[][] popPuzzle() {
        return this.candidates.remove(this.candidates.size() - 1);
    }

    /**
     * - Method to add puzzle item to structure
     *
     * @param puzzle int[][]
     */
    @Override
    public void pushPuzzle(int[][] puzzle) {
        candidates.add(puzzle);
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
