package com.Ace.sem;
//importing necessary java sql and util library
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class City_report {

    //Method to extract the data for cities in the world
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
                ct.setCityName(data1.getString("CityName"));
                ct.setCountryName(data1.getString("CountryName"));
                ct.setDistrict(data1.getString("District"));
                ct.setPopulation(data1.getInt("Population"));
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

    //Method to extract the data for cities in Each Continent
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
                ct.setCityName(data2.getString("CityName"));
                ct.setCountryName(data2.getString("CountryName"));
                ct.setContinents(data2.getString("Continent"));
                ct.setDistrict(data2.getString("District"));
                ct.setPopulation(data2.getInt("Population"));
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

    //Method to extract the data for cities in Each Region
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
                ct.setCityName(data3.getString("CityName"));
                ct.setCountryName(data3.getString("CountryName"));
                ct.setDistrict(data3.getString("District"));
                ct.setRegion(data3.getString("Region"));
                ct.setPopulation(data3.getInt("Population"));
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
    //Method to extract the data for cities in Each Country


    //Method to extract the data for cities in Each District

}
