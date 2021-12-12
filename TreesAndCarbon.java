import java.util.Scanner;
/**
 *   Program computes a trees green weight mass, carbon stored, and
 *   co2 stored by using two user inputs of a tree's height and diameter
 *   breast height. Displays results in a organized list.
 *     
 *   @author Aziz Hazim
 *   @version 11/01/2021
 */

public class TreesAndCarbon {
    /**
     *   The entry point for the program.
     *   
     *   @param args The command-line arguments to the program.
     */
    public static void main(String[] args) {
        // Declare a scanner object to take in user input
        Scanner sc = new Scanner(System.in);
        // Declare a double array for height that stores 10 values.
        double height[] = new double[10];
        // Declare a double array for diameter that stores 10 values.
        double diameter[] = new double[10];
        // Declare a double array for mass that stores 10 values.
        double mass[] = new double[10];
        // Declare a double array for carbon that stores 10 values.
        double carbon[] = new double[10];
        // Declare a double array for co2 that stores 10 values.
        double co[] = new double[10];
        // Intializing a counter variable i
        int i = 0;
        // Declaring a boolean isValidHeight to store validity for height
        boolean isValidHeight = true;
        // Declaring a boolean isValidDBH to store validity for DBH
        boolean isValidDBH = true;

        // Loops through the arrays 10 times
        while (i <= 9) {
            // Ask user for tree height and diameter input
            System.out.print("Enter the height <space> diameter, both in cm:");
            // Input height into the array index and return its boolean result
            isValidHeight = TreesAndCarbonMethods.inputHeight(sc, height, i);
            // Input height into the array index and return its boolean result
            isValidDBH = TreesAndCarbonMethods.inputDBH(sc, diameter, i);
            // Check the inputed height value for validity 
            if (isValidHeight == false) {
                // Tell the user the height is not in range
                System.out.println("*** ERROR: The height must be greater than 30.48 cm." +
                    " Please try again.");
            }
            // Check the inputed DBH value for validity 
            if (isValidDBH == false) {
                // Tell the user the DBH is not in range
                System.out.println("*** ERROR: The diameter must be greater than 2.0 cm." +
                    " Please try again.");
            }
            // Compute green weight mass and store it in its array index
            mass[i] = TreesAndCarbonMethods.computeGreenWeightMass(diameter[i], height[i]);
            // Compute carbon stored and store it in its array index
            carbon[i] = TreesAndCarbonMethods.computeCarbonStored(mass[i]);
            // Compute carbon dioxide stored and store it in its array index
            co[i] = TreesAndCarbonMethods.computeCO2Stored(carbon[i]);
            // Increment the counter variable
            i++;
        }
        // Print out a blank line to assist in styling
        System.out.println();
        // Print out the headers to neatly display the infomation
        TreesAndCarbonMethods.outputHeaders();
        // Loop through the array indexes and print out their inputed and computed results
        for (int k = 0; k <= 9; k++) {
            // Display height, diameter, along with its corresponding GWM, Carbon, and CO2
            System.out.printf("%12.2f%12.2f%12.2f%12.2f%12.2f\n", height[k], diameter[k], +mass[k], carbon[k], co[k]);
        }

    }

}