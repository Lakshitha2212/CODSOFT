import java.util.Random;
import java.util.Scanner;
public class task1{
    private static final int MAX_ATTEMPTS=10;
    private static final int LOWER_BOUND=1;
    private static final int UPPER_BOUND=100;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;
        boolean playAgain;

        System.out.println("welcome to the number guessing game!");

        do{
            roundsPlayed++;
            int attempts = playGame(scanner);
            totalAttempts += attempts;

            if(attempts <= MAX_ATTEMPTS){
                roundsWon++;
            }
            System.out.printf("score: Rounds Played -%d , Round Won -%d,Total Attempts -%d%n",roundsPlayed,roundsWon,totalAttempts);
            System.out.print("Do you want to play again? (yes/no):");
            playAgain=scanner.next().equalsIgnoreCase("yes");
        }while(playAgain);
        System.out.println("Thanks for Playing! Goodbye.");
        scanner.close();
    }
    private static int playGame(Scanner scanner){
        Random random = new Random();
        int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND +1)+LOWER_BOUND;
        int attempts = 0;
        System.out.printf("%n I have selected a number between %d and %d. try to guess it%n",LOWER_BOUND,UPPER_BOUND);
        while(attempts<MAX_ATTEMPTS){
            System.out.print("enter your guess:");
            int guess;
            try{
                guess = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Invalid input. please enter a number.");
                scanner.next();
                continue;
            }
            attempts++;
            if(guess < numberToGuess){
                System.out.println("Too low! try again.");
            }
            else if(guess > numberToGuess){
                System.out.println("Too high! try again.");
            }
            else{
                System.out.printf("congratulations! you guessed it in %d attempts. %n",attempts);
                return attempts;
            }
        }
        System.out.printf("sorry , you've used all %d attempts. the correct number was %d.%n",MAX_ATTEMPTS,numberToGuess);
        return attempts;
    }
}  

