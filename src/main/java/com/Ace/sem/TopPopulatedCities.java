package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopPopulatedCities {

    public ArrayList<City>
    getWorldPopByCity(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
            "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District, country.Continent, city.Population"
                    + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery"
                    + "WHERE row_num <= 20 ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> worldPop = new ArrayList<City>();
            while (rset.next()) {
                City world = new City();
                world.CityName = rset.getString("CityName");
                world.CountryName = rset.getString("CountryName");
                world.District = rset.getString("District");
                world.Population = rset.getInt("Population");
                worldPop.add(world);
            }
            return worldPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public ArrayList<City>
    getContinentPopByCity(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District, country.Continent, city.Population"
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery"
                            + "WHERE row_num <= 20 ORDER BY Continent ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> continentPop = new ArrayList<City>();
            while (rset.next()) {
                City continent = new City();
                continent.CityName = rset.getString("CityName");
                continent.CountryName = rset.getString("CountryName");
                continent.District = rset.getString("District");
                continent.Population = rset.getInt("Population");
                continentPop.add(continent);
            }
            return continentPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public ArrayList<City>
    getRegionPopByCity(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District, country.Region AS Region, city.Population"
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery"
                            + "WHERE row_num <= 20 ORDER BY Region ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> regionPop = new ArrayList<City>();
            while (rset.next()) {
                City region = new City();
                region.CityName = rset.getString("CityName");
                region.CountryName = rset.getString("CountryName");
                region.District = rset.getString("District");
                region.Population = rset.getInt("Population");
                regionPop.add(region);
            }
            return regionPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public ArrayList<City>
    getCountryPopByCity(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population"
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery"
                            + "WHERE row_num <= 20 ORDER BY CountryName ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> countryPop = new ArrayList<City>();
            while (rset.next()) {
                City country = new City();
                country.CityName = rset.getString("CityName");
                country.CountryName = rset.getString("CountryName");
                country.District = rset.getString("District");
                country.Population = rset.getInt("Population");
                countryPop.add(country);
            }
            return countryPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public ArrayList<City>
    getDistrictPopByCity(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population"
                            + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery"
                            + "WHERE row_num <= 20 ORDER BY District ASC, Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> districtPop = new ArrayList<City>();
            while (rset.next()) {
                City district = new City();
                district.CityName = rset.getString("CityName");
                district.CountryName = rset.getString("CountryName");
                district.District = rset.getString("District");
                district.Population = rset.getInt("Population");
                districtPop.add(district);
            }
            return districtPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public void displayTPCICity(ArrayList<City> cities_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 cities with most population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-20s", "City", "Country", "District", "Population"));
        // Loop over all countries population in the list
        for (City cty : cities_list)
        {
            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s",
                            cty.CityName, cty.CountryName, cty.District, cty.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
    public void DisplayTPCIContinent(ArrayList<City> continent_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 cities with most population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-15s %-20s", "City", "Country", "Continent" "District", "Population"));
        // Loop over all countries population in the list
        for (City cty : continent_list)
        {
            String continent_info =
                    String.format("%-10s %-20s %-15s %-15s %-20s",
                            cty.CityName, cty.CountryName, cty.Continents, cty.District, cty.Population);
            System.out.println(continent_info);
        }
        System.out.println("============================================================");
    }
    public void DisplayTPCIRegion(ArrayList<City> region_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 cities with most population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-15s %-20s", "City", "Country", "Region", "District", "Population"));
        // Loop over all countries population in the list
        for (City cty : region_list)
        {
            String region_info =
                    String.format("%-10s %-20s %-15s %-15s %-20s",
                            cty.CityName, cty.CountryName, cty.District,cty.Region, cty.Population);
            System.out.println(region_info);
        }
        System.out.println("============================================================");
    }
    public void displayTPCICountry(ArrayList<City> cities_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 cities with most population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-20s", "City", "Country", "District", "Population"));
        // Loop over all countries population in the list
        for (City cty : cities_list)
        {
            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s",
                            cty.CityName, cty.CountryName, cty.District, cty.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
    public void displayTPCIDistrict(ArrayList<City> cities_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("Top 20 cities with most population in the world ");

        System.out.println(String.format("%-10s %-20s %-15s %-20s", "City", "Country", "District", "Population"));
        // Loop over all countries population in the list
        for (City cty : cities_list)
        {
            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s",
                            cty.CityName, cty.CountryName, cty.District, cty.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}
