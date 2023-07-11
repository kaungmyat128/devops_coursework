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
                    "SELECT city.Name,coutnry.Country,District,Population "
                            + "FROM city "
                            + "ORDER BY Population DESC LIMIT 5";
            // Execute SQL statement
            ResultSet data1 = stmt.executeQuery(strSelect);
            // Extract population of countries information
            ArrayList<City> City_report = new ArrayList<City>();
            while (data1.next()) {
                City ct = new City();
                ct.Name = data1.getString("city.Name");
                ct.Country = data1.getString("country.name");
                ct.District = data1.getString("city.District");
                ct.Population = data1.getInt("city.Population");
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
}
