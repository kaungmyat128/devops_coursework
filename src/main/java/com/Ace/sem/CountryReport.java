package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Creates methods to write sql queries and create arraylists of countries population
 * This Java Class File contains 7 java methods -
 * get_countries(), get_countries_continent(),  get_countries_region() methods
 * store_into_arraylist() method
 * displayCountries(), displayCountries_continent() and displayCountries_region() methods
 * */
// New Object of CountryReport Java Class will be used from the App.java.
public class CountryReport {

    /**
     * get_countries() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries around the world'.
     * Then return the data as array list.
     * */
    public ArrayList<Country> get_countries (Connection con, int lim){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement with no limit - fetch all queries
                strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                                + "FROM country INNER JOIN city ON country.Capital = city.ID "
                                + "ORDER BY country.Population DESC LIMIT " + lim;
            } else if (lim==0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Countries
                strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                                + "FROM country INNER JOIN city ON country.Capital = city.ID "
                                + "ORDER BY country.Population DESC";
            }
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather country data based on population
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query1);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population around the world");
            return null;
        }
    }

    /**
     * get_countries_continent() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries based on each continent
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<Country> get_countries_continent(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0) {
                // Create string for SQL statement with no limit - fetch Countries population for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital FROM country "
                                + "INNER JOIN city ON country.Capital = city.ID) AS subquery WHERE row_num <= " + lim
                                + " ORDER BY Continent ASC, Population DESC";
            } else if (lim==0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Countries for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital FROM country "
                                + "INNER JOIN city ON country.Capital = city.ID) AS subquery "
                                + "ORDER BY Continent ASC, Population DESC";
            }
            // Execute SQL statement
            ResultSet query2 = stmt.executeQuery(strSelect);
            // Creates array to gather populated country data based on each continent
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population report");
            return null;
        }
    }

    /**
     * get_countries_region() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries based on each region
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<Country> get_countries_region(Connection con, int lim) {
        try {

                // Create an SQL statement
                Statement stmt = con.createStatement();
                String strSelect = null;
                // Create string for SQL statement
            if (lim>0) {
                // Create string for SQL statement with no limit - fetch Countries population for each region
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                                + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                                + "WHERE row_num <= " + lim + " ORDER BY Region ASC, Population DESC";
            } else if (lim==0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Countries for each region
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                                + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                                + "ORDER BY Region ASC, Population DESC";
            }
            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);
            // Creates array to gather countries population data based on each region
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population report");
            return null;
        }
    }

    /**
     * store_into_arraylist() method has two parameters - former for arraylist<Country> and later for query result
     * This method will assign  country information query results into the arrayList.
     * This method is reused in get_countries(), get_countries_continent() and get_countries_region() methods
     * in order to store query results as array lists and return it.
     */
    public ArrayList<Country> store_into_arraylist(ArrayList<Country> al, ResultSet qry) {
        try{
            // Extract population of countries information and store into array list
            while (qry.next()) {
                Country cp = new Country();
                cp.setCode(qry.getString("Code"));
                cp.setName(qry.getString("Name"));
                cp.setContinent(qry.getString("Continent"));
                cp.setRegion(qry.getString("Region"));
                cp.setPopulation(qry.getInt("Population"));
                cp.setCapital(qry.getString("Capital"));
                al.add(cp);
            }
            // return the array list
            return al;
        }// Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }
        // Display Countries Report using getter() method
        public void displayCountries(ArrayList<Country> countries_list)
        {
            // Print header
            System.out.println("============================================================");
            System.out.println("Countries sorted by population in the world ");

            System.out.println(String.format("%-10s %-40s %-15s %-27s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));
            // Loop over all countries population in the list
            for (Country cp : countries_list)
            {
                String countries_info =
                        String.format("%-10s %-40s %-15s %-27s %-15s %-15s",
                                cp.getCode(), cp.getName(), cp.getContinent(), cp.getRegion(),
                                human_readable_format(cp.getPopulation()), cp.getCapital());
                System.out.println(countries_info);
            }
            System.out.println("============================================================");
        }

        //display countries report based on continents using getter() and setter() methods
        public void displayCountries_Continent(ArrayList<Country> countries_list)
        {
            // Print header
            System.out.println("============================================================");

            // Initialize Current Continent variable
            String currentContinent = null;

            // Loop over all countries population in the list
            for (Country cp : countries_list)
            {
                // Check the current continent changed or not
                if (!cp.getContinent().equals(currentContinent)) {
                    // Print the continent header
                    System.out.println("\n Countries sorted by Population in " + cp.getContinent() + " Continent");
                    System.out.println("===========================================");
                    currentContinent = cp.getContinent();
                    System.out.println(String.format("%-10s %-40s %-15s %-27s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));

                }

                String countries_info =
                        String.format("%-10s %-40s %-15s %-27s %-15s %-15s",
                                cp.getCode(), cp.getName(), cp.getContinent(), cp.getRegion(),
                                cp.getPopulation(), cp.getCapital());
                System.out.println(countries_info);
            }
            System.out.println("============================================================");
        }

        //display countries report based on regions using getter() and setter() methods
        public void displayCountries_Region(ArrayList<Country> countries_list)
        {
            // Print header
            System.out.println("============================================================");

            // Initialize Current Region variable
            String currentRegion = null;

            // Loop over all countries population in the list
            for (Country cp : countries_list)
            {
                // Check the current continent changed or not
                if (!cp.getRegion().equals(currentRegion)) {
                    // Print the continent header
                    System.out.println("\n Countries sorted by Population in " + cp.getRegion() + " Region");
                    System.out.println("===========================================");
                    currentRegion = cp.getRegion();
                    System.out.println(String.format("%-10s %-40s %-15s %-27s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));

                }

                String countries_info =
                        String.format("%-10s %-40s %-15s %-27s %-15s %-15s",
                                cp.getCode(), cp.getName(), cp.getContinent(), cp.getRegion(),
                                cp.getPopulation(), cp.getCapital());
                System.out.println(countries_info);
            }
            System.out.println("============================================================");
        }

        public String human_readable_format(int population){
            NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
            String formattedCode = nf.format(population);
            return formattedCode;
        }
}
