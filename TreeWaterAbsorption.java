import java.util.Scanner;

/**
 *  Program calculates how much water a tree absorbs over
 *  A given time span in years using users input of tree
 *  Diameter and a timeframe in years
 *
 *  @author Aziz
 *  @version 10-13-21
 */

public class TreeWaterAbsorption {
    /**
     * The entry point for the program.
     * 
     *  @param args The command-line arguments.
     */

    public static void main(String args[]) {
        // Creating a scanner object to get input
        Scanner sc = new Scanner(System.in);
        // Create a double value to hold diameter
        double diameter = 0.0;
        // Create int value to hold years
        int year = 0;
        // Create a double value to hold water required
        double water = 0;
        // Call inputDiameter method to prompt and validate input
        diameter = inputDiameter(sc);
        // Call inputYears method to prompt and validate input
        year = inputYears(sc);
        // Echo out the users input of diameter and years
        System.out.println("You entered a diameter of " + diameter +
            " and a time span of " + year + " year(s).\n");
        // Call the outputYearData method with year, diameter, and water as args
        outputYearData(year, diameter, water);

    }

    /**
     *	Computes the amount of water (in liters) required by a tree, based
     *	on the trunk diameter (in centimeters). The amount is returned to
     *	the calling method.
     *
     *	@param trunk_diameter cm The trunk diameter, in centimeters (cm).
     *	@return Returns the amount of water required for the tree, in liters.
     *
     */

    public static double computeWaterRequired(double trunk_diameter_cm) {
        // Create a double to hold water required
        double water = 0.0;
        // Change cm to inch
        trunk_diameter_cm = trunk_diameter_cm / 2.54;
        // Calculate water needed per inch
        water = trunk_diameter_cm * 37.85;
        // Return water needed
        return water;

    }

    /**
     *	Outputs one line of data, using the parameters as data values.
     *	The "liters" value is rounded to a whole number.
     *
     *	@param	year The year of the report.
     *	@param	diameter The trunk diameter,	in centimeters (cm).
     *	@param	liters The amount of water,	in liters.
     */

    public static void outputYearData(int year, double diameter, double liters) {

        for (int i = 1; i <= year; i++) {
            // Create a double to hold diameter result
            double res = 0.0;
            // Increment diameter by itself each year
            res = diameter * i;
            // Calulcate the liters required with the new diameter
            liters = computeWaterRequired(res);
            // Round the liters needed per week
            liters = Math.round(liters);
            // Output the result of each year, with corresponding diameter and liters required
            System.out.println("Year " + i + ": diameter = " + res + " cm, water required = " +
                (int) liters + " liters/week.");
        }

    }
    /**
     *   This method checks to see if the diameter is valid. The 
     *   methods returns true to the calling method if it is valid,
     *   false otherwise. 
     *
     *   @param sc to input
     *   @return True if the diameter is valid, false otherwise.
     */

    public static double inputDiameter(Scanner sc) {
        // Declare a double hold the user input...
        double diameter = 0.0;
        // Declare a flag variable...
        boolean is_valid_diameter = false;
        // Checks to see if the diameter entered is valid
        while (!is_valid_diameter) {
            // Prompt the user...
            System.out.print("Enter the diameter added per year, in cm: ");
            // Input the value...
            diameter = sc.nextDouble();
            // Did they do it right?
            if (diameter > 0) {
                // Yes! Set the flag to true...
                is_valid_diameter = true;
            } else {
                // No, tell them about it...
                System.out.println("ERROR: The diameter must be > 0. Please try again.");
            }
        }
        // Return the inputed diameter
        return diameter;
    }

    /**
     *   This method checks to see if the years is valid. The 
     *   methods returns true to the calling method if it is valid,
     *   false otherwise. 
     *
     *   @param sc to input
     *   @return True if the year is valid, false otherwise.
     */

    public static int inputYears(Scanner sc) {
        // Declare a double hold the user input...
        int year = 0;
        // Declare a flag variable...
        boolean is_valid_year = false;
        // Checks to see if the years entered is valid
        while (!is_valid_year) {
            // Prompt the user...
            System.out.print("Enter the number of years: ");
            // Input the value...
            year = sc.nextInt();
            // Did they do it right?
            if (year > 0) {
                // Yes! Set the flag to true...
                is_valid_year = true;
            } else {
                // No, tell them about it...
                System.out.println("ERROR: The years must be > 0. Please try again.");
            }
        }
        // Return the inputed year
        return year;
    }




}