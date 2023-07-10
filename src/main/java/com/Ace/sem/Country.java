package com.Ace.sem;

import java.sql.*;
import java.util.*;

public class Country {
    public static void main(String[] args) {

    }
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
     * City SurfaceArea
     */
    public float SurfaceArea;
    /**
     * City IndepYear
     */
    public int IndepYear;

    /**
     * City Population
     */
    public int Population;

    /**
     * City LifeExpectancy
     */
    public float LifeExpectancy;

    /**
     * City GNP
     */
    public float GNP;

    /**
     * City GNPOld
     */
    public float GNPOld;

    /**
     * City LocalName
     */
    public String LocalName;
    /**
     * City GovermentForm
     */
    public String GovermentForm;

    /**
     * City HeadOfState
     */
    public String HeadOfState;

    /**
     * City Capital
     */
    public int Capital;
    /**
     * City Code2
     */
    public String Code2;

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


    public void displayInfo(ArrayList<Country> countrypop)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-10s %-15s %-15s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population"));
        // Loop over all employees in the list
        for (Country cp : countrypop)
        {
            String world_info =
                    String.format("%-10s %-15s %-15s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population);
            System.out.println(world_info);
        }
        System.out.println("============================================================");
    }

}
