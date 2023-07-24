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
    public List<Country> sumWorldPop (Connection con){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population all around the world
            String strSelect =
                    "SELECT SUM(Population) AS world_pop FROM country";
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            List<Country> worldPop = new ArrayList<>();

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
            System.out.println("Failed to return population around the world [summary report]");
            return null;
        }
    }

    /**
     * gather the population of given amount of continents ( 1 continent )
     * @param topLimit
     * @param con
     * @return
     */
    public List<Country> sumContPop (Connection con, int topLimit){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each continent
            String strSelect =
                    "SELECT Continent, SUM(Population) AS cont_pop FROM country " +
                            "GROUP by Continent ORDER BY SUM(Population) DESC LIMIT " + topLimit;
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            List<Country> contPop = new ArrayList<>();

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
            System.out.println("Failed to return population of each continent [summary report]");
            return null;
        }
    }

    /**
     * gather population from given regions (1 region)
     * @param topLimit
     * @param con
     * @return
     */
    public List<Country> sumRegPop (Connection con, int topLimit){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each region
            String strSelect =
                    "SELECT Region, SUM(Population) AS reg_pop FROM country " +
                            "GROUP by Region ORDER BY SUM(Population) DESC LIMIT " + topLimit;
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            List<Country> regPop = new ArrayList<>();

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
            System.out.println("Failed to return population of each region [summary report]");
            return null;
        }
    }

    /**
     * gathers data of total population given number of countries ( 1 country)
     * @param topLimit
     * @param con
     * @return
     */
    public List<Country> sumCouPop (Connection con, int topLimit){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each region
            String strSelect =
                    "SELECT Name, Population AS reg_pop FROM country " +
                            "ORDER BY Population DESC LIMIT " + topLimit;
            // Execute SQL statement
            ResultSet pop = stmt.executeQuery(strSelect);
            List<Country> CountryPop = new ArrayList<>();

            while (pop.next()) {
                Country cp = new Country();
                cp.setName(pop.getString("Name"));
                cp.setGenPop(pop.getLong("reg_pop"));
                CountryPop.add(cp);
            }
            return CountryPop;
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return population of each country [summary report]");
            return null;
        }
    }

    /**
     * gathers data of total population of given amount of districts (1 district)
     * @param  topLimit
     * @param con
     * @return
     */
    public List<City> sumDistPop (Connection con, int topLimit){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each district
            String strSelect =
                    "SELECT District, SUM(Population) AS dist_pop FROM city " +
                            "GROUP by District ORDER BY SUM(Population) DESC LIMIT " + topLimit;
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
            System.out.println("Failed to return population of district [summary report]");
            return null;
        }
    }

    /**
     * gathers population data of given amount of cities (1 city)
     * @param con
     * @param topLimit
     * @return
     */
    public List<City> sumCityPop (Connection con, int topLimit){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each city
            String strSelect =
                    "SELECT Name, Population FROM city " +
                            "ORDER BY Population DESC LIMIT " + topLimit;
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
            System.out.println("Failed to return population the city [summary report]");
            return null;
        }
    }

    /**
     * returns the data gathered by sumWorldPop
     * @param popList
     */
    public void displaySumWorldPop(List<Country> popList)
    {
        try{
            // Loop over all data in the list
            for (Country cp : popList)
            {
                // Format and print of data
                String world_pop_info =
                        String.format("%-20s| %-20s",
                                "World Population",
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(world_pop_info);
            }
            System.out.println("");
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : World Population cannot be extracted [summary report]");
        }
    }

    /**
     * returns the data gathered by sumContPop
     * @param continentsList
     */
    public void displaySumContPop(List<Country> continentsList)
    {
        try{
            // Loop over all data in the list
            for (Country cp : continentsList)
            {
                // Formatting and printing data

                String cont_pop_info =
                        String.format("%-30s| %-30s",
                                cp.getContinent(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(cont_pop_info);
            }
            System.out.println("");
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : Continent Population cannot be extracted [summary report]");
        }
    }

    /**
     * returns data gathered by sumRegPop
     * @param regionList
     */
    public void displaySumRegPop(List<Country> regionList)
    {
        try{
            // Loop over all data in the list
            for (Country cp : regionList)
            {
                // Formatting and printing data

                String reg_pop_info =
                        String.format("%-30s| %-30s",
                                cp.getRegion(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(reg_pop_info);
            }
            System.out.println("");
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : Region Population cannot be extracted [summary report]");
        }
    }

    /**
     * Displays data gathered by sumCouPop
    // * @param contriesList
     */
    public void displaySumCouPop(List<Country> contriesList)
    {
        try {
            // Loop over all data in the list
            for (Country cp : contriesList)
            {
                // Formatting and printing data

                String cou_pop_info =
                        String.format("%-30s| %-30s",
                                cp.getName(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(cou_pop_info);
            }
            System.out.println("");
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : Country Population cannot be extracted [summary report]");
        }
    }

    /**
     * display data gathered by sumDistPop
     * @param districtsList
     */
    public void displaySumDistPop(List<City> districtsList)
    {
        try{
            // Loop over all data in the list
            for (City ct : districtsList)
            {
                // Formatting and printing data

                String dist_pop_info =
                        String.format("%-30s| %-30s",
                                ct.getDistrict(),
                                humanReadableFormatLong(ct.getGenPop()));
                System.out.println(dist_pop_info);
            }
            System.out.println("");

        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : District Population cannot be extracted [summary report]");
        }
    }

    /**
     * display data gathered by sumCityPop
     * @param citiesList
     */
    public void displaySumCityPop(List<City> citiesList)
    {
        try{
            // Loop over all data in the list
            for (City ct : citiesList)
            {
                // Formatting and printing data

                String city_pop_info =
                        String.format("%-30s| %-30s",
                                ct.getCityName(),
                                humanReadableFormatLong(ct.getPopulation()));
                System.out.println(city_pop_info);
            }
            System.out.println("");

        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : City Population cannot be extracted [summary report]");
        }
    }

    /**
     * human_readable_format method used to format the population numbers for long variables
     * e.g. 3242344 => 3,242,344
     * @param population
     * @return
     */
    public String humanReadableFormatLong(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }

}
