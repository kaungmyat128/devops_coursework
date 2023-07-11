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
            // Extract population of city information
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

        System.out.println(String.format("%-10s %-20s %-15s %-20s", "City", "Country", "District", "Population"));
        // Loop over all countries population in the list
        for (City cityR : cities_list)
        {
            String countries_info =
                    String.format("%-10s %-20s %-15s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.District, cityR.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}
