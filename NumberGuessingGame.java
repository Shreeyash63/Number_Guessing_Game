import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean isGuessed = false;

            System.out.println("\nGuess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;
                    System.out.println("Points earned: " + points);
                    isGuessed = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }

            if (!isGuessed) {
                System.out.println("Attempts over! The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);
            System.out.print("Play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Game Over!");
        sc.close();
    }
}
