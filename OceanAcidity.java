import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *   This program takes a name of a ocean acidity data file
 *   Computes the # of data records and stores them & then
 *   Displays the data in a formated neat easy to read fashion
 *   Along with computed ph and co2 level averages of ocean acidity
 *
 *   @author Aziz Hazim
 *   @version 12/1/21
 */

public class OceanAcidity {

    /**
     *   The entry point for the program.
     *   
     *   @param args The command-line arguments to the program.
     */

    public static void main(String[] args) {


        // Create a Scanner object...
        Scanner scnr = new Scanner(System.in);

        // Prompt the user for a filename...
        System.out.print(" Please enter the name of a file: ");

        // Input the filename...
        String filename = scnr.nextLine();

        // Echo out the file name
        System.out.println("You entered the file name '" + filename + "'.");

        // Create file object with filename entered
        File f = new File(filename);

        // Test and check if the file exists 
        if (f.exists()) {

            // Inform the user the file has been opened
            System.out.println("\nFile '" + filename + "' Is now open.");

            // Create a int with the value of the # of records in the file
            int records = readFile(filename);

            // Print out how many records were found from the file
            System.out.println(records + " record(s) have been read from the file.");

            // Call the outputResults method to display the results in a list
            outputResults(filename);

            // Call the computeAverages method to display the first 10 & last 10 avgs
            computeAverages(filename);
            
            // Inform the user the file has been closed
            System.out.println("\nFile '" + filename + "' Is closed.");

        }

        // If the file does not exist...
        else {
            // Inform the user the file has not been opened
            System.out.println("\nERROR: File '" + filename + "' is NOT open.");

        }

    }

 /**
   * Reads the given data file and returns
   * the number of data records found.
   * 
   * @param filename, name of the file.
   * @return records, the number of records found.
   */

    public static int readFile(String filename) {
        // Creating a int variable to hold the # of records
        int records = 0;
        // Creating a double array to store the years
        double[] year = new double[512];
        // Creating a double array to store the ph levels
        double[] level = new double[512];
        // Creating a double array to store the dissolved co2
        double[] co2 = new double[512];

        try {

            // Creating a counter variable
            int i = 0;
            // Open the file...
            Scanner file_scnr = new Scanner(new File(filename));
            // Output the headers


            // Scan the file for a new line
            while (file_scnr.hasNextLine() == true) {
                // Store the first data point (year/timestamp) into year array
                year[i] = file_scnr.nextDouble();
                // Store the second data point (phlevel) into level array
                level[i] = file_scnr.nextDouble();
                // Store the third data point (dissolvedCO2) into co2 array
                co2[i] = file_scnr.nextDouble();
                // Increment the counter
                i++;

            }

            // Store the number of records to be returned
            records = i;
            // Close the file...
            file_scnr.close();

            // if the file is not found...
        } catch (FileNotFoundException error) {}
        // Return the # of records in a file
        return records;
    }


 /**
   * Reads the given data files and outputs
   * the data in a formatted fashion with headers,
   * followed by its corresponding data pits
   * 
   * @param filename, name of the file.
   * 
   */


    public static void outputResults(String filename) {
        // Creating a double array to store the years
        double[] year = new double[512];
        // Creating a double array to store the ph levels
        double[] level = new double[512];
        // Creating a double array to store the dissolved co2
        double[] co2 = new double[512];



        try {

            // Creating a counter variable
            int i = 0;
            // Open the file...
            Scanner file_scnr = new Scanner(new File(filename));

            // Open the file (output)...
            PrintWriter file_writer = new PrintWriter(new File("Hazim.txt"));

            // Output the correspondingn headers 
            file_writer.printf("\n%12s%12s%7s%20s\n", "YEAR", "TIMESTAMP", "PH", "DISSOLVED C02");
            // Output the headers assisting underlying dashes
            file_writer.printf("%12s%12s%10s%17s\n", "----", "---------", "--------", "-------------");

            // Scan the file for a new line
            while (file_scnr.hasNextLine() == true) {
                // Store the first data point (year/timestamp) into year array
                year[i] = file_scnr.nextDouble();
                // Store the second data point (phlevel) into level array
                level[i] = file_scnr.nextDouble();
                // Store the third data point (dissolvedCO2) into co2 array
                co2[i] = file_scnr.nextDouble();

                // Convert the double to a string...
                String double_string = String.valueOf(year[i]);

                // Find the '.'
                int pos = double_string.indexOf(".");

                // parse out the substring, ending just before the '.' 
                String year_portion = double_string.substring(0, pos);

                // parse out the substring, beginning just past the '.'
                String timestamp = double_string.substring(pos + 1);

                // Output the formatted results to match headers
                file_writer.printf("%12s%12s%10s%15.4f\n", year_portion, timestamp, level[i], co2[i]);

                // Increment the counter
                i++;

            }
            // Close the file...
            file_writer.close();

        }
        // If the file is not found...
        catch (FileNotFoundException error) {}

    }


