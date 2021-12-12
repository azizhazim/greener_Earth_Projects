import java.util.Scanner;

public class TreesAndCarbonMethods {
    /**
     *   Computes the green weight mass of a tree given the
     *   diameter breast height and the height of the tree
     * 
     *   @param d The diameter of the tree, in cm.
     *   @param h The height of the tree, in cm.
     *   @return The green weight mass, in kg.
     */

    public static double computeGreenWeightMass(double d, double h) {
        // Double variable to hold and return green weight mass
        double mass = 0.0;
        // Check if the diameter is under 28 cm
        if (d < 28) {
            // If diameter is under 28 cm compute using this formula
            mass = (0.0577 * Math.pow(d, 2) * h);
        }
        // Else check if the diameter is greater or = 28 cm
        else if (d >= 28) {
            // If diameter is greater or equal to 28 cmcompute using this formula
            mass = (0.0346 * Math.pow(d, 2) * h);
        }
        // Return the computed green weight mass
        return mass;
    }

    /**
     * Outputs the report headings to the screen, including
     * dashed seperators. Each column occupies a field
     * width of 12 character positions
     *
     */

    public static void outputHeaders() {
        // Output the headers
        System.out.printf("%12s%12s%12s%12s%12s\n", "HEIGHT", "DIAMETER", "MASS", "CARBON", "C02");
        // Output the headers assisting underlying dashes
        System.out.printf("%12s%12s%12s%12s%12s\n", "------", "-------", "----", "-----", "---");
    }

    /**
     * Computes the ammount of carbon stored in a tree, give the
     * green weight mass of the tree.
     * 
     * @param gw_mass The green weight mass, in kg.
     * @return The ammount of carbon stored, in kg.
     */

    public static double computeCarbonStored(double gw_mass) {
        // Declare a double variable to hold the carbon
        double carbon = 0.0;
        // Compute carbon with greenweight mass
        carbon = .25 * gw_mass;
        // Return the computed carbon
        return carbon;
    }
    /**
     * Computes the ammount of C02 stored in a tree,
     * given the ammount of carbon stored.
     * 
     * @param carbon The carbon stored in the tree, in kg.
     * @return The ammount of C02 stored, in kg.
     */

    public static double computeCO2Stored(double carbon) {
        // Declare a double variable to hold carbon dioxide
        double cd = 0.0;
        // Compute the carbon dioxide with the formula below
        cd = carbon * 3.67;
        // Return the ammount of carbon dioxide computed
        return cd;
    }
    /**
     * Inputs and validates the height value.
     * 
     * @param sc The <code>Scanner</code> object to use for input
     * @param h The array of height values.
     * @param index The specific index of "h" in which to place the input.
     * @return True if the input value was valid, false otherwise.
     */
    public static boolean inputHeight(Scanner sc, double[] h, int index) {
        // Declare a double variable to store height 
        double height = 0.0;
        // Recieve user input of height
        height = sc.nextDouble();
        // Store the users height input in the appointed index
        h[index] = height;
        // Check if the inputted height is valid
        boolean isValidHeight = true;
        // If the height is less than 30.48 cm set it to false
        if (height < 30.48) {
            // Height is less than 30.48 cm set it to false
            isValidHeight = false;
        }
        // Return either true or false from isValidHeight
        return isValidHeight;
    }
    /**
     * Inputs and validates the diameter breast height (DBH) value.
     * 
     * @param sc The <code>Scanner</code> object to use for input
     * @param h The array of diameter breast height values.
     * @param index The specific index of "d" in which to place the input.
     * @return True if the input value was valid, false otherwise.
     */

    public static boolean inputDBH(Scanner sc, double[] d, int index) {
        // Declare a double variable to store DBH
        double dbh = 0.0;
        // Recieve user input of DBH
        dbh = sc.nextDouble();
        // Store the users DBH input in the appointed index
        d[index] = dbh;
        // Check if the inputted DBH is valid
        boolean isValidDBH = true;
        // If the DBH is less than 2 cm set it to false
        if (dbh < 2) {
            // DBH is less than 2 cm set to false
            isValidDBH = false;
        }
        // Return either true or false from isValidDBH
        return isValidDBH;
    }

}