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
    public Connection con = null;

    public static void main(String[] args) {
        // Create new Application Object
        App a = new App();

        //------------Creating Object for Country Report------------
        // Create new Country Object
        Country c = new Country();
        // Create new object with Country_report java Class
        CountryReport cr = new CountryReport();

        //------------Creating Object for Cities Report------------
        // Create new object for top populated cities Class Java
        CityReport cty = new CityReport();

        //------------Creating Object for Summary Report------------
        // Create new object for SummaryReport Class Java
        SummaryReport sr = new SummaryReport();

        //------------Creating Object for People Living in Cities & Not Living in Cities Report------------
        // Create new object for top populated cities Class Java
        RuralUrbanReport RUReport = new RuralUrbanReport();

        //------------Creating Object for Language Report------------
        countryLanguagesReport LanguageReport = new countryLanguagesReport();

        CapitalReport cpr = new CapitalReport();

        // Connect to database
        a.connect();

        //---------------All Country Report---------------

        // Display All Countries Population
//        ArrayList<Country> CPop1 = cr.get_countries(a.con, 0);
//        System.out.println("All Countries Population in the World");
//        cr.displayCountries(CPop1);

//        // Display All Countries Population based on Each Continent
//        ArrayList<Country> CPop2 = cr.get_countries_continent(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Continents");
//        cr.displayCountries_Continent(CPop2);
//
//        // Display All Countries Population based on Each Region
//        ArrayList<Country> CPop3 = cr.get_countries_region(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Regions");
//        cr.displayCountries_Region(CPop3);
//
//        //---------------Top Country Report---------------
//
//        // Display Top 10 Countries Population
//        ArrayList<Country> CPop4 = cr.get_countries(a.con, 10);
//        System.out.println("Top 10 Countries Population in the World");
//        cr.displayCountries(CPop4);
//
//        // Display Top 10 Countries Population in Each Continent
//        ArrayList<Country> CPop5 = cr.get_countries_continent(a.con, 10);
//        System.out.println("Top 10 Countries Population in Each Continent");
//        cr.displayCountries_Continent(CPop5);
//
//        // Display Top 10 Countries Population in Each Region
//        ArrayList<Country> CPop6 = cr.get_countries_region(a.con,10);
//        System.out.println("Top 10 Countries Population in Each Region");
//        cr.displayCountries_Region(CPop6);
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

        //Display All Capital Population in the world
//        ArrayList<City> CapitalR1 = cpr.getCapitalPopByWorld(a.con, 0);
//        System.out.println("All Capital Population in the World");
//        cpr.displayCapital(CapitalR1);
//
//        //Display top 10 Capital By Population in the world
//        ArrayList<City> CapitalR2 = cpr.getCapitalPopByWorld(a.con, 10);
//        System.out.println("Top 10 Capital Population in the World");
//        cpr.displayCapital(CapitalR2);
//
//        //Display All Capital Population for each Continent
//        ArrayList<City> CapitalR3 = cpr.getCapitalPopByContinent(a.con, 0);
//        System.out.println("All Capital Population in each Continent");
//        cpr.displayCapitalContinent(CapitalR3);
//
//        //Display top 10 Capital By Population in each continent
//        ArrayList<City> CapitalR4 = cpr.getCapitalPopByContinent(a.con, 10);
//        System.out.println("Top 10 Capital Population in each Continent");
//        cpr.displayCapitalContinent(CapitalR4);
//
//        //Display All Capital Population for each region
//        ArrayList<City> CapitalR5 = cpr.getCapitalPopByRegion(a.con, 0);
//        System.out.println("All Capital Population in each Region");
//        cpr.displayCapitalContinent(CapitalR5);
//
//        //Display top 10 Capital By Population each Region
//        ArrayList<City> CapitalR6 = cpr.getCapitalPopByRegion(a.con, 10);
//        System.out.println("Top 10 Capital Population in each Region");
//        cpr.displayCapitalRegion(CapitalR6);

        //Summary reports
        ArrayList<Country> popSumWorld =  sr.sumWorldPop(a.con);
        System.out.println("==========Population of the world==========");
        System.out.println(String.format("%-20s| %-20s", "Location", "Population"));
        sr.displaySumWorldPop(popSumWorld);

        ArrayList<Country> popSumCont =  sr.sumContPop(a.con, 1);
        System.out.println("==========Population of most populated continent==========");
        System.out.println(String.format("%-30s| %-30s", "Location", "Population"));
        sr.displaySumContPop(popSumCont);

        ArrayList<Country> popSumReg =  sr.sumRegPop(a.con, 1);
        System.out.println("==========Population of most populated region==========");
        System.out.println(String.format("%-30s| %-30s", "Location", "Population"));
        sr.displaySumRegPop(popSumReg);

        ArrayList<Country> popSumCoun = sr.sumCouPop(a.con,1 );
        System.out.println("==========Population of most populated country==========");
        System.out.println(String.format("%-30s| %-30s", "Location", "Population"));
        sr.displaySumCouPop(popSumCoun);

        ArrayList<City> popDistReg =  sr.sumDistPop(a.con, 1);
        System.out.println("==========Population of most populated district==========");
        System.out.println(String.format("%-30s| %-30s", "Location", "Population"));
        sr.displaySumDistPop(popDistReg);

        ArrayList<City> popCityReg =  sr.sumCityPop(a.con, 1);
        System.out.println("==========Population of most populated city==========");
        System.out.println(String.format("%-30s| %-30s", "Location", "Population"));
        sr.displaySumCityPop(popCityReg);
//
//        //Display Population report of people living in cities and not living in cities in each continent
//        ArrayList<City> report1 = RUReport.getContinentPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each continent");
//        RUReport.displayContinentPopulation(report1);
//
//        //Display Population report of people living in cities and not living in cities in each region
//        ArrayList<City> report2 = RUReport.getRegionPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each region");
//        RUReport.displayRegionPopulation(report2);
//
//        //Display Population report of people living in cities and not living in cities in each country
//        ArrayList<City> report3 = RUReport.getCountryPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each country");
//        RUReport.displayCountryPopulation(report3);
//
//        // Display Language Population
//        ArrayList<Language> report4 = LanguageReport.getLanguagesReport(a.con);
//        System.out.println("Language Report : The number of people who speak Chinese, English, Hindi, Spanish and Arabic.");
//        LanguageReport.displayLanguagesPopulation(report4);

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
                // con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                // Connect to database in localhost
                con = DriverManager.getConnection("jdbc:mysql://localhost:33061/world", "root", "example");
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