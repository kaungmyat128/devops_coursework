package com.Ace.sem;

import java.sql.*;
import java.util.*;
    /**
     * Declares variables to be used for country related reports
     * Creates methods for displaying reports
     */
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

    //display all countries
    public void displayCountries(ArrayList<Country> countries_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Countries sorted by population in the world ");

        System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));
        // Loop over all countries population in the list
        for (Country cp : countries_list)
        {
            String countries_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population, cp.Capital);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    //display regions based on continents
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
            if (!cp.Continent.equals(currentContinent)) {
                // Print the continent header
                System.out.println("\n Countries sorted by Population in " + cp.Continent + " Continent");
                System.out.println("===========================================");
                currentContinent = cp.Continent;
                System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));

            }

            String countries_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population, cp.Capital);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    //display countries based on region
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
            if (!cp.Region.equals(currentRegion)) {
                // Print the continent header
                System.out.println("\n Countries sorted by Population in " + cp.Region + " Region");
                System.out.println("===========================================");
                currentRegion = cp.Region;
                System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "Name", "Continent", "Region", "Population", "Capital City"));

            }

            String countries_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            cp.Code, cp.Name, cp.Continent, cp.Region, cp.Population, cp.Capital);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}
