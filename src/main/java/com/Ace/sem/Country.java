package com.Ace.sem;

import java.sql.*;
import java.util.*;

public class Country {
    /**
     * City Code
     */
    public String Code;
    /**
     * City Name
     */
    public String Name;

    /**
     * City Continent
     */
    public String Continent;

    /**
     * City Region
     */
    public String Region;

    /**
     * City Population
     */
    public int Population;

    /**
     * City Capital
     */
    public String Capital;


    //creating an array to gather data from country table
    public ArrayList<Country> getCountryPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, "
                            +"Population, Name "
                            + "FROM country "
                            + "ORDER BY Population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<Country>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("country.Code");
                cp.Name = rset.getString("country.Name");
                cp.Continent = rset.getString("country.Continent");
                cp.Region = rset.getString("country.Region");
                cp.Population = rset.getInt("country.Population");
                //cp. = rset.getString("city.Name");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    public ArrayList<Country> getCounContPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, "
                            +"Population, Name "
                            + "FROM country "
                            + "WHERE Continent = "
                            + "ORDER BY Population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<Country>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("country.Code");
                cp.Name = rset.getString("country.Name");
                cp.Continent = rset.getString("country.Continent");
                cp.Region = rset.getString("country.Region");
                cp.Population = rset.getInt("country.Population");
                //cp. = rset.getString("city.Name");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    public ArrayList<Country> getCounRegPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, "
                            +"Population, Name "
                            + "FROM country "
                            + "WHERE Region = "
                            + "ORDER BY Population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> Countrypop = new ArrayList<Country>();
            while (rset.next()) {
                Country cp = new Country();
                cp.Code = rset.getString("country.Code");
                cp.Name = rset.getString("country.Name");
                cp.Continent = rset.getString("country.Continent");
                cp.Region = rset.getString("country.Region");
                cp.Population = rset.getInt("country.Population");
                //cp. = rset.getString("city.Name");
                Countrypop.add(cp);
            }
            return Countrypop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }



    public void displayCountries(ArrayList<Country> countries_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 countries population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-20s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));
        // Loop over all countries population in the list
        for (Country cp : countries_list)
        {
            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population, cp.Capital);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    public void displayCountries_Continent(ArrayList<Country> countries_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 25 countries population in the world ");

        // Initialize Current Continent variable
        String currentContinent = null;

        // Loop over all countries population in the list
        for (Country cp : countries_list)
        {
            // Check the current continent changed or not
            if (!cp.Continent.equals(currentContinent)) {
                // Print the continent header
                System.out.println("\n Top N Countries Population in " + cp.Continent);
                System.out.println("===========================================");
                currentContinent = cp.Continent;
                System.out.println(String.format("%-10s %-20s %-15s %-20s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));

            }

            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population, cp.Capital);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}
