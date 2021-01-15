package thema4;

import thema3.SupermarketSales;

import java.io.FileWriter;
import java.io.IOException;

public class SupermarketSalesToFile extends SupermarketSales {

    public static String supermarketName;
    private String poli;

    /**
     * - Parameterized Constructor inherited from the superclass SuperMarketSales
     * - Accesses the elements of the given 2d array as parameter by using 2 for..loops to iterate through.
     * - If the array does not contain negative double numbers, the constructor stores the number of rows to int katastimata,
     * the number of columns to int products and the parameter array to the sales[][].
     * - Prints out the message of negative numbers found, when the if (sales[i][j] < 0) statement is true.
     *
     * @param sales double[][]
     */

    public SupermarketSalesToFile(double[][] sales) {

        super(sales);
    }

    /**
     * - Sets the name of the Supermarket Chain
     *
     * @param name String
     */
    public static void setSupermarketName(String name) {

        supermarketName = name;
    }

    /**
     * - Sets the name of the city in which there are the supermarket branches
     *
     * @param poli String
     */
    public void setPoli(String poli) {

        this.poli = poli;
    }

    /**
     * - Returns the name of the city in which there are the supermarket branches
     *
     * @return String
     */
    public String getPoli() {

        return poli;
    }

    /**
     * - Overriden method of the parent class SuperMarketSales
     * - Calculates the total Incomes per branch of the supermarket chain
     * - Creates a .txt file and stores in it, the sales incomes.
     * - Handles the IOException in a try..catch, if the there is any problem while the .txt file is being created.
     */
    @Override
    public void getKatastimataSales() {

        double totalKatastimaIncome;

        try {
            
            //FileWriter may throw IOException
            FileWriter file = new FileWriter(getPoli() + ".txt");

            file.write(supermarketName);
            file.write("\nPoli: " + poli);

            for (int i = 0; i < this.katastimata; i++) {
                totalKatastimaIncome = 0.0;

                for (int j = 0; j < this.products; j++) {
                    totalKatastimaIncome += this.sales[i][j];
                }
                file.write("\nKatastima no: " + i + " \n Total income is " + totalKatastimaIncome);
            }
            // Finishes the storing of the outputs in the txt file and closes the FileWriter
            file.close();

        } catch (IOException e) {
            System.out.println("Error in file");
            //exits the program if an exception is thrown
            System.exit(1);
        }
    }
}