import java.util.Scanner;
import java.io.*;
/**
 * grade sets from input file, calculates letter-grade
 * counts, high and low scores, and averages, then writes results
 * to an output file.
 *
 * @author Sana Abbas
 * @version v1.0
 * @since 10/13/2026
 */
public class Grades {

    public static void main(String[] args) throws IOException {

        // the string variables for the input and output file names
        String inFile;
        String outFile;

        // retriving the input and output file names
        inFile = getInFile();
        outFile = getOutFile();

        // processing the grades
        processFile(inFile, outFile);
    }

    /**
     * we use the Scanner to get and return a valid input file name.
     *
     * @return name of the existing input file
     */
    public static String getInFile() throws IOException {

        // making Scanner tied to the keyboard
        Scanner keyboard = new Scanner(System.in);

        // the string variable for the input file name
        String fileName;

        // filing variable
        File inputFile;

        // asking user for the input file name
        System.out.print(
            "Enter the name of the input file (ie input.txt): ");
        fileName = keyboard.nextLine();

        // making a File object
        inputFile = new File(fileName);

        // then asking while file does not exist
        while (!inputFile.exists() || !inputFile.isFile()) {

            System.out.println("Input file cannot be found.");

            System.out.print(
                "Enter the name of the input file (ie input.txt): ");
            fileName = keyboard.nextLine();

            inputFile = new File(fileName);
        }

        // returning the valid file name
        return fileName;
    }

    /**
     * using Scanner to get and return the output file name
     *
     * @return name of the output file
     */
    public static String getOutFile() {

        // making Scanner tied to the keyboard
        Scanner keyboard = new Scanner(System.in);

        // then asking for output file name and returning it
        System.out.print(
            "Enter the name of the output file (ie output.txt): ");

        return keyboard.nextLine();
    }

    /**
     * Each line of grades, will calculate grade counts,
     * high-low scores,average, as it then writes results
     * to the output file.
     *
     * @param inFile the input file name
     * @param outFile the output file name
     * @throws IOException if an input/output error occurs
     */
    public static void processFile(String inFile, String outFile)
    throws IOException {

        // the varibles for letter-grades
        int As = 0;
        int Bs = 0;
        int Cs = 0;
        int Ds = 0;
        int Fs = 0;

        // the variables for score calculations
        int number;
        int min = 0;
        int max = 0;
        int total = 0;
        int count = 0;
        double avg = 0.0;

        // stting number for each line of grades
        int set = 1;

        // making the input file and input stream
        File inputFile = new File(inFile);
        Scanner inStream = new Scanner(inputFile);

        // creating the output stream; overwriting an existing file
        PrintWriter outStream = new PrintWriter(outFile);

        // processing seperately each line 
        while (inStream.hasNextLine()) {

            String line = inStream.nextLine();
            Scanner lineScanner = new Scanner(line);

            // reset counters for new set of grades
            As = Bs = Cs = Ds = Fs = 0;
            total = count = 0;
            avg = 0.0;

            // reading scores until the sentinel -1 is reached
            while (lineScanner.hasNextInt()) {

                number = lineScanner.nextInt();

                if (number == -1) {
                    break;
                }

                // the minimum and maximum using first score
                if (count == 0) {
                    min = max = number;
                }

                //  minimum
                if (number < min) {
                    min = number;
                }

                //  maximum
                if (number > max) {
                    max = number;
                }

                // Update total and number of grades
                total += number;
                count++;

                // Determine the letter grade
                if (number >= 90) {
                    As++;
                } else if (number >= 80) {
                    Bs++;
                } else if (number >= 70) {
                    Cs++;
                } else if (number >= 60) {
                    Ds++;
                } else {
                    Fs++;
                }
            }

            lineScanner.close();

            // Write the set heading
            outStream.println(
                "Set " + set + " of grades calculated");

            // Handle a line with no grades
            if (count == 0) {
                outStream.println("No grades to average");
            } else {

                // Calculate the average using double division
                avg = (double) total / count;

                // Write letter-grade counts
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);

                // Write high and low scores
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);

                // Write average to one decimal place
                outStream.printf("The avg score is: %.1f%n", avg);
            }

            set++;
        }

        // ending the streams
        inStream.close();
        outStream.close();

        // the display completion messages in the console
        System.out.println("Grade processing completed");
        System.out.println(
            "You can retrieve the output file at, " + outFile);
    }
}