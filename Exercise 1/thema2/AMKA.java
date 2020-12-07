import java.util.Scanner;

public class AMKA {

    private static final int amkaAcceptedLength = 11;
    private static final char[] arrayAmkaDigits = new char[amkaAcceptedLength];

    /**
     * - Runs Amka process until the user wishes to stop
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        do {

            runAmkaProcess();

        } while (restartOrExit());
    }

    /**
     * initially:
     * - Gets the user input
     * - Validates the user input
     *
     * finally:
     * - Calculates the user's age
     * - Calculates the user's gender
     * - Prints results
     */
    private static void runAmkaProcess() {

        boolean hasErrors;
        String amka;

        // do_while stops when errors.length == 0,
        // input will be valid.
        do {

            amka = interactWithUser();
            String errors = validateUserInput(amka);

            hasErrors = errors.length() > 0;
            if (hasErrors) {
                System.out.println(errors);
            }

        } while (hasErrors);

        int age = calculateAge();
        String gender = calculateGender();

        System.out.println("Your A.M.K.A. is: " + amka);
        System.out.println("Your age is : " + age);
        System.out.println("Your gender is : " + gender + "\n");
    }

    /**
     * - Asks the user
     * - Reads the console and returns the input
     *
     * @return String amka
     */
    private static String interactWithUser() {

        System.out.println("Type your A.M.K.A.: ");

        return new Scanner(System.in).next();
    }

    /**
     * Validates the length of amka input (11 characters)
     *
     * @param amka String
     * @return boolean
     */
    private static boolean invalidLength(String amka) {

        return (amka.length() != amkaAcceptedLength);
    }

    /**
     * Iterates amka characters and populates arrayAmkaDigits array
     * Returns false if characters are not digits
     *
     * @param amka String
     * @return boolean
     */
    private static boolean invalidCharacters(String amka) {

        for (int i = 0; i < amka.length(); i++) {

            if (!Character.isDigit(amka.charAt(i))) {
                return true;
            } else {
                arrayAmkaDigits[i] = amka.charAt(i);
            }
        }

        return false;
    }

    /**
     * -Checks if the user's input has valid length
     * -Checks if the user's input consists only of digits after length was valid
     *
     * @param amka String
     * @return String errors
     */
    private static String validateUserInput(String amka) {

        if (invalidLength(amka)) {
            return "The AMKA must be a number of 11 digits";
        }

        if (invalidCharacters(amka)) {
            return "Only digits allowed!";
        }

        return "";     // returns empty String, if the input is valid (length == 0)
    }


    /**
     * - Extracts the 5th and 6th Digits of amka input
     * - Calculates the age of the amka owner by using the given formula
     *
     * @return int age
     */
    private static int calculateAge() {

        int fifthDigit = Character.getNumericValue(arrayAmkaDigits[4]);
        int sixthDigit = Character.getNumericValue(arrayAmkaDigits[5]);

        int baseYear = fifthDigit >= 2 ? 1900 : 2000;
        int amkaOwnerAge = 2020 - (baseYear + fifthDigit * 10 + sixthDigit);

        return amkaOwnerAge;
    }

    /**
     * - Calculates the gender of the amka owner
     * - Returns Female if the 10th digit is an even number or Male if it is an odd number
     *
     * @return String gender
     */
    private static String calculateGender() {

        char genderDigit = arrayAmkaDigits[9];
        String gender = Character.getNumericValue(genderDigit) % 2 == 0 ? "Female" : "Male";

        return gender;
    }

    /**
     * - Prints to the console reset the program or exit
     * - Gets and validates the input
     * - Returns true for yes, false for everything else
     *
     * @return boolean
     */
    private static boolean restartOrExit() {

        System.out.println("To restart the program press 'Y'\n" + "To exit the program type any other key and press Enter");

        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.next();

        if (answer.toUpperCase().equals("Y")) {
            return true;
        } else {
            System.out.println("Exiting program");
            return false;
        }
    }
}