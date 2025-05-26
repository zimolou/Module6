import java.util.Scanner;
import java.util.Random;

public class EnhancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int number = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;
        
        System.out.println("Number Guessing Game (1-100)");
        
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if(guess > number) {
                System.out.println("Too high!");
            } else if(guess < number) {
                System.out.println("Too low!");
            }
        } while(guess != number);
        
        System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
    }
}
