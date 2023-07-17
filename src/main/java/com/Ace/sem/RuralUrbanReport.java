package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * Creates methods to write sql queries and create arraylists of people living in cities & not living in cities
 * This Java Class File contains 7 java methods -
 * getContinentPopulation(), getRegionPopulation(),  getCountryPopulation() methods
 * displayContinentPopulation(), displayRegionPopulation() and displayCountryPopulation() methods
 * human_readable_format() for formatting population
 * */
public class RuralUrbanReport {

    /**
     * getContinentPopulation() method contains connection parameters for database connection
     * The population of people, people living in cities, and people not living in cities in each continent
     * Then return the data as array list.
     * */
    public ArrayList<City> getContinentPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Continent as Continent_Name, "
                                + "SUM(country.Population) AS Total_Population, "
                                + "SUM(city.Total_Cities_Population) AS Cities_Population, "
                                + "SUM(country.Population - city.Total_Cities_Population) AS Not_Cities_Population "
                                + "FROM country "
                                + "JOIN ( SELECT city.CountryCode , SUM(city.Population) AS Total_Cities_Population "
                                + "FROM city GROUP BY city.CountryCode ) AS city ON country.code = city.CountryCode "
                                + "GROUP BY country.Continent ORDER BY country.Continent";

            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RUContinentPopulation = new ArrayList<City>();
            // Extract population of countries information and store into array list
            while (query1.next()) {
                City RUPop = new City();
                RUPop.setCountryName(query1.getString("Country"));
                RUPop.setTotalPopulation(query1.getLong("Total_Population"));
                RUPop.setTotalCitiesPopulation(query1.getLong("Cities_Population"));
                RUPop.setTotalNotCitiesPopulation(query1.getLong("Not_Cities_Population"));
                RUContinentPopulation.add(RUPop);
            }
            return RUContinentPopulation;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each continent");
            return null;
        }
    }

    /**
     * getContinentPopulation() method contains connection parameters for database connection
     * The population of people, people living in cities, and people not living in cities in each region
     * Then return the data as array list.
     * */    public ArrayList<City> getRegionPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Region AS Region, SUM(country.Population) AS Total_Population, "
                    + "SUM(city.cities_population) AS Cities_Population, "
                    + "SUM(country.Population - city.cities_population) AS Not_Cities_Population "
                    + "FROM country "
                    + "JOIN ( SELECT city.countryCode, SUM(city.Population) AS cities_population "
                    + "FROM city GROUP BY city.CountryCode ) AS city "
                    + "ON city.CountryCode = country.Code "
                    + "GROUP BY country.region "
                    + "ORDER BY country.Region";

            // Execute SQL statement
            ResultSet query2 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RURegionPopulation = new ArrayList<City>();
            // Extract population of countries information and store into array list
            while (query2.next()) {
                City RUPop = new City();
                RUPop.setCountryName(query2.getString("Country"));
                RUPop.setTotalPopulation(query2.getLong("Total_Population"));
                RUPop.setTotalCitiesPopulation(query2.getLong("Cities_Population"));
                RUPop.setTotalNotCitiesPopulation(query2.getLong("Not_Cities_Population"));
                RURegionPopulation.add(RUPop);
            }
            return RURegionPopulation;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each region");
            return null;
        }
    }

    /**
     * getContinentPopulation() method contains connection parameters for database connection
     * The population of people, people living in cities, and people not living in cities in each country
     * Then return the data as array list.
     * */    public ArrayList<City> getCountryPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Name AS Country, SUM(country.Population) AS total_population , "
                    + "SUM(city.Population) AS Cities_Population, "
                    + "SUM(country.population) - SUM(city.Population) AS Not_Cities_Population "
                    + "FROM country "
                    + "JOIN city ON country.Code = city.CountryCode "
                    + "GROUP BY country.Name ORDER BY country.Name";

            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RUCountryPopulation = new ArrayList<City>();
            // Extract population of countries information and store into array list
            while (query3.next()) {
                City RUPop = new City();
                RUPop.setCountryName(query3.getString("Country"));
                RUPop.setTotalPopulation(query3.getLong("Total_Population"));
                RUPop.setTotalCitiesPopulation(query3.getLong("Cities_Population"));
                RUPop.setTotalNotCitiesPopulation(query3.getLong("Not_Cities_Population"));
                RUCountryPopulation.add(RUPop);
            }
            return RUCountryPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each country");
            return null;
        }
    }


    /** Display Population of People living in cities and not living in cities in each continent
     *  Report using getter() method
     *
     * @param arrList
     */
    public void displayContinentPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Continent", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getContinents(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }

    /** Display Population of People living in cities and not living in cities in each region
     *  Report using getter() method
     *
     * @param arrList
     */
    public void displayRegionPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Region", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getRegion(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }



    /** Display Population of People living in cities and not living in cities in each country
     *  Report using getter() method
     *
     * @param arrList
     */
    public void displayCountryPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Country", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getCountryName(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }


    public String humanReadableFormat(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }
}
