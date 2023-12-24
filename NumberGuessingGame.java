import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("Guess a number between " + lowerRange + " and " + upperRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + (attempts + 1) + " attempts!");
                    totalAttempts += attempts + 1;
                    correctGuess = true;
                    break;
                }

                attempts++;
            }

            if (!correctGuess) {
                System.out.println("Oops! You've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        double averageAttempts = totalAttempts / (double) totalRounds;
        System.out.println("\nGame Over! You played " + totalRounds + " rounds and your average attempts per round was " + String.format("%.2f", averageAttempts) + ".");
    }
}
