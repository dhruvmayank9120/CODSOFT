import java.util.Scanner;
import java.util.Random;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the number game(task 1)");

        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int guess;

            System.out.println("\nRound " + (score + 1));
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! Your guess is correct!");
                    score++;
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you have used all your attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
