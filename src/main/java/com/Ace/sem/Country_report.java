package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

    /**
     * Creates methods to write sql queries and create arraylists of all countries
    */
public class Country_report extends Country{

    //creating an array to gather data from country table
    public ArrayList<Country> getCountryPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, "
                            +"country.Population, city.Name "
                            + "FROM country JOIN city on city.ID = country.Capital "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("country.Code");
                cp.Name = rset.getString("country.Name");
                cp.Continent = rset.getString("country.Continent");
                cp.Region = rset.getString("country.Region");
                cp.Population = rset.getInt("country.Population");
                cp.Capital = rset.getString("city.Name");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    //creating an array of countries based on continents with descending order based on population
    public ArrayList<Country> getCounContPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY country.Population DESC) AS row_num, "
                            + "country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital FROM country "
                            + "INNER JOIN city ON country.Capital = city.ID) AS subquery "
                            + "ORDER BY Continent ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("Code");
                cp.Name = rset.getString("Name");
                cp.Continent = rset.getString("Continent");
                cp.Region = rset.getString("Region");
                cp.Population = rset.getInt("Population");
                cp.Capital = rset.getString("Capital");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    //creating an array of countries based on region with descending order based on population
    public ArrayList<Country> getCounRegPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY country.Population DESC) AS row_num, "
                            + "country.Code, country.Name, country.Continent, country.Region, country.Population, "
                            + "city.Name as Capital FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery "
                            + "ORDER BY Region ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("Code");
                cp.Name = rset.getString("Name");
                cp.Continent = rset.getString("Continent");
                cp.Region = rset.getString("Region");
                cp.Population = rset.getInt("Population");
                cp.Capital = rset.getString("Capital");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

}
