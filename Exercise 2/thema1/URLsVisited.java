package thema1;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class URLsVisited {

    private final Scanner fileReader;
    private ArrayList<String> myURLs = new ArrayList<>();
    private boolean processedArraylist;


    /**
     * Initially
     * - Parameterized Constructor
     * - Opens and tries to read the file given
     * <p>
     * Finally
     * - Adds the host names of the urls, to myURLs Arraylist
     *
     * @param filepath String
     */
    public URLsVisited(String filepath) throws FileNotFoundException {
        
        File filename = new File(filepath);
        
        //.fileAnalyzer() of URLsVisited Class is responsible to handle FileNotFoundException
        fileReader = new Scanner(filename);

        // add elements to the myURLs Arraylist
        populateURLsArraylist();
    }

    /**
     * - Checks if file analyzed has contents
     * - Adds the host names of the file to myURLs Arraylist
     * - Closes the Scanner
     */
    private void populateURLsArraylist() {

        if (!fileReader.hasNextLine()) {
            System.out.println("The file is empty");
            return;
        }

        while (fileReader.hasNextLine()) {

            // take the host name from every line and add it to the splitUrl array
            String[] splitUrl = fileReader.nextLine().split("/");

            // add the first element of the splitUrl array to the myURLs Arraylist
            myURLs.add(splitUrl[0]);

        }
        //close the Scanner
        fileReader.close();

    }

    /**
     * - Uses TreeSet class (implementing the Set interface) to do the unique  sorting (remove duplicates and put in order).
     * - Set variable processedArraylist to true
     */
    public void removeDuplicates() {

        //Unique sorting the myURLs Arraylist with TreeSet class
        myURLs = new ArrayList<>(new TreeSet<>(myURLs));

        //boolean variable processedArraylist set to true, to use it in the printAll() for the processed Arraylist
        processedArraylist = true;
    }

    /**
     * - Prints myURLs arraylist contents one by one
     */
    public void printAll() {

        if (!myURLs.isEmpty()) {

            //if the Arraylist was processed by removeDuplicates() prints out "The unique Web sites.." message
            String label = processedArraylist ? "\nThe unique Web sites visited are:" : "\nThe Web sites visited are:";
            System.out.println(label);

            //iterate the myURLs Arraylist and print every element individually
            for (String myURL : myURLs) {
                System.out.println(myURL);
            }
        }
    }
}
