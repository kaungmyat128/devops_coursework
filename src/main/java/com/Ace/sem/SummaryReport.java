package com.Ace.sem;
import java.text.NumberFormat;
import java.util.*;
import java.sql.*;
/**
 * Contains methods to get population data of the world, continents, regions,
 * countries, districts, cities
 * the data gathered will be displayed using display methods.
 */
public class SummaryReport {

    CountryReport cr = new CountryReport();
    public ArrayList<Country> worldPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population all around the world
            String strSelect =
                    "SELECT SUM(Population) AS world_pop FROM country";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            ArrayList<Country> worldPop = new ArrayList<>();

            while (pop.next()) {
                Country cp = new Country();
                cp.setWorldPop(pop.getLong("world_pop"));
                worldPop.add(cp);
            }
            return worldPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population around the world");
            return null;
        }
    }

    public void displayWorldPop(ArrayList<Country> countries_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all countries population in the list
        for (Country cp : countries_list)
        {
            // Check the current continent changed or not

            // Print the continent header
            System.out.println("Population of the entire world");
            System.out.println("===========================================");
            System.out.println(String.format("%-15s|%-20s", "Location", "Population"));

            String countries_info =
                    String.format("%-15s|%-20s",
                            "World Population",
                            humanReadableFormatLong(cp.getWorldPop()));
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }











    public String humanReadableFormatLong(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }

}
