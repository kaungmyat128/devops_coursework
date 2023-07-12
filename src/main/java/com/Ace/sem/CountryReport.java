package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

    /**
     * Creates methods to write sql queries and create arraylists of all countries
    */
public class CountryReport {

    //creating an array to gather data from country table
    public ArrayList<Country> get_countries (Connection con, int lim){
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement
                strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                                + "FROM country INNER JOIN city ON country.Capital = city.ID "
                                + "ORDER BY country.Population DESC LIMIT " + lim;
            } else if (lim==0) {
                // Create string for SQL statement
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

    //creating an array of countries based on continents with descending order based on population
    public ArrayList<Country> get_countries_cont(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital FROM country "
                                + "INNER JOIN city ON country.Capital = city.ID) AS subquery "
                                + "ORDER BY Continent ASC, Population DESC";
            } else if (lim==0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital FROM country "
                                + "INNER JOIN city ON country.Capital = city.ID) AS subquery WHERE row_num <= " + lim
                                + " ORDER BY Continent ASC, Population DESC";
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

    //creating an array of countries based on region with descending order based on population
    public ArrayList<Country> get_countries_region(Connection con, int lim) {
        try {

                // Create an SQL statement
                Statement stmt = con.createStatement();
                String strSelect = null;
                // Create string for SQL statement
            if (lim>0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                                + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                                + "ORDER BY Region ASC, Population DESC";
            } else if (lim==0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                                + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                                + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                                + "WHERE row_num <= " + lim + " ORDER BY Region ASC, Population DESC";
            }


            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);
            // Creates array to gather top 20 populated country data based on each continent
            ArrayList<Country> top_countries_population = new ArrayList<>();
            return store_into_arraylist(top_countries_population, query3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population report");
            return null;
        }
    }


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
}
