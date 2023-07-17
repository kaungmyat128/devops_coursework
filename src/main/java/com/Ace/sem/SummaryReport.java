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

    /**
     * gathers the population of the entire world
     * @param con
     * @return
     */
    public ArrayList<Country> sumWorldPop (Connection con){
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
                cp.setGenPop(pop.getLong("world_pop"));
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

    /**
     * gather the population of each continent
     * @param con
     * @return
     */
    public ArrayList<Country> sumContPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each continent
            String strSelect =
                    "SELECT Continent, SUM(Population) AS cont_pop FROM country " +
                            "GROUP by Continent ORDER BY SUM(Population) DESC";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            ArrayList<Country> contPop = new ArrayList<>();

            while (pop.next()) {
                Country cp = new Country();
                cp.setContinent(pop.getString("continent"));
                cp.setGenPop(pop.getLong("cont_pop"));
                contPop.add(cp);
            }
            return contPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population of each continent");
            return null;
        }
    }

    /**
     * gathers data of total population from each region
     * @param con
     * @return
     */
    public ArrayList<Country> sumRegPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each region
            String strSelect =
                    "SELECT Region, SUM(Population) AS reg_pop FROM country " +
                            "GROUP by Region ORDER BY SUM(Population) DESC";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            ArrayList<Country> regPop = new ArrayList<>();

            while (pop.next()) {
                Country cp = new Country();
                cp.setRegion(pop.getString("region"));
                cp.setGenPop(pop.getLong("reg_pop"));
                regPop.add(cp);
            }
            return regPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population of each region");
            return null;
        }
    }

    /**
     * gathers data of total population from each country
     * @param con
     * @return
     */
    //public ArrayList<Country> sumCouPop (Connection con){

    //}

    /**
     * gathers data of total population from each district
     * @param con
     * @return
     */
    public ArrayList<City> sumDistPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each district
            String strSelect =
                    "SELECT District, SUM(Population) AS dist_pop FROM city " +
                            "GROUP by District ORDER BY SUM(Population) DESC";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            ArrayList<City> distPop = new ArrayList<>();

            while (pop.next()) {
                City ct = new City();
                ct.setDistrict(pop.getString("District"));
                ct.setGenPop(pop.getLong("dist_pop"));
                distPop.add(ct);
            }
            return distPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population of each district");
            return null;
        }
    }

    public ArrayList<City> sumCityPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each city
            String strSelect =
                    "SELECT Name, Population FROM city " +
                            "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            ArrayList<City> cityPop = new ArrayList<>();

            while (pop.next()) {
                City ct = new City();
                ct.setCityName(pop.getString("Name"));
                ct.setPopulation(pop.getInt("Population"));
                cityPop.add(ct);
            }
            return cityPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population of each district");
            return null;
        }
    }

    /**
     * returns the data gathered by sumWorldPop
     * @param pop_list
     */
    public void displaySumWorldPop(ArrayList<Country> pop_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all data in the list
        for (Country cp : pop_list)
        {
            // Format and print of data
            System.out.println("Population of the entire world");
            System.out.println("===========================================");

            String worldpop_info =
                    String.format("%-20s| %-20s",
                            "World Population",
                            humanReadableFormatLong(cp.getGenPop()));
            System.out.println(worldpop_info);
        }
        System.out.println("============================================================");
    }

    /**
     * returns the data gathered by sumContPop
     * @param cont_pop_list
     */
    public void displaySumContPop(ArrayList<Country> cont_pop_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all data in the list
        for (Country cp : cont_pop_list)
        {
            // Formatting and printing data

            String contpop_info =
                    String.format("%-30s| %-30s",
                            cp.getContinent(),
                            humanReadableFormatLong(cp.getGenPop()));
            System.out.println(contpop_info);
        }
        System.out.println("============================================================");
    }

    /**
     * returns data gathered by sumRegPop
     * @param reg_pop_list
     */
    public void displaySumRegPop(ArrayList<Country> reg_pop_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all data in the list
        for (Country cp : reg_pop_list)
        {
            // Formatting and printing data

            String regpop_info =
                    String.format("%-30s| %-30s",
                            cp.getRegion(),
                            humanReadableFormatLong(cp.getGenPop()));
            System.out.println(regpop_info);
        }
        System.out.println("============================================================");
    }

    /**
     * Displays data gathered by sumCouPop
    // * @param reg_pop_list
     */
    //public void displaySumCouPop(ArrayList<Country> reg_pop_list)
    //{

    //}

    /**
     * display data gathered by sumDistPop
     * @param dist_pop_list
     */
    public void displaySumDistPop(ArrayList<City> dist_pop_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all data in the list
        for (City ct : dist_pop_list)
        {
            // Formatting and printing data

            String distpop_info =
                    String.format("%-30s| %-30s",
                            ct.getDistrict(),
                            humanReadableFormatLong(ct.getGenPop()));
            System.out.println(distpop_info);
        }
        System.out.println("============================================================");
    }

    /**
     * display data gathered by sumCityPop
     * @param city_pop_list
     */
    public void displaySumCityPop(ArrayList<City> city_pop_list)
    {
        // Print header
        System.out.println("============================================================");

        // Loop over all data in the list
        for (City ct : city_pop_list)
        {
            // Formatting and printing data

            String citypop_info =
                    String.format("%-30s| %-30s",
                            ct.getCityName(),
                            humanReadableFormatLong(ct.getPopulation()));
            System.out.println(citypop_info);
        }
        System.out.println("============================================================");
    }










    public String humanReadableFormatLong(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }

}
