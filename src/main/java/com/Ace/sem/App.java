package com.Ace.sem;

import java.sql.*;
import java.util.List;

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
        RuralUrbanReport ruReport = new RuralUrbanReport();

        //------------Creating Object for Language Report------------
        CountryLanguagesReport languageReport = new CountryLanguagesReport();

        CapitalReport cpr = new CapitalReport();

        // Connect to database
        a.connect();

        //---------------All Country Report---------------

//        // Display All Countries Population
//        List<Country> cPop1 = cr.getCountries(a.con, 0);
//        System.out.println("All Countries Population in the World");
//        cr.displayCountries(cPop1);
//
//        // Display All Countries Population based on Each Continent
//        List<Country> cPop2 = cr.getCountriesContinent(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Continents");
//        cr.displayCountriesContinent(cPop2);
//
//        // Display All Countries Population based on Each Region
//        List<Country> cPop3 = cr.getCountriesRegion(a.con, 0);
//        System.out.println("All Countries Population in the World categorized by Regions");
//        cr.displayCountriesRegion(cPop3);
//
//        //---------------Top Country Report---------------
//
//        // Display Top 10 Countries Population
//        List<Country> cPop4 = cr.getCountries(a.con, 10);
//        System.out.println("Top 10 Countries Population in the World");
//        cr.displayCountries(cPop4);
//
//        // Display Top 10 Countries Population in Each Continent
//        List<Country> cPop5 = cr.getCountriesContinent(a.con, 10);
//        System.out.println("Top 10 Countries Population in Each Continent");
//        cr.displayCountriesContinent(cPop5);
//
//        // Display Top 10 Countries Population in Each Region
//        List<Country> cPop6 = cr.getCountriesRegion(a.con,10);
//        System.out.println("Top 10 Countries Population in Each Region");
//        cr.displayCountriesRegion(cPop6);
//
//        //---------------All Cities Report---------------
//
//        //Display All Cities Population in the world
//        List<City> tpciCity = cty.getCityPop(a.con, 0);
//        System.out.println("All Cities Population in the world");
//        cty.displayCities(tpciCity);
//
//        //Display All Population in Each Continent
//        List<City> tpciContinent = cty.getCityPopByContinent(a.con, 0);
//        System.out.println("All Cities Population in the each Continent");
//        cty.displayCityContinents(tpciContinent);
//
//        //Display All Cities Population in Each Region
//        List<City> tpciRegion = cty.getCityPopByRegion(a.con, 0);
//        System.out.println("All Cities Population in the each Region");
//        cty.displayCityRegion(tpciRegion);
//
//        //Display All Cities Population in Each Country
//        List<City> tpciCountry = cty.getCityPopByCountry(a.con, 0);
//        System.out.println("All Cities Population in the each Country");
//        cty.displayCityCountries(tpciCountry);
//
//        //Display All Cities Population in Each District
//        List<City> tpciDistrict = cty.getCityPopByDistrict(a.con, 0);
//        System.out.println("All Cities Population in the each District");
//        cty.displayCityDistrict(tpciDistrict);
//
//        //---------------Top Cities Report---------------
//
//        //Display Top 10 Cities Population in the world
//        List<City> tpciCity1 = cty.getCityPop(a.con, 10);
//        System.out.println("Top 10 Cities Population in the world");
//        cty.displayCities(tpciCity1);
//
//        //Display Top 10 Cities Population in Each Continent
//        List<City> tpciContinent1 = cty.getCityPopByContinent(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Continent");
//        cty.displayCityContinents(tpciContinent1);
//
//        //Display Top 10 Cities Population in Each Region
//        List<City> tpciRegion1 = cty.getCityPopByRegion(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Region");
//        cty.displayCityRegion(tpciRegion1);
//
//        //Display Top 10 Cities Population in Each Country
//        List<City> tpciCountry1 = cty.getCityPopByCountry(a.con, 10);
//        System.out.println("Top 10 Cities Population in the each Country");
//        cty.displayCityCountries(tpciCountry1);
//
//        //Display Top 5 Cities Population in Each District
//        List<City> tpciDistrict1 = cty.getCityPopByDistrict(a.con, 5);
//        System.out.println("Top 5 Cities Population in the each District");
//        cty.displayCityDistrict(tpciDistrict1);
//
        //Display All Capital Population in the world
        List<City> capitalR1 = cpr.getCapitalPopByWorld(a.con, 0);
        System.out.println("All Capital Population in the World");
        cpr.displayCapital(capitalR1);

        //Display top 10 Capital By Population in the world
        List<City> capitalR2 = cpr.getCapitalPopByWorld(a.con, 10);
        System.out.println("Top 10 Capital Population in the World");
        cpr.displayCapital(capitalR2);

        //Display All Capital Population for each Continent
        List<City> capitalR3 = cpr.getCapitalPopByContinent(a.con, 0);
        System.out.println("All Capital Population in each Continent");
        cpr.displayCapitalContinent(capitalR3);

        //Display top 10 Capital By Population in each continent
        List<City> capitalR4 = cpr.getCapitalPopByContinent(a.con, 10);
        System.out.println("Top 10 Capital Population in each Continent");
        cpr.displayCapitalContinent(capitalR4);

        //Display All Capital Population for each region
       List<City> capitalR5 = cpr.getCapitalPopByRegion(a.con, 0);
        System.out.println("All Capital Population in each Region");
        cpr.displayCapitalContinent(capitalR5);

        //Display top 10 Capital By Population each Region
        List<City> capitalR6 = cpr.getCapitalPopByRegion(a.con, 10);
        System.out.println("Top 10 Capital Population in each Region");
        cpr.displayCapitalRegion(capitalR6);
