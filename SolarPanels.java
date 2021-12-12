import java.util.Scanner;

/**
 *  This program estimates the amount of solar radiation 
 *  received by an inclined PV panel using a formula with
 *  Caluclated with user inputs of solar radiation, tilt angle
 *  And day and prints out the computed Solar Radiation 
 *  
 *  @author Aziz.
 *  @version 10-13-21.
 */

public class SolarPanels {
    /**
     * The entry point for the program.
     * 
     *  @param args The command-line arguments.
     */

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        // Declare a double to hold solar radiation
        double solar = 0.0;
        // Declare a double to hold solar tilt angle
        double tilt = 0.0;
        // Declare a int to hold the day
        int day = 1;
        // Declare a constant double to hold allentowns latitude
        final double Lat = 40.6084;
        // Declare a double to hold computed theta
        double theta = 0.0;
        // Declare a double to hold computed sp
        double sp = 0.0;
        // Declare a double to hold computed sp sum
        double sum = 0.0;
        // Call the solar rad method to prompt input and validate solar rad
        solar = inputSolarRad(sc);
        // Call the tilt angle method to prompt input and validate tilt angle
        tilt = inputTiltAngle(sc);
        // Output column headers...
        System.out.printf("\n%8s%8s\n", "DAY", "Sp");
        // Output separators...
        System.out.printf("%8s%10s\n", "===", "======");

        // Creating a loop to iterate for all days of year
        while (day != 366) {
            // Computing theta from latitude and the day
            theta = computeElevationAngle(Lat, day);
            // Computing sp using solar rad, theta, and tilt angle
            sp = computeSp(solar, theta, tilt);
            // Print out the day of year along with its corresponding sp
            System.out.printf("%8d%10.3f\n", day, sp);
            // Add to the day counter
            day = day + 1;
            // Hold the sum of sp through out the year
            sum = (sum + sp);
        }
        // Print out the sp sum from 365 days 
        System.out.printf("\n Sum: %.2f%s ", sum, " kWh/m^2.");

    }

    /**
     *   This method checks to see if the solar radiation is valid. The 
     *   methods returns true to the calling method if it is valid,
     *   false otherwise. 
     *
     *   @param scnr for input
     *   @return solar radiation if true
     */

    public static double inputSolarRad(Scanner scnr) {
        // Declare a double hold the user input...
        double rad = 0.0;
        // Declare a flag variable...
        boolean is_valid_rad = false;
        // Checks to see if the radiation entered is valid
        while (!is_valid_rad) {
            // Prompt the user...
            System.out.print("Please enter the amount of horizontal solar radiation (kWh/m^2): ");
            // Input the value...
            rad = scnr.nextDouble();
            // Did they do it right?
            if (rad > 0) {
                // Yes! Set the flag to true...
                is_valid_rad = true;

                System.out.printf("You entered %.3f %s \n", rad, "kWh/m^2.");
                // Display the solar radiation
            } else {
                // No, tell them about it...
                System.out.println("ERROR: Your radiation amount must be > 0. Please try again.");
            }
        }
        // Return the inputed solar radiation
        return rad;
    }


    /**
     *   This method checks to see if the Tilt Angle is valid. The 
     *   methods returns true to the calling method if it is valid,
     *   false otherwise. 
     *
     *   @param scnr for input
     *   @return tilt angle if true
     */


    public static double inputTiltAngle(Scanner scnr) {
        // Declare a double hold the user input...
        double tilt = 0.0;
        // Declare a flag variable...
        boolean is_valid_tilt = false;
        // Checks to see if the tilt angle entered is valid
        while (!is_valid_tilt) {
            // Prompt the user...
            System.out.print("Please enter the angle of tilt, in degrees: ");
            // Input the value...
            tilt = scnr.nextDouble();
            // Did they do it right?
            if (tilt > 0 && tilt <= 180) {
                // Yes! Set the flag to true...
                is_valid_tilt = true;

                System.out.printf("You entered %.3f %s \n", tilt, "degrees.");
                // Display the tilt angle
            } else {
                // No, tell them about it...
                System.out.println("ERROR: Your angle must be in the range [0-180]. Please try again.");
            }
        }
        // Return the inputed tilt angle
        return tilt;
    }


    /** 
     * Computes the elevation angle for a PV solar panel, given the 
     * latitude (<code>latitude</code>) and the day of the year
     * (<code>day</code>).
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param latitude  The latitude of the PV solar panel.
     * @param day The day of the year (1-365).
     * @return The elevation angle for the PV solar panel.
     *
     */

    public static double computeElevationAngle(double latitude, double day) {
        // Declare storage for the return value...
        double theta = 0.0;

        // compute the declination...
        theta = 23.45 * Math.sin(Math.toRadians((360.0 / 365.0) * (284 + day)));

        // Compute the elevation angle theta....
        theta = (90 - latitude) + theta;

        // Return the angle...
        return theta;
    }

    /** 
     * Computes the radiation received by a PV solar panel, given the 
     * horizontal radiation (<code>sh</code>), the elevation angle 
     * (<code>theta</code>), and the tilt angle (<code>beta</code>).
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param sh  The horizontal radiation value.
     * @param theta The angle of elevation, in degrees.
     * @param beta The angle of tilt, in degrees. 
     * @return The radiation received by a PV solar panel.
     *
     */

    public static double computeSp(double sh, double theta, double beta) {
        // Declare storage for the return value...
        double sp = 0.0;

        // Compute the radiation incident....
        sp = (sh * Math.sin(Math.toRadians(theta + beta))) /
            Math.sin(Math.toRadians(theta));

        // Return the amount...
        return sp;
    }
}