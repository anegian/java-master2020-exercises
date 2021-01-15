package thema4;

public class MainProgram4 {

    /**
     * - Sets the name of the Supermarket Chain
     * - Declares and instantiates two 2d arrays 
     * - Creates two objects of the SupermarketSalesToFile class
     * - Sets the names of the cities where the branches are
     * - Calls the getKatastimataSales() for both cities branches and stores the results of the incomes to a .txt file for each city
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        SupermarketSalesToFile.setSupermarketName("Sklavenitis");

        double[][] branchThessalonikiSales = {{12502.5, 2506.75, 8088.33, 1289.55}, {10085.65, 1505.85, 5800.65, 1184.55}, {19258, 1158.57, 9871.22, 1289.78}};
        SupermarketSalesToFile stores1 = new SupermarketSalesToFile(branchThessalonikiSales);
        stores1.setPoli("Thessaloniki");
        stores1.getKatastimataSales();

        double[][] branchPatraSales = {{10502.5, 2406.75, 8188.33, 1489.55}, {10585.65, 1805.85, 4800.65, 1584.55}};
        SupermarketSalesToFile stores2 = new SupermarketSalesToFile(branchPatraSales);
        stores2.setPoli("Patra");
        stores2.getKatastimataSales();

    }
}
