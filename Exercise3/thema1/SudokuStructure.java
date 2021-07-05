package Exercise3.thema1;

/**
 * - Parent abstract class structure
 */
abstract public class SudokuStructure {

    /**
     * - Method to remove puzzle item form structure
     *
     * @return int[][]
     */
    abstract public int[][] popPuzzle();

    /**
     * - Method to add puzzle item to structure
     *
     * @param puzzle int[][]
     */
    abstract public void pushPuzzle(int[][] puzzle);

    /**
     * - Method to know if a structure is empty, has no elements
     *
     * @return boolean
     */
    abstract public boolean isEmpty();

}
