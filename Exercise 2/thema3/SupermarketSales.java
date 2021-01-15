package thema3;

public class SupermarketSales {

    public int katastimata = 0;
    public int products = 0;
    public double[][] sales;

    /**
     * - Parameterized Constructor
     * - Access the elements of the given 2d array as parameter, by using two for loops to iterate through.
     * - If the array does not contain negative double numbers, the constructor stores the number of rows to int katastimata,
     * the number of columns to int products and the parameter array to the sales[][].
     * - Prints out the message of negative numbers found when the if statement is true.
     *
     * @param sales double[][]
     */
    public SupermarketSales(double[][] sales) {

        this.sales = sales;
        this.katastimata = sales.length;     //sales.length is the total number of the rows of the 2d array
        this.products = sales[0].length;     //sales[0].length is the total number of the columns of the 2d array

        for (int i = 0; i < katastimata; i++) {

            for (int j = 0; j < products; j++) {

                if (sales[i][j] < 0) {

                    System.out.println("Contains at least one negative number");

                    //exits the program
                    System.exit(0);
                }
            }
        }
    }

    /**
     * - Access once again the elements of the sales[][] array by using 2 for loops to iterate through.
     * - Calculates the total Income per branch of the supermarket chain.
     * - Prints out the result to the terminal.
     */
    public void getKatastimataSales() {

        double totalKatastimaIncome;

        for (int i = 0; i < this.katastimata; i++) {
            totalKatastimaIncome = 0.0;

            for (int j = 0; j < this.products; j++) {
                totalKatastimaIncome += this.sales[i][j];
            }

            System.out.println("Katastima no:" + i + "\nTotal income is " + totalKatastimaIncome);
        }
        System.out.println("\n");
    }

    /**
     * - Access once again the elements of the sales[][] array by using 2 for loops to iterate through.
     * - Calculates the total income of every product's sales.
     * - Calculates the average Income per branch of the supermarket.
     * - Prints out the result to the terminal.
     */
    public void getProductsSales() {

        double totalProductIncome;
        double averageProductIncome;

        for (int i = 0; i < this.products; i++) {
            totalProductIncome = 0.0;

            for (int j = 0; j < this.katastimata; j++) {
                totalProductIncome += this.sales[j][i];
            }

            System.out.println("Proion no:" + i + "\nTotal income is " + totalProductIncome);

            averageProductIncome = totalProductIncome / this.katastimata;
            System.out.println("Average income ana katastima is " + averageProductIncome);
        }
        System.out.println("\n");
    }

    /**
     * - Access once again the elements of the sales[][] array by using 2 for loops to iterate through.
     * - Calculates the Total Supermarket chain's income
     * - Prints out the result to the terminal.
     */
    public void getSupermarketSales() {

        double totalChainIncome = 0;
        double averageKatastimaSales;

        for (int i = 0; i < this.katastimata; i++) {

            for (int j = 0; j < this.products; j++) {
                totalChainIncome += sales[i][j];
            }
        }

        System.out.println("Total Supermarket chain's income is " + totalChainIncome);

        averageKatastimaSales = totalChainIncome / this.katastimata;
        System.out.println("Average income ana katastima is " + averageKatastimaSales);
    }
}
