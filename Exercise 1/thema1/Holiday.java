import java.util.Scanner;

public class Holiday {

    private static final Scanner input = new Scanner(System.in);
    private static final String[] answers = {"Mykonos", "Santorini", "Rhodes"};
    private static final int[] validVotesArray = {0, 0, 0};
    private static final int totalVotesLimit = 20;
    private static int totalValidVotes;

    /**
     * - Runs the Holiday Poll Process
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        runHolidayPollProcess();
    }

    /**
     * - Get users' votes until we have 20 unique votes
     * - Validate users' votes
     * <p>
     * - Calculate the total votes for each island and the total valid votes
     * - Print results
     */
    private static void runHolidayPollProcess() {

        for (int totalVotes = 0; totalVotes < totalVotesLimit; totalVotes++) {

            String vote = interactWithUser();
            validateVotes(vote);

        }
        input.close();

        printWinner();
        printLoser();
    }

    /**
     * - Display the poll's initial question to the user
     * - Reveal the 3 island candidates to the user
     *
     * @return String input
     */
    private static String interactWithUser() {

        System.out.println("Vote your best holiday destination!\nType a number from 1 to 3 and press Enter: ");

        for (int i = 0; i < answers.length; i++) {
            System.out.print(i + 1 + "." + answers[i] + "\n");
        }

        return input.nextLine();
    }

    /**
     * - Validates the user's vote
     * - Makes an array with the valid votes
     * - Prints out which island was voted or if the user's input was invalid
     */
    private static void validateVotes(String vote) {

        switch (vote) {

            case "1":
                System.out.println("You have voted Mykonos as the best holiday destination.\n");
                totalValidVotes++;
                validVotesArray[0]++;
                break;
            case "2":
                System.out.println("You have voted Santorini as the best holiday destination.\n");
                totalValidVotes++;
                validVotesArray[1]++;
                break;
            case "3":
                System.out.println("You have voted Rhodes as the best holiday destination.\n");
                totalValidVotes++;
                validVotesArray[2]++;
                break;
            default:
                System.out.println("Your vote was invalid.\n");
                break;
        }
    }

    /**
     * - Calculates the island with the most valid votes
     * - Calculates the percentage of these valid votes out of the total valid votes
     * - Prints the results
     */
    private static void printWinner() {

        int maxValidVotes = 0;
        int maxPosition = 0;

        for (int i = 0; i < validVotesArray.length; i++) {

            if (validVotesArray[i] > maxValidVotes) {
                maxValidVotes = validVotesArray[i];
                maxPosition = i;
            }
        }

        double maxVotesPercent = (double) maxValidVotes / totalValidVotes * 100;
        double roundedMaxVotesPercent = (double) Math.round(maxVotesPercent * 100) / 100;

        System.out.println("\nThe island voted as the best destination for holidays was: \n" + "'" + answers[maxPosition] + "'" + " with " + roundedMaxVotesPercent + '%');
    }

    /**
     * - Calculates the island with the least valid votes
     * - Calculates the percentage of these valid votes out of the total valid votes
     * - Prints the results
     */
    private static void printLoser() {

        int minValidVotes = totalValidVotes;
        int minPosition = 0;

        for (int i = 0; i < validVotesArray.length; i++) {

            if (validVotesArray[i] <= minValidVotes) {
                minValidVotes = validVotesArray[i];
                minPosition = i;
            }
        }

        double minPercent = (double) minValidVotes / totalValidVotes * 100;
        double roundedMinPercent = (double) Math.round(minPercent * 100) / 100;

        System.out.println("The island with the least votes was: \n" + "'" + answers[minPosition] + "'" + " with " + roundedMinPercent + '%');
    }
}