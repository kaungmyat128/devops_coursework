package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopPopulatedCities {

    public ArrayList<City> getCityWorldPop(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT (city.Name) AS CityName,country.Name AS CountryName,city.District,city.Population "
                            + "FROM city INNER JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY Population DESC LIMIT 20";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> Worldpop = new ArrayList<City>();
            while (rset.next()) {
                City world = new City();
                world.CityName = rset.getString("CityName");
                world.CountryName = rset.getString("CountryName");
                world.District = rset.getString("District");
                world.Population = rset.getInt("Population");
                Worldpop.add(world);
            }
            return Worldpop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public void displayTopCities(ArrayList<City> cities_list)
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
