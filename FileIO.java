import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is the package for FileIO.java
 *
 * The fileio program reads a sample input file with integers on each line
 * For each line of integers:
 * Convert them from string to int.
 * Calculate the sum of all the integers. 
 * Write the sum to the output file.
 * and displays the error message in “output.txt”.
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @version 1.0
 * @since 2025-02-28
 */
public final class FileIO {

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args unused.
     */
    public static void main(final String[] args) {
        try {
            // pass the path to the input file as a parameter
            File inputFile = new File("./input.txt");
            Scanner sc = new Scanner(inputFile);

            // Create a FileWriter and PrintWriter for the output file
            FileWriter fileWriter = new FileWriter("./output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // While fileObject hasNextLine
            while (sc.hasNextLine()) {
                // READ line from fileObject
                String line = sc.nextLine();
                try {
                    // arrayOfStrings = line split by " "
                    String[] arrayOfStrings = line.split(" ");
                    // IF size of arrayOfString <= 0 THEN
                    if (arrayOfStrings.length <= 0) {
                        // DISPLAY "Nothing on this line" in output.txt
                        printWriter.println("Nothing on this line");
                    } else {
                        // ELSE
                        int sum = 0;
                        // FOR String numString : arrayOfStrings
                        for (String numString : arrayOfStrings) {
                            // CAST numString to numInt
                            int numInt = Integer.parseInt(numString);
                            // sum += numInt
                            sum += numInt;
                        }
                        // DISPLAY sum
                        printWriter.println(sum);
                    }
                } catch (NumberFormatException ex) {
                    // CATCH IntegerConversionError
                    // DISPLAY "You entered a string instead of an integer."
                    printWriter.println("You entered a string instead of an integer.");
                }
            }
            // Close the Scanner and PrintWriter
            sc.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file.");
        }
    }
}