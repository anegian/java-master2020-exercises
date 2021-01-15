package thema3;

public class MainProgramSupermarket {

    /**
     * Initially
     * - A 2d array is declared and instantiated
     * - Creates an object of the SuperMarketSales class
     * - Calls the rest methods of the SuperMarketSales class to calculate the sales incomes of the supermarket stores, 
     * according to the 2d array (sales) stated as variable.
     * 
     * Finally
     * - Prints the results to the terminal
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        double[][] sales = {{12502.5, 2506.75, 8088.33, 1289.55}, {10085.65, 1505.85, 5800.65, 1184.55}, {19258, 1158.57, 9871.22, 1289.78}};

        SupermarketSales incomes = new SupermarketSales(sales);

        incomes.getKatastimataSales();
        incomes.getProductsSales();
        incomes.getSupermarketSales();

    }
}
