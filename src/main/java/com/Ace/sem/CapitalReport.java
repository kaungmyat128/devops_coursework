package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CapitalReport {


    // To use the human_readable_format() method from country.java in this new object is created
    CountryReport formatPopulation = new CountryReport();

    /**
     * getCapitalPopByWorld() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated Capital cities around the world'.
     * Then return the data as array list.
     * */
    public ArrayList<City> getCapitalPopByWorld (Connection con,int lim){
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Capital City
                strSelect =
                        "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM `city` JOIN country ON country.Capital = city.ID " +
                                "ORDER BY city.Population DESC LIMIT " + lim;
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch all Capital Cities by population
                strSelect =
                        "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM `city` JOIN country ON country.Capital = city.ID " +
                                "ORDER BY city.Population DESC";
            }
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather Capital Cities data based on population
            ArrayList<City> CapitalPop = new ArrayList<>();
            return CapitalArrList(CapitalPop, query1);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return Capital Cities population around the world [capital report]");
            return null;
        }
    }

    /**
     * getCapitalPopByContinent() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated Capital Cities based on each continent
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCapitalPopByContinent (Connection con,int lim){
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Capital City
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) " +
                                "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                                "WHERE row_num <= " + lim +
                                " ORDER BY Continent ASC, CapitalPop DESC";
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch all Capital Cities by population
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) " +
                                "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                                "ORDER BY Continent ASC, CapitalPop DESC";
            }
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather Capital Cities data based on population
            ArrayList<City> CapitalPop = new ArrayList<>();
            return CapitalArrList(CapitalPop, query1);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return Capital Cities population for each continent [capital report]");
            return null;
        }
    }

    /**
     * getCapitalPopByRegion() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated Capital Cities based on each region
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCapitalPopByRegion (Connection con,int lim){
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0) {
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Capital City
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) " +
                                "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                                "WHERE row_num <= " + lim +
                                " ORDER BY Region ASC, CapitalPop DESC";
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch all Capital Cities by population
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) " +
                                "AS row_num, city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID) AS subquery " +
                                "ORDER BY Region ASC, CapitalPop DESC";
            }
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            //creates array to gather Capital Cities data based on population
            ArrayList<City> CapitalPop = new ArrayList<>();
            return CapitalArrList(CapitalPop, query1);

        }
        // Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return Capital Cities population around each Region [capital report]");
            return null;
        }
    }
    /**
     * CapitalArrList() method has two parameters - former for arraylist<City> and later for query result
     * This method will assign  City information query results into the arrayList.
     * This method is reused in getCapitalPopByWorld(), getCapitalPopByContinent() and getCapitalPopByRegion() methods
     * in order to store query results as array lists and return it.
     */
    public ArrayList<City> CapitalArrList(ArrayList<City> ar, ResultSet qry) {
        try {
            // Extract population of countries information and store into array list
            while (qry.next()) {
                City cty = new City();
                cty.setCityName(qry.getString("CapitalName"));
                cty.setCountryName(qry.getString("CountryName"));
                cty.setContinents(qry.getString("Continent"));
                cty.setRegion(qry.getString("Region"));
                cty.setPopulation(qry.getInt("CapitalPop"));
                ar.add(cty);
            }
            // return the array list
            return ar;
        }// Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return Capital Cities population [capital report]");
            return null;
        }
    }
    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapital(ArrayList<City> capitalList)
    {
        try{
            // Print header
            System.out.println("========================================================================================");
            System.out.println("Capital Cities sorted by population in the world ");

            System.out.println(String.format("%-35s |%-40s |%-18s |%-26s |%-15s","CapitalName", "CountryName", "Continent", "Region", "Population"));
            // Loop over all countries population in the list
            for (City cpr : capitalList)
            {
                String countries_info =
                        String.format("%-35s |%-40s |%-18s |%-26s |%-15s",
                                cpr.getCityName(),
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                formatPopulation.humanReadableFormat(cpr.getPopulation()));
                System.out.println(countries_info);
            }
            System.out.println("========================================================================================");
        }
        catch (Exception e) {
        //System.out.println(e.getMessage());
        System.out.println("Nothing to display : No Capital data can be extracted.[capital report]");
        }
    }

    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapitalContinent(ArrayList<City> capitalList)
    {
        try{
            // Print header
            System.out.println("========================================================================================");

            // Initialize Current Continent variable
            String currentContinent = null;

            // Loop over all countries population in the list
            for (City cpr : capitalList)
            {
                // Check the current continent changed or not
                if (!cpr.getContinents().equals(currentContinent)) {
                    // Print the continent header
                    System.out.println("\n Capitals sorted by Population in " + cpr.getContinents() + " Continent");
                    System.out.println("===========================================");
                    currentContinent = cpr.getContinents();
                    System.out.println(String.format("%-35s |%-40s |%-18s |%-26s |%-15s", "CapitalName", "CountryName", "Continent", "Region", "Population", "Capital City"));

                }

                String capitals_info =
                        String.format("%-35s |%-40s |%-18s |%-26s |%-15s",
                                cpr.getCityName(),
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                formatPopulation.humanReadableFormat(cpr.getPopulation()));
                System.out.println(capitals_info);
            }
            System.out.println("============================================================");

        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : No Capital data from continents can be extracted. [capital report]");
        }
    }
    /** Display Capital Cities Report using getter() method
     *
     * @param capitalList
     */
    public void displayCapitalRegion(ArrayList<City> capitalList) {
        try {
            // Print header
            System.out.println("========================================================================================");

            // Initialize Current Region variable
            String currentRegion = null;

            // Loop over all countries population in the list
            for (City cpr : capitalList) {
                // Check the current Region changed or not
                if (!cpr.getRegion().equals(currentRegion)) {
                    // Print the continent header
                    System.out.println("\n Capitals sorted by Population in " + cpr.getRegion() + " Region");
                    System.out.println("===========================================");
                    currentRegion = cpr.getRegion();
                    System.out.println(String.format("%-35s |%-40s |%-18s |%-26s |%-15s", "CapitalName", "CountryName", "Continent", "Region", "Population", "Capital City"));

                }

                String CapitalCity = nullChecker(cpr.getCityName());
                String capitals_info =
                        String.format("%-35s |%-40s |%-18s |%-26s |%-15s",
                                CapitalCity,
                                cpr.getCountryName(),
                                cpr.getContinents(),
                                cpr.getRegion(),
                                formatPopulation.humanReadableFormat(cpr.getPopulation()));
                System.out.println(capitals_info);
            }
            System.out.println("============================================================");
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : No Capital data from regions can be extracted.[capital report]");
        }
    }
    public String nullChecker(String checkElement){
        if(checkElement == null || checkElement == " " || checkElement == ""){
            return "-";
        }
        else{
            return checkElement;
        }
    }
}
