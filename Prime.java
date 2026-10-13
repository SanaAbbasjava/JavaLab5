import java.util.Scanner;
/**
 * Tests if a whole number is prime and allows the user
 * to test additional numbers.
 *
 * @author Sana Abbas
 * @version v1.0
 * @since 10/13/2026
 */
public class Prime {

    public static void main(String[] args) {

        // boolean variable for prime result
        boolean isPrime;

        // using integer variable for the original number to test
        int number;

        // adding string variable to test to calculate another number
        String playAgain;

        // making a Scanner object to get user input
        Scanner keyboard = new Scanner(System.in);

        do {
            // the display message and getting a number from the user
            System.out.print(
                "Enter a whole number>2 (ie 19) to test if prime: ");
            number = keyboard.nextInt();

            // setting isPrime to the result of testForPrime(number)
            isPrime = testForPrime(number);

            // then displaying whether the number is prime
            if (isPrime) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }

            // then asking whether the user wants to test another number
            System.out.print(
                "Enter yes to test another number, no to quit. ");
            playAgain = keyboard.next();

        } while (playAgain.equalsIgnoreCase("yes"));

    } // end main

    /**
     * Determines whether a number is prime.
     *
     * @param inNumber the whole number being tested
     * @return true if the number is prime; false otherwise
     */
    public static boolean testForPrime(int inNumber) {

        // numbers that are less than 2 are not prime
        if (inNumber < 2) {
            return false;
        }

        // then getting the integer square root to shorten testing
        int inNumberSqRt = (int) Math.sqrt(inNumber);

        // when assuming the number is prime
        boolean isPrimeMeth = true;

        // then checking possible divisors
        for (int i = 2; isPrimeMeth && i <= inNumberSqRt; i++) {

            // then checking whether the number is divisible by i
            if (inNumber % i == 0) {
                isPrimeMeth = false;
            }

        }

        // return even if the number is prime
        return isPrimeMeth;

    } // ending testForPrime

} // ending Prime
