package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class RuralUrbanReport {

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
            ResultSet query1 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RUContinentPopulation = new ArrayList<City>();
            return storeIntoArraylist(RUContinentPopulation, query1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each continent");
            return null;
        }
    }

    // The population of people, people living in cities, and people not living in cities in each region.
    public ArrayList<City> getRegionPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Region AS Region, SUM(country.Population) AS Total_Population, "
                    + "SUM(city.cities_population) AS Cities_Population, "
                    + "SUM(country.Population - city.cities_population) AS Not_Cities_Population "
                    + "FROM country "
                    + "JOIN ( SELECT city.countryCode, SUM(city.Population) AS cities_population "
                    + "FROM city GROUP BY city.CountryCode ) AS city "
                    + "ON city.CountryCode = country.Code "
                    + "GROUP BY country.region "
                    + "ORDER BY country.Region";

            // Execute SQL statement
            ResultSet query2 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RURegionPopulation = new ArrayList<City>();
            return storeIntoArraylist(RURegionPopulation, query2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each region");
            return null;
        }
    }

    // The population of people, people living in cities, and people not living in cities in each country.
    public ArrayList<City> getCountryPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT country.Name AS Country, SUM(country.Population) AS total_population , "
                    + "SUM(city.Population) AS Cities_Population, "
                    + "SUM(country.population) - SUM(city.Population) AS Not_Cities_Population "
                    + "FROM country "
                    + "JOIN city ON country.Code = city.CountryCode "
                    + "GROUP BY country.Name ORDER BY country.Name";

            // Execute SQL statement
            ResultSet query3 = stmt.executeQuery(strSelect);
            // Create array list 'RUContinentPopulation' and add query result into array list
            ArrayList<City> RUCountryPopulation = new ArrayList<City>();
            return storeIntoArraylist(RUCountryPopulation, query3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities in each country");
            return null;
        }
    }


    public ArrayList<City> storeIntoArraylist(ArrayList<City> al, ResultSet qry) {
        try{
            // Extract population of countries information and store into array list
            while (qry.next()) {
                City RUPop = new City();
                RUPop.setCountryName(qry.getString("Country"));
                RUPop.setTotalPopulation(qry.getLong("Total_Population"));
                RUPop.setTotalCitiesPopulation(qry.getLong("Cities_Population"));
                RUPop.setTotalNotCitiesPopulation(qry.getLong("Not_Cities_Population"));
                al.add(RUPop);
            }
            return al;
        }// Exception handling when any errors occur. Print out error type and error message and return null.
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People living in cities and not living in cities ");
            return null;
        }
    }


    public void displayContinentPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Continent", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getContinents(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }

    public void displayRegionPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Region", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getRegion(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }


    public void displayCountryPopulation(ArrayList<City> arrList)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println(String.format("%-40s | %-30s | %-35s | %-20s", "Country", "Total Population",
                "People Living in Cities", "People Not Living in Cities"));
        // Loop over all cities population in the list
        for (City c : arrList)
        {
            double people_living_in_cities = (double) c.getTotalCitiesPopulation() / c.getTotalPopulation() * 100;
            String s1 = String.format("%05.2f",people_living_in_cities) + "%";
            double people_not_living_in_cities = (double) c.getTotalNotCitiesPopulation() / c.getTotalPopulation() * 100;
            String s2 = String.format("%05.2f",people_not_living_in_cities) + "%";
            String continent_population =
                    String.format("%-40s | %-30s | %-15s ( %-5s ) %-8s | %-20s ( %-5s )",
                            c.getCountryName(), humanReadableFormat(c.getTotalPopulation()),
                            humanReadableFormat(c.getTotalCitiesPopulation()), s1, "",
                            humanReadableFormat(c.getTotalNotCitiesPopulation()),s2);
            System.out.println(continent_population);
        }
        System.out.println("============================================================");
    }


    public String humanReadableFormat(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }
}
