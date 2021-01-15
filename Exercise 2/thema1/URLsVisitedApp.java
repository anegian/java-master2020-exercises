package thema1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class URLsVisitedApp {

    /**
     * - Creates File object and reads from the pathname given by the user
     * - Analyzes the file and prints the results
     *
     * @param args String
     */
    public static void main(String[] args) {

        fileAnalyzer(getFilepath());

    }

    /**
     * - Takes as parameter the file location given by the user and tries to read the file
     * - If the file is found, its content are stored to an Arraylist and the printAll() prints them
     * - Calls the method removeDuplicates() to do the unique sorting
     * - Prints the contents of the processed Arraylist
     *
     * @param filepath String
     */
    private static void fileAnalyzer(String filepath) {

        URLsVisited urlsFile;

        //handling FileNotFoundException in try..catch
        try {
            //URLsVisited Class Obstacle
            urlsFile = new URLsVisited(filepath);

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file '" + filepath + "'. Please insert a valid path and filename.");
            return;
        }

        urlsFile.printAll();

        urlsFile.removeDuplicates();

        urlsFile.printAll();
    }

    /**
     * - Interacts with user
     * - Asks for the file's location
     *
     * @return filepath String
     */
    private static String getFilepath() {

        Scanner keyboard;     //stores the input of the user
        String filepath;      //stores the path of the file to be analyzed

        System.out.println("Which filename do you want to analyze?");
        keyboard = new Scanner(System.in);

        filepath = keyboard.nextLine();

        System.out.println("The file analyzed is: \n" + filepath);

        return filepath;
    }
}
