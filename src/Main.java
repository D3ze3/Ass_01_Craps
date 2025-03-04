import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static final Random rand = new Random();

    private static int rollDie() {
        return rand.nextInt(6) + 1;
    }

    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Rolling the dice...");
            int die1 = rollDie();
            int die2 = rollDie();
            int sum = die1 + die2;
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("Point is set to " + point + ". Keep rolling to match the point.");
                boolean keepRolling = true;

                while (keepRolling) {
                    System.out.println("Rolling again...");
                    die1 = rollDie();
                    die2 = rollDie();
                    sum = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("Made point! You win.");
                        keepRolling = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        keepRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }
            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("y");
        }
        scanner.close();
    }
}