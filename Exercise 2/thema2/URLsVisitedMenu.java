package thema2;

import thema1.URLsVisited;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;


public class URLsVisitedMenu {

    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * - Displays the menu() method until the user wishes to exit the program
     * - According to the user's input, different operations are executed
     * - Files with URLs are analyzed
     *
     * @param args String
     */
    public static void main(String[] args) {

        String directory;  //stores the folder's location that may contain file/files 
        int menuchoice;    //stores the user input between 1,2 or 3

        do {
            menuchoice = menu();   //calling the method menu() and set the int return to the menuchoice

            switch (menuchoice) {
                case 1:
                    System.out.println("Which filename do you want to analyze?");
                    directory = keyboard.nextLine();

                    System.out.println("The filename under analysis is: \n" + directory);
                    fileAnalyzer(directory);
                    break;

                case 2:
                    System.out.println("Which directory's files do you want to analyze?");
                    directory = keyboard.nextLine();

                    System.out.println("The directory under analysis is: \n" + directory);

                    File folder = new File(directory);   // this is the file that will be analyzed
                    String[] filenames = folder.list();  // making an array of strings with the names of the total files found in the folder

                    //If filenames=null for..loop is not executed - Message is printed out.
                    //filenames.length is equal to the number of the files, in the folder
                    //Accesses filenames[] array and calls .fileAnalyzer() for each one file

                    if (filenames == null) {
                        System.out.println("Could not find the file '" + directory + "'. Please insert a valid path and filename.");
                        break;
                    }

                    for (int i = 0; i < filenames.length; i++) {
                        System.out.println("\nThe filename under analysis is: \n" + filenames[i]);

                        fileAnalyzer(directory + "/" + filenames[i]);  // concatenate directory string with filename[i] as string
                    }
            }

        } while (menuchoice != 3);

        System.out.println("Exiting program.");
        
        //close Scanner
        keyboard.close();
    }

    /**
     * - Interacts with user, Displays the choices
     * - Accepts only integer between 1-3, in a do..while loop
     * - Handles a thrown Input Mismatch exception with try..catch and prints out a corresponding message
     *
     * @return int input
     */
    private static int menu() {

        int input = 0;

        System.out.println("\n1. Input the name of the file containing URLs you want to analyze");
        System.out.println("2. Input the path of the directory containing the files you want to analyze for URLs");
        System.out.println("3. Exit");
        System.out.println("Which is your choice:");

        //do..while loop runs until user type 1,2, or 3
        do {

            try {
                //set next integer typed to input
                input = keyboard.nextInt();
                if (input < 1 || input > 3) {
                    //when input is anything else than 1,2, or 3 it throws exception
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please type a number between 1 and 3");
            }

            //reads next line
            keyboard.nextLine();

        } while (input < 1 || input > 3);

        return input;
    }

    /**
     * - Takes as parameter the directory input of the user and try to read the file
     * - If the file is found, its content are stored to an Arraylist and the printAll() prints them
     * - Calls the method removeDuplicates() to do the unique sorting
     * - Prints the contents of the processed Arraylist
     *
     * @param directory String
     */
    private static void fileAnalyzer(String directory) {

        URLsVisited file;

        try {

            file = new URLsVisited(directory);

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file '" + directory + "'. Please insert a valid path and filename.");
            return;
        }

        file.printAll();

        file.removeDuplicates();

        file.printAll();
    }

}
