import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");

        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've generated a random number between " + minRange + " and " + maxRange + ".");
            System.out.println("Can you guess the number?");

            boolean guessedCorrectly = false;
            attempts = 0;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += (maxRange - minRange + 1) - attempts;
                    guessedCorrectly = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts >= 10) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The secret number was: " + secretNumber);
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Your score: " + score);
        scanner.close();
    }
}
