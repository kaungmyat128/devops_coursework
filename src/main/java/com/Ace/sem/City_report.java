package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class City_report extends City {
    public ArrayList<City> get_city_world (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT (city.Name) AS CityName,country.Name AS CountryName,city.District,city.Population "
                            + "FROM city INNER JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY Population DESC LIMIT 5";
            // Execute SQL statement
            ResultSet data1 = stmt.executeQuery(strSelect);
            // Extract population of city information for entire world
            ArrayList<City> City_report = new ArrayList<>();
            while (data1.next()) {
                City ct = new City();
                ct.CityName = data1.getString("CityName");
                ct.CountryName = data1.getString("CountryName");
                ct.District = data1.getString("District");
                ct.Population = data1.getInt("Population");
                City_report.add(ct);
            }
            return City_report;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return cities population around the world");
            return null;
        }
    }
    public void displayAllCities(ArrayList<City> cities_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("All the Cities population in the world ");
        System.out.println("============================================================");

        System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
        // Loop over all cities population in the list
        for (City cityR : cities_list)
        {
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.District, cityR.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
    public ArrayList<City> get_city_continent  (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Continent AS Continent, city.Population AS Population "
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                            + "ORDER BY Continent ASC, Population DESC";
            // Execute SQL statement
            ResultSet data2 = stmt.executeQuery(strSelect);
            // Extract population of city information for each continent
            ArrayList<City> City_report = new ArrayList<>();
            while (data2.next()) {
                City ct = new City();
                ct.CityName = data2.getString("CityName");
                ct.CountryName = data2.getString("CountryName");
                ct.Continents = data2.getString("Continent");
                ct.District = data2.getString("District");
                ct.Population = data2.getInt("Population");
                City_report.add(ct);
            }
            return City_report;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return cities population around the continent");
            return null;
        }
    }
    public void displayAllCities_continent(ArrayList<City> continent_list)
    {
        // Print header
        System.out.println("============================================================");

        // Initialize Current Continent variable
        String currentContinent = null;

        // Loop over all continents and cities population in the list
        for (City cityR : continent_list)
        {
            if(!cityR.Continents.equals(currentContinent)){
                System.out.println("\n All the Cities sorted by Population in " + cityR.Continents + " Continents");
                System.out.println("===========================================");
                currentContinent = cityR.Continents;
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "Continent", "District", "Population"));
            }
            String continent_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.Continents, cityR.District, cityR.Population);
            System.out.println(continent_info);
        }
        System.out.println("============================================================");
    }
    public ArrayList<City> get_city_region   (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Region AS Region, city.Population AS Population "
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                            + "ORDER BY Region ASC ,Population DESC";
            // Execute SQL statement
            ResultSet data3 = stmt.executeQuery(strSelect);
            // Extract population of city information for each region
            ArrayList<City> City_report = new ArrayList<>();
            while (data3.next()) {
                City ct = new City();
                ct.CityName = data3.getString("CityName");
                ct.CountryName = data3.getString("CountryName");
                ct.District = data3.getString("District");
                ct.Region = data3.getString("Region");
                ct.Population = data3.getInt("Population");
                City_report.add(ct);
            }
            return City_report;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return cities population around the region");
            return null;
        }
    }
    public void displayAllCities_Region(ArrayList<City> region_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Region variable
        String currentRegion = null;

        // Loop over all region population in the list
        for (City cityR : region_list){
            if(!cityR.Region.equals(currentRegion)){
                System.out.println("\n All the Cities sorted by Population in " + cityR.Region + " Region");
                System.out.println("===========================================");
                currentRegion = cityR.Region;
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "District", "Region", "Population"));
            }
            String region_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.District,cityR.Region, cityR.Population);
            System.out.println(region_info);
        }
        System.out.println("============================================================");
    }
}
