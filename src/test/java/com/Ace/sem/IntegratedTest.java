package com.Ace.sem;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.invoke.LambdaConversionException;
import java.sql.*;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegratedTest
{
    static CountryReport countryReport;
    static CityReport cityReport;
    static countryLanguagesReport languagesReport;
    static SummaryReport summaryReport;
    static CapitalReport capitalReport;
    static RuralUrbanReport ruReport;
    static App app;

    @BeforeAll
    static void init()
    {
        //------------Creating Object for Each Java Class------------
        app = new App();
        app.connect();
        countryReport = new CountryReport();
        cityReport = new CityReport();
        languagesReport = new countryLanguagesReport();
        summaryReport = new SummaryReport();
        capitalReport = new CapitalReport();
        ruReport = new RuralUrbanReport();
    }

    // Helper method to check if the column is present (not null or not empty)
    private boolean columnPresentString (String columnValue){
        return columnValue != null || columnValue.isEmpty();
    }
    // Helper method to check if the column is present (not null or not empty)
    private boolean columnPresentInt (int columnValue) {
        return columnValue >= 0;
    }
    // Helper method to check if the column is present (not null or not empty)
    private boolean columnPresentLong (long columnValue) {
        return columnValue >= 0;
    }

    // Helper method to check if the column is present (not null or not empty)
    private boolean columnPresentDouble (double columnValue) {
        return columnValue >= 0;
    }
    /**
     * country report starts here
     */
    @Test
    void get_displayCountries() {
        try {
            ArrayList<Country> country = new ArrayList<Country>();

            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 5";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            countryReport.storeIntoArraylist(country, qry);

            // Retrieve all countries report with limit
            country = countryReport.getCountries(app.con, 3);
            // Test for not null data
            assertNotNull(country, "The ArrayList of countries should not be null.");
            // Test for correct numbers of query results.
            assertEquals(3, country.size(), "The method should return 3 countries as specified by the limit.");
            countryReport.displayCountries(country);

            // Retrieve all countries report without limit
            country = countryReport.getCountries(app.con, 0);
            // Test for not null data
            assertNotNull(country, "The ArrayList of countries should not be null.");
            assertFalse(country.isEmpty(), "The ArrayList of countries should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (Country c : country) {
            assertTrue(columnPresentString(c.getCode()), "Country code should be present.");
            assertTrue(columnPresentString(c.getName()), "Country name should be present.");
            assertTrue(columnPresentString(c.getContinent()), "Country continent should be present.");
            assertTrue(columnPresentString(c.getRegion()), "Country region should be present.");
            assertTrue(columnPresentInt(c.getPopulation()), "Country population should be present.");
            assertTrue(columnPresentString(c.getCapital()), "Country capital should be present.");
            assertTrue(columnPresentLong(c.getGenPop()), "Country capital should be present.");
            }
            // Check The first entry of country report data is True as Expected.
            assertEquals(country.get(0).getCode(), "CHN", "First Entry Country Report - Country Code is not true.");
            assertEquals(country.get(0).getName(), "China", "First Entry Country Report - Country Name is not true.");
            assertEquals(country.get(0).getContinent(), "Asia", "First Entry Country Report - Continent Name is not true.");
            assertEquals(country.get(0).getRegion(), "Eastern Asia", "First Entry Country Report - Region Name is not true.");
            assertEquals(country.get(0).getPopulation(), 1277558000, "First Entry Country Report - Population is not true.");
            assertEquals(country.get(0).getCapital(), "Peking", "First Entry Country Report - Capital City is not true.");


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void get_displayCountriesContinent() {
        try {
            ArrayList<Country> country = new ArrayList<Country>();

            country = countryReport.getCountriesContinent(app.con, 3);
            // Test for not null data
            assertNotNull(country, "The ArrayList of countries should not be null.");
            // Test for correct numbers of query results. Limit - 3 for each continent.
            // So total queries result will be ( 3 * 6 ) = 18
            assertEquals(18, country.size(), "The method should return 3 countries as specified by the limit.");
            countryReport.displayCountriesContinent(country);

            // Retrieve all countries continent report without limit
            country = countryReport.getCountriesContinent(app.con, 0);
            // Test for not null data
            assertNotNull(country, "The ArrayList of countries should not be null.");
            assertFalse(country.isEmpty(), "The ArrayList of countries should not be empty.");


            // Test for correct numbers of column names (presence of columns)
            for (Country c : country) {
                assertTrue(columnPresentString(c.getCode()), "Country code should be present.");
                assertTrue(columnPresentString(c.getName()), "Country name should be present.");
                assertTrue(columnPresentString(c.getContinent()), "Country continent should be present.");
                assertTrue(columnPresentString(c.getRegion()), "Country region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "Country population should be present.");
                assertTrue(columnPresentString(c.getCapital()), "Country capital should be present.");
                assertTrue(columnPresentLong(c.getGenPop()), "Country capital should be present.");
            }
            // Check The first entry of country report data is True as Expected.
            assertEquals(country.get(0).getCode(), "CHN", "First Entry Country Report - Country Code is not true.");
            assertEquals(country.get(0).getName(), "China", "First Entry Country Report - Country Name is not true.");
            assertEquals(country.get(0).getContinent(), "Asia", "First Entry Country Report - Continent Name is not true.");
            assertEquals(country.get(0).getRegion(), "Eastern Asia", "First Entry Country Report - Region Name is not true.");
            assertEquals(country.get(0).getPopulation(), 1277558000, "First Entry Country Report - Population is not true.");
            assertEquals(country.get(0).getCapital(), "Peking", "First Entry Country Report - Capital City is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void get_displayCountriesRegion() {
        try {
            ArrayList<Country> country1 = new ArrayList<Country>();

            country1 = countryReport.getCountriesRegion(app.con, 3);
            // Test for not null data
            assertNotNull(country1, "The ArrayList of countries should not be null.");
            // Test for correct numbers of query results. Limit - 3 for each region.
            // So total queries result will be 72
            assertEquals(72, country1.size(), "The method should return 3 countries as specified by the limit.");
            countryReport.displayCountriesRegion(country1);

            // Retrieve all countries region report without limit
            country1 = countryReport.getCountriesRegion(app.con, 0);
            // Test for not null data
            assertNotNull(country1, "The ArrayList of countries should not be null.");
            assertFalse(country1.isEmpty(), "The ArrayList of countries should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (Country c : country1) {
                assertTrue(columnPresentString(c.getCode()), "Country code should be present.");
                assertTrue(columnPresentString(c.getName()), "Country name should be present.");
                assertTrue(columnPresentString(c.getContinent()), "Country continent should be present.");
                assertTrue(columnPresentString(c.getRegion()), "Country region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "Country population should be present.");
                assertTrue(columnPresentString(c.getCapital()), "Country capital should be present.");
                assertTrue(columnPresentLong(c.getGenPop()), "Country capital should be present.");
            }

            // Check The first entry of country report data by Region is True as Expected.
            assertEquals(country1.get(0).getCode(), "SGS", "First Entry Country Report - Country Code is not true.");
            assertEquals(country1.get(0).getName(), "South Georgia and the South Sandwich Islands", "First Entry Country Report - Country Name is not true.");
            assertEquals(country1.get(0).getContinent(), "Antarctica", "First Entry Country Report - Continent Name is not true.");
            assertEquals(country1.get(0).getRegion(), "Antarctica", "First Entry Country Report - Region Name is not true.");
            assertEquals(country1.get(0).getPopulation(), 0, "First Entry Country Report - Population is not true.");
            assertEquals(country1.get(0).getCapital(), null, "First Entry Country Report - Capital City is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * city reports start here
     */

    @Test
    void get_displayCities()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = cityReport.getCityPop(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results
            assertEquals(3, city.size(), "The method should return 3 cities as specified by the limit.");
            cityReport.displayCities(city);

            // Retrieve all countries region report without limit
            city = cityReport.getCityPop(app.con, 0);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
                assertTrue(columnPresentString(c.getDistrict()), "Region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
            }

            // Check The first entry of country report data by Region is True as Expected.
            assertEquals(city.get(0).getCityName(), "Mumbai (Bombay)", "First Entry City Report - City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "India", "First Entry City Report - Country Name is not true.");
            assertEquals(city.get(0).getDistrict(), "Maharashtra", "First Entry City Report - Districit Name is not true.");
            assertEquals(city.get(0).getPopulation(), 10500000, "First Entry City Report - Population is not true.");


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

@Test
void get_displayCitiesContinent()     {
    try{
        ArrayList<City> city = new ArrayList<>();

        city = cityReport.getCityPopByContinent(app.con, 3);
        // Test for not null data
        assertNotNull(city, "The ArrayList of cities should not be null.");
        // Test for correct numbers of query results. Limit - 3 cities report for each continent.
        // So total queries result will be ( 3 * 7 ) = 21
        assertEquals(21, city.size(), "The method should return 3 * 7 continents = 21 results  as specified by the limit.");
        cityReport.displayCityContinents(city);

        // Retrieve all countries region report without limit
        city = cityReport.getCityPopByContinent(app.con, 0);
        // Test for not null data
        assertNotNull(city, "The ArrayList of cities should not be null.");
        assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

        // Test for correct numbers of column names (presence of columns)
        for (City c : city) {
            assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
            assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
            assertTrue(columnPresentString(c.getDistrict()), "Region should be present.");
            assertTrue(columnPresentString(c.getContinents()), "Continent should be present.");
            assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
        }
        // Check The first entry of country report data by Region is True as Expected.
        assertEquals(city.get(0).getCityName(), "Mumbai (Bombay)", "First Entry City Report - City Name is not true.");
        assertEquals(city.get(0).getCountryName(), "India", "First Entry City Report - Country Name is not true.");
        assertEquals(city.get(0).getContinents(), "Asia", "First Entry City Report - Continent Name is not true.");
        assertEquals(city.get(0).getDistrict(), "Maharashtra", "First Entry City Report - District Name is not true.");
        assertEquals(city.get(0).getPopulation(), 10500000, "First Entry City Report - Population is not true.");

    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    @Test
    void get_displayCitiesRegion()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = cityReport.getCityPopByRegion(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 for each region.
            // So total queries result will be 73
            assertEquals(73, city.size(), "The method should return 3 cities (total 73 results ) as specified by the limit.");
            cityReport.displayCityRegion(city);

            // Retrieve all countries region report without limit
            city = cityReport.getCityPopByRegion(app.con, 0);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
                assertTrue(columnPresentString(c.getDistrict()), "Region should be present.");
                assertTrue(columnPresentString(c.getRegion()), "Continent should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
            }
            // Check The first entry of country report data by Region is True as Expected.
            assertEquals(city.get(0).getCityName(), "city", "First Entry City Report - City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "Bouvet Island", "First Entry City Report - Country Name is not true.");
            assertEquals(city.get(0).getDistrict(), "-", "First Entry City Report - District  Name is not true.");
            assertEquals(city.get(0).getRegion(), "Antarctica", "First Entry Country Report - Region Name is not true.");
            assertEquals(city.get(0).getPopulation(), 10500000, "First Entry Country Report - Population is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void get_displayCitiesCountry()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = cityReport.getCityPopByCountry(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 for each country.
            // So total queries result will be 501
            assertEquals(501, city.size(), "The method should return 3 cities (total 501 results ) as specified by the limit.");
            cityReport.displayCityCountries(city);

            // Retrieve all countries region report without limit
            city = cityReport.getCityPopByCountry(app.con, 0);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
                assertTrue(columnPresentString(c.getDistrict()), "Region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
            }
            // Check The first entry of country report data by Region is True as Expected.
            assertEquals(city.get(0).getCityName(), "Kabul", "First Entry City Report - City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "Afghanistan", "First Entry City Report - Country Name is not true.");
            assertEquals(city.get(0).getDistrict(), "Kabol", "First Entry City Report - District  Name is not true.");
            assertEquals(city.get(0).getPopulation(), 1780000 , "First Entry City Report - Population is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void get_displayCitiesDistrict()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = cityReport.getCityPopByDistrict(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 cities report for each district.
            // So total queries result will be 2261
            assertEquals(2261, city.size(), "The method should return 3 cities ( total 2261 results ) as specified by the limit.");
            cityReport.displayCityDistrict(city);

            // Retrieve all countries region report without limit
            city = cityReport.getCityPopByDistrict(app.con, 0);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
                assertTrue(columnPresentString(c.getDistrict()), "Region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
            }
            // Check The first entry of country report data by Region is True as Expected.
            assertEquals(city.get(0).getCityName(), "Taiping", "First Entry City Report - City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "Taiwan", "First Entry City Report - Country Name is not true.");
            assertEquals(city.get(0).getDistrict(), "", "First Entry City Report - District  Name is not true.");
            assertEquals(city.get(0).getPopulation(), 165524 , "First Entry Country Report - Population is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * language report starts here
     */
    @Test
    void get_displayLanguageReport()     {
        try{
            ArrayList<Language> language = new ArrayList<>();
            language = languagesReport.getLanguagesReport(app.con);
            // Test for not null data
            assertNotNull(language, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results. Expected exactly 5 total results
            assertEquals(5, language.size(), "The method should return 5 query results for langauge report");
            languagesReport.displayLanguagesPopulation(language);

            // Test for correct numbers of column names (presence of columns)
            for (Language l : language) {
                assertTrue(columnPresentString(l.getLanguage()), "City Name should be present.");
                assertTrue(columnPresentLong(l.getTotal_Population()), "City name should be present.");
                assertTrue(columnPresentDouble(l.getPercentage()), "Region should be present.");
            }
            // Check The first entry of country report data is True as Expected.
            assertEquals(language.get(0).getLanguage(), "Chinese", "First Entry Language Report - Language is not true.");
            assertEquals(language.get(0).getTotal_Population(), 1968265500, "First Entry Language Report - total population is not true.");
            assertEquals(language.get(0).getPercentage(), 32.3794, "First Entry Language Report - percentage is not true.");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * capital city testing starts here
     */
    @Test
    void get_displayCapitals()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = capitalReport.getCapitalPopByWorld(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 cities report
            assertEquals(3, city.size(), "The method should return 3 cities as specified by the limit.");
            capitalReport.displayCapital(city);

            // Retrieve all countries region report without limit
            city = capitalReport.getCapitalPopByWorld(app.con, 0);

            // Test for not null data
            assertNotNull(city, "The ArrayList of cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "City name should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "City population should be present.");
            }

            // Check The first entry of country report data is True as Expected.
            assertEquals(city.get(0).getCityName(), "Seoul", "First Entry Capital City Report - Capital City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "South Korea", "First Entry Capital City  Report - Country Name is not true.");
            assertEquals(city.get(0).getContinents(), "Asia", "First Entry Capital City Report - continent name is not true.");
            assertEquals(city.get(0).getRegion(), "Eastern Asia", "First Entry Capital City  Report - Region Name is not true.");
            assertEquals(city.get(0).getPopulation(), 9981619, "First Entry Capital City Report - population is not true.");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void get_displayCapitalsByContinent()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = capitalReport.getCapitalPopByContinent(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of Capital cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 cities report for each continent.
            // So total queries result will be 3 * 7 continents  = 21
            assertEquals(21, city.size(), "The method should return 3 cities (total 21 results ) as specified by the limit.");
            capitalReport.displayCapitalContinent(city);

            // Retrieve all countries region report without limit
            city = capitalReport.getCapitalPopByContinent(app.con, 0);

            // Test for not null data
            assertNotNull(city, "The ArrayList of capital cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "Capital City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "Capital City name should be present.");
                assertTrue(columnPresentString(c.getContinents()), "Continent name should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "Capital City population should be present.");
            }

            // Check The first entry of country report data is True as Expected.
            assertEquals(city.get(0).getCityName(), "Seoul", "First Entry Capital City Report - Capital City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "South Korea", "First Entry Capital City  Report - Country Name is not true.");
            assertEquals(city.get(0).getContinents(), "Asia", "First Entry Capital City Report - continent name is not true.");
            assertEquals(city.get(0).getRegion(), "Eastern Asia", "First Entry Capital City  Report - Region Name is not true.");
            assertEquals(city.get(0).getPopulation(), 9981619, "First Entry Capital City Report - population is not true.");


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void get_displayCapitalsByRegion()     {
        try{
            ArrayList<City> city = new ArrayList<>();

            city = capitalReport.getCapitalPopByRegion(app.con, 3);
            // Test for not null data
            assertNotNull(city, "The ArrayList of Capital cities should not be null.");
            // Test for correct numbers of query results. Limit - 3 cities report for each region.
            // So total queries result will be 72
            assertEquals(72, city.size(), "The method should return 3 cities ( total 72 results ) as specified by the limit.");
            capitalReport.displayCapitalRegion(city);

            // Retrieve all countries region report without limit
            city = capitalReport.getCapitalPopByRegion(app.con, 0);

            // Test for not null data
            assertNotNull(city, "The ArrayList of capital cities should not be null.");
            assertFalse(city.isEmpty(), "The ArrayList of cities should not be empty.");

            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getCityName()), "Capital City Name should be present.");
                assertTrue(columnPresentString(c.getCountryName()), "Capital City name should be present.");
                assertTrue(columnPresentString(c.getRegion()), "Region should be present.");
                assertTrue(columnPresentInt(c.getPopulation()), "Capital City population should be present.");
            }

            // Check The first entry of country report data is True as Expected.
            assertEquals(city.get(0).getCityName(), null, "First Entry Capital City Report - Capital City Name is not true.");
            assertEquals(city.get(0).getCountryName(), "Bouvet Island", "First Entry Capital City  Report - Country Name is not true.");
            assertEquals(city.get(0).getContinents(), "Antarctica", "First Entry Capital City Report - continent name is not true.");
            assertEquals(city.get(0).getRegion(), "Antarctica", "First Entry Capital City  Report - Region Name is not true.");
            assertEquals(city.get(0).getPopulation(), 0, "First Entry Capital City Report - population is not true.");



        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Rural and Urban report testing starts here
     */

    @Test
    void get_displayRuralUrbanByContinent()     {
            ArrayList<City> city = new ArrayList<>();
            city = ruReport.getContinentPopulation(app.con);

            // Test for not null data
            assertNotNull(city, "The ArrayList of Rural & Urban Report should not be null.");
            // Test for correct numbers of query results.
            // So total queries result will be 6 because there are 6 continents . Antarctica Continent is not displayed.
            assertEquals(6, city.size(), "The method should return 7 continents Rural Urban population report");
            ruReport.displayContinentPopulation(city);
            // Test for correct numbers of column names (presence of columns)
            for (City c : city) {
                assertTrue(columnPresentString(c.getContinents()), "Continent name should be present.");
                assertTrue(columnPresentLong(c.getTotalPopulation()), "Total Population of each continent should be present.");
                assertTrue(columnPresentLong(c.getTotalCitiesPopulation()), "Total Cities Population Population  should be present.");
                assertTrue(columnPresentLong(c.getTotalNotCitiesPopulation()), "Total NOT Cities Population Population  should be present.");

            }
        // Check The first entry of country report data is True as Expected.
        assertEquals(city.get(0).getContinents(), "Asia", "First Entry Rural Urban Report - continent name is not true.");
        assertEquals(city.get(0).getTotalPopulation(),  3705025700L, "First Entry Capital City Report - population is not true.");
        assertEquals(city.get(0).getTotalCitiesPopulation(), 697604103 , "First Entry Rural Urban Report - continent name is not true.");
        assertEquals(city.get(0).getTotalNotCitiesPopulation(),  3007421597L , "First Entry Capital City Report - population is not true.");

    }

    @Test
    void get_displayRuralUrbanByRegion()     {
        ArrayList<City> city = new ArrayList<>();
        city = ruReport.getRegionPopulation(app.con);

        // Test for not null data
        assertNotNull(city, "The ArrayList of Rural & Urban Report should not be null.");
        // Test for correct numbers of query results.
        // So total queries result will be 7 because there are 7 regions
        assertEquals(23, city.size(), "The method should return 7 regions Rural Urban population report");
        ruReport.displayRegionPopulation(city);
        // Test for correct numbers of column names (presence of columns)
        for (City c : city) {
            assertTrue(columnPresentString(c.getRegion()), "Region name should be present.");
            assertTrue(columnPresentLong(c.getTotalPopulation()), "Total Population of each region should be present.");
            assertTrue(columnPresentLong(c.getTotalCitiesPopulation()), "Total Cities Population Population  should be present.");
            assertTrue(columnPresentLong(c.getTotalNotCitiesPopulation()), "Total NOT Cities Population Population  should be present.");

        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(city.get(0).getRegion(), "Eastern Asia", "First Entry Rural Urban Report - region name is not true.");
        assertEquals(city.get(0).getTotalPopulation(),  1507328000L, "First Entry Capital City Report - population is not true.");
        assertEquals(city.get(0).getTotalCitiesPopulation(), 317476534, "First Entry Rural Urban Report - continent name is not true.");
        assertEquals(city.get(0).getTotalNotCitiesPopulation(),  1189851466 , "First Entry Capital City Report - population is not true.");

    }

    @Test
    void get_displayRuralUrbanCountry()     {
        ArrayList<City> city = new ArrayList<>();
        city = ruReport.getCountryPopulation(app.con);

        // Test for not null data
        assertNotNull(city, "The ArrayList of Rural & Urban Report should not be null.");
        // Test for correct numbers of query results.
        // So total queries result will be 7 because there are 7 continents
        assertEquals(232, city.size(), "The method should return 7 countries Rural Urban population report");
        ruReport.displayCountryPopulation(city);
        // Test for correct numbers of column names (presence of columns)
        for (City c : city) {
            assertTrue(columnPresentString(c.getCountryName()), "Country name should be present.");
            assertTrue(columnPresentLong(c.getTotalPopulation()), "Total Population of each Country should be present.");
            assertTrue(columnPresentLong(c.getTotalCitiesPopulation()), "Total Cities Population Population  should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(city.get(0).getCountryName(), "China", "First Entry Rural Urban Report - country name is not true.");
        assertEquals(city.get(0).getTotalPopulation(),  463753554000L, "First Entry Capital City Report - population is not true.");
        assertEquals(city.get(0).getTotalCitiesPopulation(), 175953614, "First Entry Rural Urban Report - continent name is not true.");
        assertEquals(city.get(0).getTotalNotCitiesPopulation(),  463577600386L , "First Entry Capital City Report - population is not true.");

    }


    /**
     * Summary report testing starts here
     */
    @Test
    void get_displaySummary()
    {
        ArrayList<Country> summary = new ArrayList<>();
        summary = summaryReport.sumWorldPop(app.con);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return 7 countries Rural Urban population report");
        summaryReport.displaySumWorldPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (Country c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Country name should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getGenPop(), 6078749450L, "Summary report of world population is not true.");

    }

    @Test
    void get_displaySummaryContinent()
    {
        ArrayList<Country> summary = new ArrayList<>();
        summary = summaryReport.sumContPop(app.con, 1);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return summary report of a continent");
        summaryReport.displaySumContPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (Country c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Total Population should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getContinent(),  "Asia", "Summary report of continent population is not true.");
        assertEquals(summary.get(0).getGenPop(),  3705025700L, "Summary report of continent population is not true.");

    }
    @Test
    void get_displaySummaryRegion()
    {
        ArrayList<Country> summary = new ArrayList<>();
        summary = summaryReport.sumRegPop(app.con, 1);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return summary report of a region");
        summaryReport.displaySumRegPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (Country c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Total Population should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getRegion(),  "Eastern Asia", "Summary report of continent population is not true.");
        assertEquals(summary.get(0).getGenPop(),  1507328000L, "Summary report of continent population is not true.");

    }
    @Test
    void get_displaySummaryCountry()
    {
        ArrayList<Country> summary = new ArrayList<>();
        summary = summaryReport.sumCouPop(app.con, 1);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return summary report of a country");
        summaryReport.displaySumCouPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (Country c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Total Population should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getName(),  "China", "Summary report of Country population is not true.");
        assertEquals(summary.get(0).getGenPop(),  1277558000L, "Summary report of country population is not true.");

    }
    @Test
    void get_displaySummaryDistrict()
    {
        ArrayList<City> summary = new ArrayList<>();
        summary = summaryReport.sumDistPop(app.con, 1);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return summary report of a district");
        summaryReport.displaySumDistPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (City c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Total Population should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getDistrict(),  "São Paulo", "Summary report of district population is not true.");
        assertEquals(summary.get(0).getGenPop(),  26316966, "Summary report of continent population is not true.");

    }
    @Test
    void get_displaySummaryCity()
    {
        ArrayList<City> summary = new ArrayList<>();
        summary = summaryReport.sumCityPop(app.con, 1);

        // Test for not null data
        assertNotNull(summary, "The ArrayList of summary Report should not be null.");
        // Test for correct numbers of query results.
        assertEquals(1, summary.size(), "The method should return summary report of a city");
        summaryReport.displaySumCityPop(summary);
        // Test for correct numbers of column names (presence of columns)
        for (City c : summary) {
            assertTrue(columnPresentLong(c.getGenPop()), "Total Population should be present.");
        }
        // Check The first entry of country report data is True as Expected.
        assertEquals(summary.get(0).getCityName(),  "Mumbai (Bombay)", "Summary report of city population is not true.");
        assertEquals(summary.get(0).getPopulation(),  10500000, "Summary report of continent population is not true.");

    }
    @AfterAll
    static void disconnect(){
        app.disconnect();
    }

}
