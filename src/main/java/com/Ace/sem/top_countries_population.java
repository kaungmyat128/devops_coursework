package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
    /**
     * Creates methods to write sql queries and create arraylists of top 20 countries
    */
public class top_countries_population {
    //creates array to gather top 20 populated country data
     public ArrayList<Country> get_top_countries (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 20";
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            // Extract population of countries information
            ArrayList<Country> top_countries_population = new ArrayList<>();
            while (query1.next()) {
                Country cp = new Country();
                cp.Code = query1.getString("country.Code");
                cp.Name = query1.getString("country.Name");
                cp.Continent = query1.getString("country.Continent");
                cp.Region = query1.getString("country.Region");
                cp.Population = query1.getInt("country.Population");
                cp.Capital = query1.getString("city.Name");
                top_countries_population.add(cp);
            }
            return top_countries_population;
        }
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
                    + "INNER JOIN city ON country.Capital = city.ID) AS subquery WHERE row_num <= 20 "
                    + "ORDER BY Continent ASC, Population DESC";
            // Execute SQL statement
            ResultSet query2 = stmt.executeQuery(strSelect);

            // Extract population of countries information
            ArrayList<Country> top_countries_population = new ArrayList<>();
            while (query2.next()) {
                Country cp = new Country();
                cp.Code = query2.getString("Code");
                cp.Name = query2.getString("Name");
                cp.Continent = query2.getString("Continent");
                cp.Region = query2.getString("Region");
                cp.Population = query2.getInt("Population");
                cp.Capital = query2.getString("Capital");
                top_countries_population.add(cp);
            }
            return top_countries_population;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }

        //creates array to gather top 20 populated country data based on regions
    public ArrayList<Country> get_top_countries_regions (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                    + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                    + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                    + "WHERE row_num <= 20 ORDER BY Region ASC, Population DESC";
            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);

            // Extract population of countries information
            ArrayList<Country> top_countries_population = new ArrayList<>();
            while (query3.next()) {
                Country cp = new Country();
                cp.Code = query3.getString("Code");
                cp.Name = query3.getString("Name");
                cp.Continent = query3.getString("Continent");
                cp.Region = query3.getString("Region");
                cp.Population = query3.getInt("Population");
                cp.Capital = query3.getString("Capital");
                top_countries_population.add(cp);
            }
            return top_countries_population;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }
}
