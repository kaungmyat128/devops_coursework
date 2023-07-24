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

    /**
     * gathers the population of the entire world
     * @param con
     * @return
     */
    public List<Country> sumWorldPop (final Connection con){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population all around the world
            String strSelect =
                    "SELECT SUM(Population) AS world_pop FROM country";
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final List<Country> worldPop = new ArrayList<>();

            while (pop.next()) {
                final Country cou = new Country();
                cou.setGenPop(pop.getLong("world_pop"));
                worldPop.add(cou);
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
    public List<Country> sumContPop (final Connection con, final int topLimit){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each continent
            final String strSelect =
                    "SELECT Continent, SUM(Population) AS cont_pop FROM country " +
                            "GROUP by Continent ORDER BY SUM(Population) DESC LIMIT " + topLimit;
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final List<Country> contPop = new ArrayList<>();

            while (pop.next()) {
                final Country cou = new Country();
                cou.setContinent(pop.getString("continent"));
                cou.setGenPop(pop.getLong("cont_pop"));
                contPop.add(cou);
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
    public List<Country> sumRegPop (final Connection con, final int topLimit){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each region
            final String strSelect =
                    "SELECT Region, SUM(Population) AS reg_pop FROM country " +
                            "GROUP by Region ORDER BY SUM(Population) DESC LIMIT " + topLimit;
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final List<Country> regPop = new ArrayList<>();

            while (pop.next()) {
                final Country cou = new Country();
                cou.setRegion(pop.getString("region"));
                cou.setGenPop(pop.getLong("reg_pop"));
                regPop.add(cou);
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
    public List<Country> sumCouPop (final Connection con, final int topLimit){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each region
            final String strSelect =
                    "SELECT Name, Population AS reg_pop FROM country " +
                            "ORDER BY Population DESC LIMIT " + topLimit;
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final List<Country> countryPop = new ArrayList<>();

            while (pop.next()) {
                final Country cou = new Country();
                cou.setName(pop.getString("Name"));
                cou.setGenPop(pop.getLong("reg_pop"));
                countryPop.add(cou);
            }
            return countryPop;
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
    public List<City> sumDistPop (final Connection con, final int topLimit){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each district
            final String strSelect =
                    "SELECT District, SUM(Population) AS dist_pop FROM city " +
                            "GROUP by District ORDER BY SUM(Population) DESC LIMIT " + topLimit;
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final ArrayList<City> distPop = new ArrayList<>();

            while (pop.next()) {
                final City cty = new City();
                cty.setDistrict(pop.getString("District"));
                cty.setGenPop(pop.getLong("dist_pop"));
                distPop.add(cty);
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
    public List<City> sumCityPop (final Connection con, final int topLimit){
        try {

            // Create an SQL statement
            final Statement stmt = con.createStatement();
            // Create string for SQL statement of population from each city
            final String strSelect =
                    "SELECT Name, Population FROM city " +
                            "ORDER BY Population DESC LIMIT " + topLimit;
            // Execute SQL statement
            final ResultSet pop = stmt.executeQuery(strSelect);
            final ArrayList<City> cityPop = new ArrayList<>();

            while (pop.next()) {
                final City cty = new City();
                cty.setCityName(pop.getString("Name"));
                cty.setPopulation(pop.getInt("Population"));
                cityPop.add(cty);
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
    public void displaySumWorldPop(final List<Country> popList)
    {
        try{
            // Loop over all data in the list
            for (final Country cp : popList)
            {
                // Format and print of data
                final String worldPopInfo =
                        String.format("%-20s| %-20s",
                                "World Population",
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(worldPopInfo);
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
    public void displaySumContPop(final List<Country> continentsList)
    {
        try{
            // Loop over all data in the list
            for (final Country cp : continentsList)
            {
                // Formatting and printing data

                final String contPopInfo =
                        String.format("%-30s| %-30s",
                                cp.getContinent(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(contPopInfo);
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
    public void displaySumRegPop(final List<Country> regionList)
    {
        try{
            // Loop over all data in the list
            for (final Country cp : regionList)
            {
                // Formatting and printing data

                final String regPopInfo =
                        String.format("%-30s| %-30s",
                                cp.getRegion(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(regPopInfo);
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
    public void displaySumCouPop(final List<Country> contriesList)
    {
        try {
            // Loop over all data in the list
            for (final Country cp : contriesList)
            {
                // Formatting and printing data

                final String couPopInfo =
                        String.format("%-30s| %-30s",
                                cp.getName(),
                                humanReadableFormatLong(cp.getGenPop()));
                System.out.println(couPopInfo);
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
    public void displaySumDistPop(final List<City> districtsList)
    {
        try{
            // Loop over all data in the list
            for (final City ct : districtsList)
            {
                // Formatting and printing data

                final String distPopInfo =
                        String.format("%-30s| %-30s",
                                ct.getDistrict(),
                                humanReadableFormatLong(ct.getGenPop()));
                System.out.println(distPopInfo);
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
    public void displaySumCityPop(final List<City> citiesList)
    {
        try{
            // Loop over all data in the list
            for (final City ct : citiesList)
            {
                // Formatting and printing data

                final String cityPopInfo =
                        String.format("%-30s| %-30s",
                                ct.getCityName(),
                                humanReadableFormatLong(ct.getPopulation()));
                System.out.println(cityPopInfo);
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
    public String humanReadableFormatLong(final long population){
        final NumberFormat numf = NumberFormat.getInstance(new Locale("en", "US"));
        return numf.format(population);
    }

}
