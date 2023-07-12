package com.Ace.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Contains Connect() and Disconnect() Methods for database connection
 * Initialize New App Object, Country Object, Country Report Object, top_countries_population Object
 * Initialize City Object, City Report Object, Top Populated Cities Object
 */
public class App {
    // Connection to MySQL database.
    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application Object
        App a = new App();

        //------------Creating Object for Country Report------------

        // Create new Country Object
        Country c = new Country();
        // Create new object with Country_report java Class
        CountryReport cr = new CountryReport();
        // Create new object for top countries population Class Java
        TopPopulatedCountries c2 = new TopPopulatedCountries();

        //------------Creating Object for Cities Report------------

        City ct = new City();
        // Create new object for City_report java Class
        City_report cityR = new City_report();
        // Create new object for top populated cities Class Java
        TopPopulatedCities cty = new TopPopulatedCities();

        // Connect to database
        a.connect();

        //---------------All Country Report---------------

        // Display All Countries Population
        ArrayList<Country> CPop1 = cr.getCountryPop(a.con);
        System.out.println("All Countries Population in the World");
        c.displayCountries(CPop1);

        // Display country population based on continent
        ArrayList<Country> CPop2 = cr.getCounContPop(a.con);
        System.out.println("All Countries Population in the World categorized by Continents");
        c.displayCountries_Continent(CPop2);

        // Display country population based on region
        ArrayList<Country> CPop3 = cr.getCounRegPop(a.con);
        System.out.println("All Countries Population in the World categorized by Regions");
        c.displayCountries_Region(CPop3);

        //---------------Top Country Report---------------

        // Display Top 20 Countries Population
        ArrayList<Country> CPop4 = c2.get_top_countries(a.con);
        System.out.println("Top 20 Countries Population in the World");
        c.displayCountries(CPop4);

        // Display Top 20 Countries Population in Each Continent
        ArrayList<Country> CPop5 = c2.get_top_countries_continents(a.con);
        System.out.println("Top 20 Countries Population in Each Continent");
        c.displayCountries_Continent(CPop5);

        // Display Top 10 Countries Population in Each Region
        ArrayList<Country> CPop6 = c2.get_top_countries_regions(a.con);
        System.out.println("Top 20 Countries Population in Each Region");
        c.displayCountries_Region(CPop6);

        //---------------All Cities Report---------------

        //Display all the cities population in the world
        ArrayList<City> CityW = cityR.get_city_world(a.con);
        System.out.println("All the Cities Population in the world");
        cityR.displayCities(CityW);

        //Display all the cities population in each continent
        ArrayList<City> CityC = cityR.get_city_continent(a.con);
        System.out.println("All the Cities Population in Each Continent");
        cityR.displayCityContinents(CityC);

        //Display All the cities population in each region
        ArrayList<City> CityReg = cityR.get_city_region(a.con);
        System.out.println("All the Cities Population in Each Region");
        cityR.displayCityRegion(CityReg);

        //---------------Top Cities Report---------------

        //Display Top 20 Cities Population in the world
        ArrayList<City> TPCICity = cty.getWorldPopByCity(a.con);
        System.out.println("Top 20 Cities Population in the world");
        ct.displayCities(TPCICity);

        //Display Top 20 Cities Population in Each Continent
        ArrayList<City> TPCIContinent = cty.getContinentPopByCity(a.con);
        System.out.println("Top 20 Cities Population in the each Continent");
        ct.displayCityContinents(TPCIContinent);

        //Display Top 20 Cities Population in Each Region
        ArrayList<City> TPCIRegion = cty.getRegionPopByCity(a.con);
        System.out.println("Top 20 Cities Population in the each Region");
        ct.displayCityRegion(TPCIRegion);

        //Display Top 20 Cities Population in Each Country
        ArrayList<City> TPCICountry = cty.getCountryPopByCity(a.con);
        System.out.println("Top 20 Cities Population in the each Country");
        ct.displayCityCountries(TPCICountry);

        //Display Top 20 Cities Population in Each District
        ArrayList<City> TPCIDistrict = cty.getDistrictPopByCity(a.con);
        System.out.println("Top 20 Cities Population in the each District");
        ct.displayCityDistrict(TPCIDistrict);

        // Disconnect from database
        a.disconnect();
    }



    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}