package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Creates methods to write sql queries and create arraylists of cities population
 * 3 fetching methods that use database connection and limit as parameters
 * 3 display methods that use ArrayList as parameter
 * */

public class CapitalReport {
    /**
     * database connection parameters and limit parameter
     * write sql query to produce 'ALL or Top N most populated
     * Capital cities around the world'.
     * Then return the data as array list.
     * */
    public List<City> getCapitalPopByWorld (final Connection con,final int lim){
        //creates array to gather Capital Cities data based on population
        final List<City> capitalPop = new ArrayList<>();

        String strSelect = null;
        if (lim>0) {
            // Create string for SQL statement with limit 'N'
            // - fetch Top N Populated Capital City
            strSelect =
                    "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM `city` JOIN country ON country.Capital = city.ID " +
                            "ORDER BY city.Population DESC LIMIT " + lim;
        } else if (lim==0) {
            // Create string for SQL statement with no limit
            // - fetch all Capital Cities by population
            strSelect =
                    "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM `city` JOIN country ON country.Capital = city.ID " +
                            "ORDER BY city.Population DESC";
        }
        try(Statement stmt = con.createStatement(); ResultSet query1 = stmt.executeQuery(strSelect)){
            return capitalArrList(capitalPop, query1);
        }
        // Exception handling when any errors occur.
        // Print out error type and error message and return null.
        catch (SQLException e1) {
            System.out.println("Failed to gather Capital Cities population around the world [capital report]");
            return capitalPop;
        }
        catch (Throwable e2) {
            System.out.println("Error Occurred");
            System.out.print(e2.getMessage());
            return capitalPop;
        }

    }

