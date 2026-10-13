import java.util.Scanner;
/**
 * Calculates the distance an object falls for a given number of seconds.
 *
 * @author Sana Abbas
 * @version v1.0
 * @since 10/13/2026
 */
public class FallingDistance {

    // the public constant to acceleration
    public static final double ACCELERATION = 9.8;

    /**
     * the number of seconds from the user and 
     * the calculated falling distance for each second.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // making scanner object
        Scanner keyboard = new Scanner(System.in);

        // double variable using for distance
        double distance;

        // using integer variable for # of seconds
        int numOfSecs;

        // then asking user for the input
        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();

        // the headings titles
        System.out.println("Time(secs)\tDistance(m)");
        System.out.println("=========\t===========");

        // looping for each second
        for (int second = 1; second <= numOfSecs; second++) {

            // now calculating the distance using the method
            distance = getDistance(second);

            // then displaying time and the distance to one decimal place
            System.out.printf("%d\t\t%.1f%n", second, distance);
        }
    }

    /**
     * Calculates the distance an object falls using the formula
     * distance = 0.5 * acceleration * time squared.
     *
     * @param seconds the elapsed time in seconds
     * @return the distance fallen in meters
     */
    public static double getDistance(int seconds) {
        return 0.5 * ACCELERATION * seconds * seconds;
    }
}
