package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class RuralUrbanReport {

    // Create new object of CountryReport to use human_readable_format() method from country.java
    CountryReport formatPopulation = new CountryReport();
    // The population of people, people living in cities, and people not living in cities in each continent.
    public ArrayList<City> getContinentPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Continent as Continent_Name, "
                                + "SUM(country.Population) AS Total_Population, "
                                + "SUM(city.Total_Cities_Population) AS Cities_Population, "
                                + "SUM(country.Population - city.Total_Cities_Population) AS Not_Cities_Population "
                                + "FROM country "
                                + "JOIN ( SELECT city.CountryCode , SUM(city.Population) AS Total_Cities_Population "
                                + "FROM city GROUP BY city.CountryCode ) AS city ON country.code = city.CountryCode "
                                + "GROUP BY country.Continent ORDER BY country.Continent";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RUContinentPopulation = new ArrayList<City>();
            while (rset.next()) {
                City world = new City();
                world.setContinents(rset.getString("Continent_Name"));
                world.setTotalPopulation(rset.getInt("Total_Population"));
                world.setTotalCitiesPopulation(rset.getInt("Cities_Population"));
                world.setTotalNotCitiesPopulation(rset.getInt("Not_Cities_Population"));
                RUContinentPopulation.add(world);
            }
            return RUContinentPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each continent");
            return null;
        }
    }

    public void displayContinentPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s |%-30s |%-30s |%-20s", "City", "Country", "District", "Population"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            String continent_population =
                    String.format("%-40s |%-30s |%-30s |%-20s",
                            c.getContinents(), c.getTotalPopulation(), c.getTotalCitiesPopulation(),
                            c.getTotalNotCitiesPopulation());
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }

}
