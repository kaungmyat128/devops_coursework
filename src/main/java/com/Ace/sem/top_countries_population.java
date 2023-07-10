package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class top_countries_population extends Country {
     public ArrayList<Country> get_top_countries (Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 25";
            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            // Extract population of countries information
            ArrayList<Country> top_countries_population = new ArrayList<Country>();
            while (query1.next()) {
                Country cp = new Country();
                cp.Code = query1.getString("country.Code");
                cp.Name = query1.getString("country.Name");
                cp.Continent = query1.getString("country.Continent");
                cp.Region = query1.getString("country.Region");
                cp.Population = query1.getInt("country.Population");
                cp.Capital = query1.getString("city.Name");
                top_countries_population.add(cp);
            }
            return top_countries_population;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to return country population");
            return null;
        }
    }

}
