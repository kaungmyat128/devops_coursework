package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CapitalReport {

    // Create new object of CountryReport to use human_readable_format() method from country.java
    CountryReport formatPopulation = new CountryReport();

    public ArrayList<City> getCapitalPopByWorld (Connection con,int lim){
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Capital City
                strSelect =
                        "SELECT city.Name AS CapitalName, country.Name AS CountryName, city.Population AS CapitalPop " +
                                "FROM `city` JOIN country ON country.Capital = city.ID " +
                                "ORDER BY city.Population DESC LIMIT " + lim;
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch all Capital Cities by population
                strSelect =
                        "SELECT city.Name AS CapitalName, country.Name AS CountryName, city.Population AS CapitalPop " +
                                "FROM `city` JOIN country ON country.Capital = city.ID " +
                                "ORDER BY city.Population DESC";
            }
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather country data based on population
            ArrayList<City> CapitalPop = new ArrayList<>();
            return CapitalArrList(CapitalPop, query1);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population around the world");
            return null;
        }
    }
    public ArrayList<City> CapitalArrList(ArrayList<City> ar, ResultSet qry) {
        try {
            // Extract population of countries information and store into array list
            while (qry.next()) {
                City cty = new City();
                cty.setCityName(qry.getString("CapitalName"));
                cty.setCountryName(qry.getString("CountryName"));
                cty.setPopulation(qry.getInt("CapitalPop"));
                ar.add(cty);
            }
            // return the array list
            return ar;
        }// Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return countries population in each continent");
            return null;
        }
    }
    public void displayCapital(ArrayList<City> capitalList)
    {
        // Print header
        System.out.println("========================================================================================");
        System.out.println("Capital Cities sorted by population in the world ");

        System.out.println(String.format("%-40s |%-40s |%-20s","CapitalName", "CountryName", "Population"));
        // Loop over all countries population in the list
        for (City cpr : capitalList)
        {
            String countries_info =
                    String.format("%-40s |%-40s |%-20s",
                            cpr.getCityName(),
                            cpr.getCountryName(),
                            formatPopulation.humanReadableFormat(cpr.getPopulation()));
            System.out.println(countries_info);
        }
        System.out.println("========================================================================================");
    }
}