//
//        //Summary reports
//        List<Country> popSumWorld =  sr.sumWorldPop(a.con);
//        System.out.println("==========Population of the world==========");
//        System.out.println(String.format("%-20s| %-20s", "Location", "Population"));
//        sr.displaySumWorldPop(popSumWorld);
//
//        List<Country> popSumCont =  sr.sumContPop(a.con, 1);
//        System.out.println("==========Population of most populated continent==========");
//        System.out.println(String.format("%-30s| %-30s", "Continent", "Population"));
//        sr.displaySumContPop(popSumCont);
//
//        List<Country> popSumReg =  sr.sumRegPop(a.con, 1);
//        System.out.println("==========Population of most populated region==========");
//        System.out.println(String.format("%-30s| %-30s", "Region", "Population"));
//        sr.displaySumRegPop(popSumReg);
//
//        List<Country> popSumCoun = sr.sumCouPop(a.con,1 );
//        System.out.println("==========Population of most populated country==========");
//        System.out.println(String.format("%-30s| %-30s", "Country", "Population"));
//        sr.displaySumCouPop(popSumCoun);
//
//        List<City> popDistReg =  sr.sumDistPop(a.con, 1);
//        System.out.println("==========Population of most populated district==========");
//        System.out.println(String.format("%-30s| %-30s", "District", "Population"));
//        sr.displaySumDistPop(popDistReg);
//
//        List<City> popCityReg =  sr.sumCityPop(a.con, 1);
//        System.out.println("==========Population of most populated city==========");
//        System.out.println(String.format("%-30s| %-30s", "City", "Population"));
//        sr.displaySumCityPop(popCityReg);
//
//        //Display Population report of people living in cities and not living in cities in each continent
//        List<City> report1 = ruReport.getContinentPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each continent");
//        ruReport.displayContinentPopulation(report1);
//
//        //Display Population report of people living in cities and not living in cities in each region
//        List<City> report2 = ruReport.getRegionPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each region");
//        ruReport.displayRegionPopulation(report2);
//
//        //Display Population report of people living in cities and not living in cities in each country
//        List<City> report3 = ruReport.getCountryPopulation(a.con);
//        System.out.println("Population report of people living in cities and not living in cities in each country");
//        ruReport.displayCountryPopulation(report3);
//
//        // Display Language Population
//        List<Language> report4 = languageReport.getLanguagesReport(a.con);
//        System.out.println("Language Report : The number of people who speak Chinese, English, Hindi, Spanish and Arabic.");
//        languageReport.displayLanguagesPopulation(report4);

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

                con = DriverManager.getConnection("jdbc:mysql://localhost:33061/world", "root", "example");

//                if (i%2 == 0) {
//                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world", "root", "example");
//                } else{
//                    con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world", "root", "example");
//                }
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