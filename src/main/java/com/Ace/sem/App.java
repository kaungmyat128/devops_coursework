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
        // Create new object with Country_report java Class
        CountryReport cr = new CountryReport();

        //------------Creating Object for Cities Report------------
        // Create new object for top populated cities Class Java
        CityReport cty = new CityReport();

        //------------Creating Object for Summary Report------------
        // Create new object for SummaryReport Class Java
        SummaryReport sr = new SummaryReport();

        // Connect to database
        a.connect();

        //---------------All Country Report---------------

//        // Display All Countries Population
//        ArrayList<Country> CPop1 = cr.getCountries(a.con, 0);
//        System.out.println("All Countries Population in the World");
//        cr.displayCountries(CPop1);
//
//        // Display All Countries Population based on Each Continent
//        ArrayList<Country> CPop2 = cr.getCountriesContinent(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Continents");
//        cr.displayCountriesContinent(CPop2);
//
//        // Display All Countries Population based on Each Region
//        ArrayList<Country> CPop3 = cr.getCountriesRegion(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Regions");
//        cr.displayCountriesRegion(CPop3);
//
//        //---------------Top Country Report---------------
//
//        // Display Top 10 Countries Population
//        ArrayList<Country> CPop4 = cr.getCountries(a.con, 10);
//        System.out.println("Top 10 Countries Population in the World");
//        cr.displayCountries(CPop4);
//
//        // Display Top 10 Countries Population in Each Continent
//        ArrayList<Country> CPop5 = cr.getCountriesContinent(a.con, 10);
//        System.out.println("Top 10 Countries Population in Each Continent");
//        cr.displayCountriesContinent(CPop5);
//
//        // Display Top 10 Countries Population in Each Region
//        ArrayList<Country> CPop6 = cr.getCountriesRegion(a.con,10);
//        System.out.println("Top 10 Countries Population in Each Region");
//        cr.displayCountriesRegion(CPop6);
//
//        //---------------All Cities Report---------------
//
//        //Display All Cities Population in the world
//        ArrayList<City> TPCICity = cty.getCityPop(a.con, 0);
//        System.out.println("All Cities Population in the world");
//        cty.displayCities(TPCICity);
//
//        //Display All Population in Each Continent
//        ArrayList<City> TPCIContinent = cty.getCityPopByContinent(a.con, 0);
//        System.out.println("All Cities Population in the each Continent");
//        cty.displayCityContinents(TPCIContinent);
//
//        //Display All Cities Population in Each Region
//        ArrayList<City> TPCIRegion = cty.getCityPopByRegion(a.con, 0);
//        System.out.println("All Cities Population in the each Region");
//        cty.displayCityRegion(TPCIRegion);
//
//        //Display All Cities Population in Each Country
//        ArrayList<City> TPCICountry = cty.getCityPopByCountry(a.con, 0);
//        System.out.println("All Cities Population in the each Country");
//        cty.displayCityCountries(TPCICountry);
//
//        //Display All Cities Population in Each District
//        ArrayList<City> TPCIDistrict = cty.getCityPopByDistrict(a.con, 0);
//        System.out.println("All Cities Population in the each District");
//        cty.displayCityDistrict(TPCIDistrict);
//
//        //---------------Top Cities Report---------------
//
//        //Display Top 10 Cities Population in the world
//        ArrayList<City> TPCICity1 = cty.getCityPop(a.con, 10);
//        System.out.println("Top 10 Cities Population in the world");
//        cty.displayCities(TPCICity1);
//
//        //Display Top 10 Cities Population in Each Continent
//        ArrayList<City> TPCIContinent1 = cty.getCityPopByContinent(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Continent");
//        cty.displayCityContinents(TPCIContinent1);
//
//        //Display Top 10 Cities Population in Each Region
//        ArrayList<City> TPCIRegion1 = cty.getCityPopByRegion(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Region");
//        cty.displayCityRegion(TPCIRegion1);
//
//        //Display Top 10 Cities Population in Each Country
//        ArrayList<City> TPCICountry1 = cty.getCityPopByCountry(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Country");
//        cty.displayCityCountries(TPCICountry1);
//
//        //Display Top 5 Cities Population in Each District
//        ArrayList<City> TPCIDistrict1 = cty.getCityPopByDistrict(a.con, 5);
//        System.out.println("Top 5 Cities Population in the each District");
//        cty.displayCityDistrict(TPCIDistrict1);

        ArrayList<Country> popSumWorld =  sr.sumWorldPop(a.con);
        System.out.println("==========Population of the world==========");
        sr.displaySumWorldPop(popSumWorld);

        ArrayList<Country> popSumCont =  sr.sumContPop(a.con);
        System.out.println("==========Population of the continents==========");
        sr.displaySumContPop(popSumCont);

        ArrayList<Country> popSumReg =  sr.sumRegPop(a.con);
        System.out.println("==========Population of the continents==========");
        sr.displaySumRegPop(popSumReg);

        //Disconnect from database
        a.disconnect();
    }


    /*
     Connect to the MySQL database. Load mysql driver and connect database up to 100 tries
     until database connection is connected.
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

    /*
     Disconnect from the MySQL database.
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