    /**
     * contains database connection parameter and limit parameter
     * write sql query to produce 'ALL or Top N most populated
     * Capital Cities based on each continent
     * with descending order of population' Then return the data as array list.
     * */
    public List<City> getCapitalPopByContinent (final Connection con,final int lim){
        //creates array to gather Capital Cities data based on population
        final List<City> capitalPop = new ArrayList<>();
        String strSelect = null;
        if (lim>0) {
            // Create string for SQL statement with limit 'N'
            // - fetch Top N Populated Capital City
            strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) " +
                            "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                            "WHERE row_num <= " + lim +
                            " ORDER BY Continent ASC, CapitalPop DESC";
        } else if (lim==0) {
            // Create string for SQL statement with no limit
            // - fetch all Capital Cities by population
            strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) " +
                            "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                            "ORDER BY Continent ASC, CapitalPop DESC";
        }
        try(Statement stmt = con.createStatement(); ResultSet query1 = stmt.executeQuery(strSelect)){
            return capitalArrList(capitalPop, query1);
        }
        // Exception handling when any errors occur.
        // Print out error type and error message and return null.
        catch (SQLException e1) {
            System.out.println("Failed to gather Capital Cities population around the world [capital report]");
            return capitalPop;
        }
        catch (Throwable e2) {
            System.out.println("Error Occurred");
            System.out.print(e2.getMessage());
            return capitalPop;
        }
    }

    /**
     * contains database connection parameter and limit parameter
     * write sql query to produce 'ALL or Top N
     * most populated Capital Cities based on each region
     * with descending order of population Then return the data as array list.
     * */
    public List<City> getCapitalPopByRegion (final Connection con,final int lim){
        //creates array to gather Capital Cities data based on population
        final List<City> capitalPop = new ArrayList();
        String strSelect = null;
        if (lim>0) {
            // Create string for SQL statement with limit 'N'
            // - fetch Top N Populated Capital City
            strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) " +
                            "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                            "WHERE row_num <= " + lim +
                            " ORDER BY Region ASC, CapitalPop DESC";
        } else if (lim==0) {
            // Create string for SQL statement with no limit
            // - fetch all Capital Cities by population
            strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) " +
                            "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                            "ORDER BY Region ASC, CapitalPop DESC";
        }
        try(Statement stmt = con.createStatement(); ResultSet query1 = stmt.executeQuery(strSelect)){
           return capitalArrList(capitalPop, query1);
        }
        // Exception handling when any errors occur.
        // Print out error type and error message and return null.
        catch (SQLException e1) {
            System.out.println("Failed to gather Capital Cities population around the world [capital report]");
            return capitalPop;
        }
        catch (Throwable e2) {
            System.out.println("Error Occurred");
            System.out.print(e2.getMessage());
            return capitalPop;
        }
    }
    /**
     * capitalArrList() method has two parameters
     * - former for arraylist<City> and later for query result
     * This method will assign  City information query results into the arrayList.
     * This method is reused in getCapitalPopByWorld(),
     * getCapitalPopByContinent() and getCapitalPopByRegion() methods
     * in order to store query results as array lists and return it.
     */
    public List<City> capitalArrList(final List<City> arr, final ResultSet qry) {
        try {
            // Extract population of countries information and store into array list
            while (qry.next()) {
                final City cty = new City();
                cty.setCityName(qry.getString("CapitalName"));
                cty.setCountryName(qry.getString("CountryName"));
                cty.setContinents(qry.getString("Continent"));
                cty.setRegion(qry.getString("Region"));
                cty.setPopulation(qry.getInt("CapitalPop"));
                arr.add(cty);
            }
            // return the array list
            return arr;
        }// Exception handling when any errors occur.
         // Print out error type and error message and return null.
        catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return Capital Cities population [capital report]");
            return arr;
        }
    }
    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapital(final List<City> capitalList)
    {
        try{
            // Print header
            System.out.println("========================================================================================");
            System.out.println("Capital Cities sorted by population in the world ");

            System.out.println(String.format("%-35s | %-40s | %-18s | %-26s | %-15s |","CapitalName", "CountryName", "Continent", "Region", "Population"));
            // Loop over all countries population in the list
            for (final City cpr : capitalList)
            {
                final String countriesInfo =
                        String.format("%-35s | %-40s | %-18s | %-26s | %-15s |",
                                cpr.getCityName(),
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                CountryReport.humanReadableFormat(cpr.getPopulation()));
                System.out.println(countriesInfo);
            }
            System.out.println("========================================================================================");
        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display : No Capital data can be extracted.[capital report]");
        }
        catch (Throwable e2) {
            System.out.println("Cannot display: Error occurred");
            System.out.println(e2.getMessage());
        }
    }

    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapitalContinent(final List<City> capitalList)
    {
        try{
            // Print header
            System.out.println("========================================================================================");

            // Initialize Current Continent variable
            String currentContinent = null;

            // Loop over all countries population in the list
            for (final City cpr : capitalList)
            {
                // Check the current continent changed or not
                if (!cpr.getContinents().equals(currentContinent)) {
                    // Print the continent header
                    System.out.println("\n Capitals sorted by Population in " + cpr.getContinents() + " Continent");
                    System.out.println("========================================================================================");
                    currentContinent = cpr.getContinents();
                    System.out.println(String.format("%-35s | %-40s | %-18s | %-26s | %-15s |", "CapitalName", "CountryName", "Continent", "Region", "Population", "Capital City"));

                }

                final String capitalCity = nullChecker(cpr.getCityName());
                final String capitalsInfo =
                        String.format("%-35s | %-40s | %-18s | %-26s | %-15s |",
                                capitalCity,
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                CountryReport.humanReadableFormat(cpr.getPopulation()));
                System.out.println(capitalsInfo);
            }
            System.out.println("========================================================================================");

        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display : No Capital data can be extracted.[capital report]");
        }
        catch (Throwable e2) {
            System.out.println("Cannot display: Error occurred");
            System.out.println(e2.getMessage());
        }
    }
    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapitalRegion(final List<City> capitalList) {
        try {
            // Print header
            System.out.println("========================================================================================");

            // Initialize Current Region variable
            String currentRegion = null;

            // Loop over all countries population in the list
            for (final City cpr : capitalList) {
                // Check the current Region changed or not
                if (!cpr.getRegion().equals(currentRegion)) {
                    // Print the continent header
                    System.out.println("\n Capitals sorted by Population in " + cpr.getRegion() + " Region");
                    System.out.println("========================================================================================");
                    currentRegion = cpr.getRegion();
                    System.out.println(String.format("%-35s | %-40s | %-18s | %-26s | %-15s |", "CapitalName", "CountryName", "Continent", "Region", "Population", "Capital City"));

                }

                final String capitalCity = nullChecker(cpr.getCityName());
                final String capitalsInfo =
                        String.format("%-35s | %-40s | %-18s | %-26s | %-15s |",
                                capitalCity,
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                CountryReport.humanReadableFormat(cpr.getPopulation()));
                System.out.println(capitalsInfo);
            }
            System.out.println("========================================================================================");
        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display : No Capital data can be extracted.[capital report]");
        }
        catch (Throwable e2) {
            System.out.println("Cannot display: Error occurred");
            System.out.println(e2.getMessage());
        }
    }
    /**
     * This method used to check a column value is null or empty.
     * If 'checkElement' is null, empty, or contains only spaces, it returns hyphen.
     * Otherwise, it returns the original 'checkElement'.
     */
    public String nullChecker(final String checkElement){
        if(checkElement == null || checkElement.equals(" ") || checkElement.equals("")){
            return "-";
        }
        else{
            return checkElement;
        }
    }
}