 /**
   * Computes the averages of first 10 of ph level and co2 levels
   * Along with the last 10 of the ph levels and co2 levels
   * & Then outputs the computed averages with headers & 
   * corresponding data.
   * 
   * @param filename, name of the file.
   * 
   */

    public static void computeAverages(String filename) {

        // Creating a double array to store the years
        double[] year = new double[512];
        // Creating a double array to store the ph levels
        double[] level = new double[512];
        // Creating a double array to store the dissolved co2
        double[] co2 = new double[512];
        // Create int with the value of the # of records in a file
        int records = readFile(filename);

        try {

            // Give file f1 object the file were writing to...
            File f1 = new File("Hazim.txt");
            // Create an object to write a file...
            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            // Create an object to write a file...
            BufferedWriter bw = new BufferedWriter(fileWritter);

            // Open the file...
            Scanner file_scnr = new Scanner(new File(filename));

            // Creating a counter variable
            int i = 0;

            // Scan the file for a new line
            while (file_scnr.hasNextLine() == true) {
                // Store the first data point (year/timestamp) into year array
                year[i] = file_scnr.nextDouble();
                // Store the second data point (phlevel) into level array
                level[i] = file_scnr.nextDouble();
                // Store the third data point (dissolvedCO2) into co2 array
                co2[i] = file_scnr.nextDouble();
                // Increment the counter...
                i++;
            }


            // Create a double variable to store the first 10 ph level total...
            double phTotal = 0.0;
            // Create a double variable to store the first 10 co2 dissolved total...
            double co2Total = 0.0;

            // Create a double variable to store the last 10 ph level total...
            double phTotal2 = 0.0;
            // Create a double variable to store the last 10 co2 dissolved total...
            double co2Total2 = 0.0;



            // Create a double variable to store first 10 ph level avg...
            double fph_avg = 0.0;
            // Create a double variable to store last 10 ph level avg...
            double lph_avg = 0.0;


            // Create a double variable to store first 10 co2 dissolved avg...
            double fco2_avg = 0.0;
            // Create a double variable to store last 10 co2 dissolved avg...
            double lco2_avg = 0.0;


            // Find the total of the first 10 elements of the ph level and co2 arrays
            for (int k = 0; k < 10; k++) {

                // Compute the total of the first 10 ph levels...
                phTotal = phTotal + level[k];

                // Compute the total of the first 10 co2 dissolved...
                co2Total = co2Total + co2[k];

            }
            // Find the total of the last 10 elements of the ph level and co2 arrays
            for (int l = records - 10; l < records; l++) {

                // Compute the total of the last 10 ph levels...
                phTotal2 = phTotal2 + level[l];

                // Compute the total of the last 10 co2 dissolved...
                co2Total2 = co2Total2 + co2[l];

            }



            // Compute the first 10 ph levels average...
            fph_avg = phTotal / 10;

            // Compute the last 10 ph levels average...
            lph_avg = phTotal2 / 10;

            // Compute the first 10 ph levels average...
            fco2_avg = co2Total / 10;

            // Compute the last 10 ph levels average...
            lco2_avg = co2Total2 / 10;



            // Print out the first 10 and last 10 averages
            bw.write("\n************ pH Levels ************");
            // Print a blank line
            bw.newLine();
            // Print the first 10 ph level average...
            bw.write("Average (First 10): " + String.format("%.2f", fph_avg));
            // Print a blank line
            bw.newLine();
            // Print the last 10 ph level average...
            bw.write("Average (Last 10): " + String.format("%.2f", lph_avg));
            // Print a blank line
            bw.newLine();
            // Output the CO2 level dissolved header
            bw.write("************ Dissolved CO2 Levels ************");
            // Print a blank line
            bw.newLine();
            // Print the first 10 co2 dissolved average...
            bw.write("Average (First 10): " + String.format("%.2f", fco2_avg));
            // Print a blank line
            bw.newLine();
            // Print the last 10 co2 dissolved average...
            bw.write("Average (Last 10): " + String.format("%.2f", lco2_avg));
            // Print a blank line
            bw.newLine();

            // Close the buffer
            bw.close();



        }


        // If the file has not been found...
        catch (FileNotFoundException error) {}

        // If the file has not been found...
        catch (IOException e) {
            e.printStackTrace();
        }



    }




}