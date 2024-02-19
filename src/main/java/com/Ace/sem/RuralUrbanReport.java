package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.List;

/**
 * Creates methods to write sql queries and
 * create arraylists of people living in cities & not living in cities
 * contains 7 java methods for gathering data
 * and displaying them
 * */
public class RuralUrbanReport {

    /**
     * contains connection parameters for database connection
     * The population of people, people living in cities,
     * and people not living in cities in each continent
     * Then return the data as array list.
     * */
    public List<City> getContinentPopulation(final Connection con) {
        // Create array list 'ruContinentPopulation' and add query result into array list
        final List<City> ruContPop = new ArrayList<>();
        // Create string for SQL statement with no limit - fetch all queries
        final String strSelect = "SELECT country.Continent as Continent_Name, "
                + "SUM(country.Population) AS Total_Population, "
                + "SUM(city.Total_Cities_Population) AS Cities_Population, "
                + "SUM(country.Population - city.Total_Cities_Population) AS Not_Cities_Population "
                + "FROM country "
                + "JOIN ( SELECT city.CountryCode , SUM(city.Population) AS Total_Cities_Population "
                + "FROM city GROUP BY city.CountryCode ) AS city ON country.code = city.CountryCode "
                + "GROUP BY country.Continent ORDER BY Total_Population DESC";

        try(Statement stmt = con.createStatement(); ResultSet query1 = stmt.executeQuery(strSelect)){
            // Extract population of countries information and store into array list
            while (query1.next()) {
                final City ruPop = new City();
                ruPop.setContinents(query1.getString("Continent_Name"));
                ruPop.setTotalPopulation(query1.getLong("Total_Population"));
                ruPop.setTotalCitiesPopulation(query1.getLong("Cities_Population"));
                ruPop.setTotalNotCitiesPopulation(query1.getLong("Not_Cities_Population"));
                ruContPop.add(ruPop);
            }
            return ruContPop;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each continent [Rural]");
            return ruContPop;
        }
        catch (Throwable e1){
            System.out.println("Error Occurred: " + e1.getMessage());
            return ruContPop;
        }
    }
    /**
     * contains connection parameters for database connection
     * The population of people, people living in cities,
     * and people not living in cities in each region
     * Then return the data as array list.
     * */
    public List<City> getRegionPopulation(final Connection con) {
        // Create array list 'RUContinentPopulation' and add query result into array list
        final List<City> ruRegPop = new ArrayList();
        // Create string for SQL statement with no limit - fetch all queries
        final String strSelect = "SELECT country.Region AS Region, SUM(country.Population) AS Total_Population, "
                + "SUM(city.cities_population) AS Cities_Population, "
                + "SUM(country.Population - city.cities_population) AS Not_Cities_Population "
                + "FROM country "
                + "JOIN ( SELECT city.countryCode, SUM(city.Population) AS cities_population "
                + "FROM city GROUP BY city.CountryCode ) AS city "
                + "ON city.CountryCode = country.Code "
                + "GROUP BY country.region "
                + "ORDER BY Total_Population DESC";
        try(Statement stmt = con.createStatement(); ResultSet query2 = stmt.executeQuery(strSelect)){
            // Extract population of countries information and store into array list
            while (query2.next()) {
                final City ruPop = new City();
                ruPop.setRegion(query2.getString("Region"));
                ruPop.setTotalPopulation(query2.getLong("Total_Population"));
                ruPop.setTotalCitiesPopulation(query2.getLong("Cities_Population"));
                ruPop.setTotalNotCitiesPopulation(query2.getLong("Not_Cities_Population"));
                ruRegPop.add(ruPop);
            }
            return ruRegPop;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each region [Rural]");
            return ruRegPop;
        }
        catch (Throwable e1){
            System.out.println("Error Occurred: " + e1.getMessage());
            return ruRegPop;
        }
    }
    /**
     * contains connection parameters for database connection
     * The population of people, people living in cities,
     * and people not living in cities in each country
     * Then return the data as array list.
     * */
    public List<City> getCountryPopulation(final Connection con) {
        // Create array list 'RUContinentPopulation' and add query result into array list
        final List<City> ruCounPop = new ArrayList<>();
        // Create string for SQL statement with no limit - fetch all queries
        final String strSelect = "SELECT country.Name AS Country, SUM(country.Population) AS total_population , "
                + "SUM(city.Population) AS Cities_Population, "
                + "SUM(country.population) - SUM(city.Population) AS Not_Cities_Population "
                + "FROM country "
                + "JOIN city ON country.Code = city.CountryCode "
                + "GROUP BY country.Name ORDER BY total_population DESC";
        try(Statement stmt = con.createStatement(); ResultSet query3 = stmt.executeQuery(strSelect)){
            // Extract population of countries information and store into array list
            while (query3.next()) {
                final City ruPop = new City();
                ruPop.setCountryName(query3.getString("Country"));
                ruPop.setTotalPopulation(query3.getLong("Total_Population"));
                ruPop.setTotalCitiesPopulation(query3.getLong("Cities_Population"));
                ruPop.setTotalNotCitiesPopulation(query3.getLong("Not_Cities_Population"));
//                if (query3.getLong("Not_Cities_Population") < 0){
//                    ruPop.setTotalNotCitiesPopulation(0);
//                }
//                else {
//                    ruPop.setTotalNotCitiesPopulation(query3.getLong("Not_Cities_Population"));
//                }
                ruCounPop.add(ruPop);
            }
            return ruCounPop;
        } catch (SQLException e) {
            System.out.println("Failed to get Population of People living in cities and not living in cities in each country [Rural]");
            return ruCounPop;
        }
        catch (Throwable e1){
            System.out.println("Error Occurred: " + e1.getMessage());
            return ruCounPop;
        }
    }
    /** Display Population of People living in cities
     *  and not living in cities in each continent
     *  Report using getter() method
     * @param arrList
     */
    public void displayContinentPopulation(final List<City> arrList)
    {
        try{
            // Print header
            System.out.println("==================================================================================================");
            System.out.println(String.format("%-40s | %-30s | %-35s | %-20s |", "Continent", "Total Population",
                    "People Living in Cities", "People Not Living in Cities"));
            // Loop over all cities population in the list
            for (final City c : arrList)
            {
                final double urbanPop = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st1 = String.format("%05.2f",urbanPop) + "%";
                final double ruralPop = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st2 = String.format("%05.2f",ruralPop) + "%";
                final String contPop =
                        String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s ) |",
                                c.getContinents(), humanReadableFormat(c.getTotalPopulation()),
                                humanReadableFormat(c.getTotalCitiesPopulation()), st1, "",
                                humanReadableFormat(c.getTotalNotCitiesPopulation()),st2);
                System.out.println(contPop);
            }
            System.out.println("==================================================================================================");
        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display: Rural Urban population of continents failed to extract [Rural]");
        }
        catch (Throwable e){
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
    /** Display Population of People living in cities
     *  and not living in cities in each region
     *  Report using getter() method
     * @param arrList
     */
    public void displayRegionPopulation(final List<City> arrList)
    {
        try {
            // Print header
            System.out.println("==================================================================================================");
            System.out.println(String.format("%-40s | %-30s | %-35s | %-20s |", "Region", "Total Population",
                    "People Living in Cities", "People Not Living in Cities"));
            // Loop over all cities population in the list
            for (final City c : arrList)
            {
                final double urbanPop = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st1 = String.format("%05.2f",urbanPop) + "%";
                final double ruralPop = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st2 = String.format("%05.2f",ruralPop) + "%";

                final String contPop =
                        String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s ) |",
                                c.getRegion(), humanReadableFormat(c.getTotalPopulation()),
                                humanReadableFormat(c.getTotalCitiesPopulation()), st1, "",
                                humanReadableFormat(c.getTotalNotCitiesPopulation()),st2);
                System.out.println(contPop);
            }
            System.out.println("==================================================================================================");

        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display: Rural Urban population of regions failed to extract [Rural]");
        }
        catch (Throwable e){
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
    /** Display Population of People living in cities
     *  and not living in cities in each country
     *  Report using getter() method
     * @param arrList
     */
    public void displayCountryPopulation(final List<City> arrList)
    {
        try{
            // Print header
            System.out.println("==================================================================================================");
            System.out.println(String.format("%-40s | %-30s | %-35s | %-20s |", "Country", "Total Population",
                    "People Living in Cities", "People Not Living in Cities"));
            // Loop over all cities population in the list
            for (final City c : arrList)
            {
                final double urbanPop = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st1 = String.format("%05.2f",urbanPop) + "%";
                final double ruralPop = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
                final String st2 = String.format("%05.2f",ruralPop) + "%";
                final String contPop =
                        String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s ) |",
                                c.getCountryName(), humanReadableFormat(c.getTotalPopulation()),
                                humanReadableFormat(c.getTotalCitiesPopulation()), st1, "",
                                humanReadableFormat(c.getTotalNotCitiesPopulation()),st2);
                System.out.println(contPop);
            }
            System.out.println("==================================================================================================");
        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display: Rural Urban population of countries failed to extract [Rural]");
        }
        catch (Throwable e){
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
    /**
     * human_readable_format method used to format
     * the population numbers for long variables
     * e.g. 3242344 => 3,242,344
     */
    public String humanReadableFormat(final long population){
        final NumberFormat numf = NumberFormat.getInstance(new Locale("en", "US"));
        return numf.format(population);
    }
}
