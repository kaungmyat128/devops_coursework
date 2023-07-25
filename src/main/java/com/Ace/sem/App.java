package com.Ace.sem;

import java.sql.*;
import java.util.List;

/**
 * Contains Connect() and Disconnect() Methods for database connection
 * Initialize New App Object, Country Object,
 * Country Report Object, top_countries_population Object
 * Initialize City Object, City Report Object, Top Populated Cities Object
 */
public class App {
    // Connection to MySQL database.
    public Connection con = null;

    public static void main(String[] args) {
        // create new Application Object
        final App app = new App();

        //------------creating Object for Country Report------------
        // create new object with Country_report java Class
        final CountryReport cour = new CountryReport();

        //------------creating Object for Cities Report------------
        // create new object for top populated cities Class Java
        final CityReport cty = new CityReport();

        //------------creating Object for Summary Report------------
        // create new object for SummaryReport Class Java
        final SummaryReport sumR = new SummaryReport();

        //------------creating Object for People
        // Living in Cities & Not Living in Cities Report------------
        // create new object for top populated cities Class Java
        final RuralUrbanReport ruReport = new RuralUrbanReport();

        //------------coureating Object for Language Report------------
        final CountryLanguagesReport languageReport = new CountryLanguagesReport();

        final CapitalReport cpr = new CapitalReport();

        // Connect to database
        app.connect();

        //---------------All Country Report---------------
//        //Display All Countries Population
//        final List<Country> cPop1 = cour.getCountries(app.con, 0);
//        System.out.println("All Countries Population in the World");
//        cour.displayCountries(cPop1);
//
//        // Display All Countries Population based on Each Continent
//        final List<Country> cPop2 = cour.getCountriesContinent(app.con, 0);
//        System.out.println("All Countries Population in the World categorized by Continents");
//        cour.displayCountriesContinent(cPop2);
//
//        // Display All Countries Population based on Each Region
//        final List<Country> cPop3 = cour.getCountriesRegion(app.con, 0);
//        System.out.println("All Countries Population in the World categorized by Regions");
//        cour.displayCountriesRegion(cPop3);

        //---------------Top Country Report---------------

        // Display Top 10 Countries Population
        final List<Country> cPop4 = cour.getCountries(app.con, 10);
        System.out.println("Top 10 Countries Population in the World");
        cour.displayCountries(cPop4);

        // Display Top 10 Countries Population in Each Continent
        final List<Country> cPop5 = cour.getCountriesContinent(app.con, 10);
        System.out.println("Top 10 Countries Population in Each Continent");
        cour.displayCountriesContinent(cPop5);

        // Display Top 10 Countries Population in Each Region
        final List<Country> cPop6 = cour.getCountriesRegion(app.con,10);
        System.out.println("Top 10 Countries Population in Each Region");
        cour.displayCountriesRegion(cPop6);

        //---------------All Cities Report---------------

        //Display All Cities Population in the world
//        final List<City> tpciCity = cty.getCityPop(app.con, 0);
//        System.out.println("All Cities Population in the world");
//        cty.displayCities(tpciCity);
//
//        //Display All Population in Each Continent
//        final List<City> tpciContinent = cty.getCityPopByContinent(app.con, 0);
//        System.out.println("All Cities Population in the each Continent");
//        cty.displayCityContinents(tpciContinent);
//
//        //Display All Cities Population in Each Region
//        final List<City> tpciRegion = cty.getCityPopByRegion(app.con, 0);
//        System.out.println("All Cities Population in the each Region");
//        cty.displayCityRegion(tpciRegion);
//
//        //Display All Cities Population in Each Country
//        final List<City> tpciCountry = cty.getCityPopByCountry(app.con, 0);
//        System.out.println("All Cities Population in the each Country");
//        cty.displayCityCountries(tpciCountry);
//
//        //Display All Cities Population in Each District
//        final List<City> tpciDistrict = cty.getCityPopByDistrict(app.con, 0);
//        System.out.println("All Cities Population in the each District");
//        cty.displayCityDistrict(tpciDistrict);

        //---------------Top Cities Report---------------

        //Display Top 10 Cities Population in the world
        final List<City> tpciCity1 = cty.getCityPop(app.con, 10);
        System.out.println("Top 10 Cities Population in the world");
        cty.displayCities(tpciCity1);

        //Display Top 10 Cities Population in Each Continent
        final List<City> tpciContinent1 = cty.getCityPopByContinent(app.con, 10);
        System.out.println("Top 10 Cities Population in the each Continent");
        cty.displayCityContinents(tpciContinent1);

        //Display Top 10 Cities Population in Each Region
        final List<City> tpciRegion1 = cty.getCityPopByRegion(app.con, 10);
        System.out.println("Top 10 Cities Population in the each Region");
        cty.displayCityRegion(tpciRegion1);

        //Display Top 10 Cities Population in Each Country
        final List<City> tpciCountry1 = cty.getCityPopByCountry(app.con, 10);
        System.out.println("Top 10 Cities Population in the each Country");
        cty.displayCityCountries(tpciCountry1);

        //Display Top 5 Cities Population in Each District
        final List<City> tpciDistrict1 = cty.getCityPopByDistrict(app.con, 5);
        System.out.println("Top 5 Cities Population in the each District");
        cty.displayCityDistrict(tpciDistrict1);

//        //Display All Capital Population in the world
//        final List<City> capitalR1 = cpr.getCapitalPopByWorld(app.con, 0);
//        System.out.println("All Capital Population in the World");
//        cpr.displayCapital(capitalR1);

       //Display top 10 Capital By Population in the world
        final List<City> capitalR2 = cpr.getCapitalPopByWorld(app.con, 10);
        System.out.println("Top 10 Capital Population in the World");
        cpr.displayCapital(capitalR2);

//        //Display All Capital Population for each Continent
//        final List<City> capitalR3 = cpr.getCapitalPopByContinent(app.con, 0);
//        System.out.println("All Capital Population in each Continent");
//        cpr.displayCapitalContinent(capitalR3);

        //Display top 10 Capital By Population in each continent
        final List<City> capitalR4 = cpr.getCapitalPopByContinent(app.con, 10);
        System.out.println("Top 10 Capital Population in each Continent");
        cpr.displayCapitalContinent(capitalR4);

//        //Display All Capital Population for each region
//        final List<City> capitalR5 = cpr.getCapitalPopByRegion(app.con, 0);
//        System.out.println("All Capital Population in each Region");
//        cpr.displayCapitalContinent(capitalR5);

        //Display top 10 Capital By Population each Region
        final List<City> capitalR6 = cpr.getCapitalPopByRegion(app.con, 10);
        System.out.println("Top 10 Capital Population in each Region");
        cpr.displayCapitalRegion(capitalR6);

        //Summary reports
        final List<Country> popSumWorld =  sumR.sumWorldPop(app.con);
        System.out.println("==========Population of the world==========");
        System.out.println(String.format("%-20s| %-20s", "Location", "Population"));
        sumR.displaySumWorldPop(popSumWorld);

        final List<Country> popSumCont =  sumR.sumContPop(app.con, 1);
        System.out.println("==========Population of most populated continent==========");
        System.out.println(String.format("%-30s| %-30s", "Continent", "Population"));
        sumR.displaySumContPop(popSumCont);

        final List<Country> popSumReg =  sumR.sumRegPop(app.con, 1);
        System.out.println("==========Population of most populated region==========");
        System.out.println(String.format("%-30s| %-30s", "Region", "Population"));
        sumR.displaySumRegPop(popSumReg);

        final List<Country> popSumCoun = sumR.sumCouPop(app.con,1 );
        System.out.println("==========Population of most populated country==========");
        System.out.println(String.format("%-30s| %-30s", "Country", "Population"));
        sumR.displaySumCouPop(popSumCoun);

        final List<City> popDistReg =  sumR.sumDistPop(app.con, 1);
        System.out.println("==========Population of most populated district==========");
        System.out.println(String.format("%-30s| %-30s", "District", "Population"));
        sumR.displaySumDistPop(popDistReg);

        final List<City> popCityReg =  sumR.sumCityPop(app.con, 1);
        System.out.println("==========Population of most populated city==========");
        System.out.println(String.format("%-30s| %-30s", "City", "Population"));
        sumR.displaySumCityPop(popCityReg);

        //Display Population report of people living in cities
        //and not living in cities in each continent
        final List<City> report1 = ruReport.getContinentPopulation(app.con);
        System.out.println("Population report of people living in cities and not living in cities in each continent");
        ruReport.displayContinentPopulation(report1);

        //Display Population report of people living in cities
        // and not living in cities in each region
        final List<City> report2 = ruReport.getRegionPopulation(app.con);
        System.out.println("Population report of people living in cities and not living in cities in each region");
        ruReport.displayRegionPopulation(report2);

        //Display Population report of people living in cities
        //and not living in cities in each country
        final List<City> report3 = ruReport.getCountryPopulation(app.con);
        System.out.println("Population report of people living in cities and not living in cities in each country");
        ruReport.displayCountryPopulation(report3);

        // Display Language Population
        final List<Language> report4 = languageReport.getLanguagesReport(app.con);
        System.out.println("Language Report : The number of people who speak Chinese, English, Hindi, Spanish and Arabic.");
        languageReport.displayLanguagesPopulation(report4);

        //Disconnect from database
        app.disconnect();
    }


    /*
     Connect to the MySQL database. Load mysql driver
     and connect database up to 100 tries
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
                Thread.sleep(30_000);
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