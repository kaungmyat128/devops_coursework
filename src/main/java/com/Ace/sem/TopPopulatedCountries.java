package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Creates methods to write sql queries and create arraylists of top 20 most populated countries
 * This Java Class File contains 3 java methods -
 * get_top_countries(), get_top_countries_continents() and get_top_countries_regions() methods
 */

// New Object of TopPopulatedCountries Java Class will be used from the App.java.
public class TopPopulatedCountries {
    /*
    get_top_countries() method contains connection parameters for database connection and
    write sql query to produce 'top 20 most populated countries around the world'.
    Then return the data as array list.
    */
     public ArrayList<Country> get_top_countries (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather top 10 populated country data
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

    //creates array to gather top 20 populated country data based on continents
    public ArrayList<Country> get_top_countries_continents (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                   "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                    + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital FROM country "
                    + "INNER JOIN city ON country.Capital = city.ID) AS subquery WHERE row_num <= 10 "
                    + "ORDER BY Continent ASC, Population DESC";
            // Execute SQL statement
            ResultSet query2 = stmt.executeQuery(strSelect);
            // Creates array to gather top 10 populated country data based on each continent
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query2);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }

        //creates array to gather top 10 populated country data based on regions
    public ArrayList<Country> get_top_countries_regions (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                    + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                    + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                    + "WHERE row_num <= 10 ORDER BY Region ASC, Population DESC";
            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);
            // Creates array to gather top 20 populated country data based on each continent
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query3);
        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }

    public ArrayList<Country> store_into_arraylist(ArrayList<Country> al, ResultSet qry) {
        try{
            // Extract population of countries information and store into array list
            while (qry.next()) {
                Country cp = new Country();
                cp.Code = qry.getString("Code");
                cp.Name = qry.getString("Name");
                cp.Continent = qry.getString("Continent");
                cp.Region = qry.getString("Region");
                cp.Population = qry.getInt("Population");
                cp.Capital = qry.getString("Capital");
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
}
