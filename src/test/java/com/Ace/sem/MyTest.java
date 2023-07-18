package com.Ace.sem;

import com.mysql.cj.protocol.Resultset;
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

public class MyTest
{
    static CountryReport countryReport;
    static CityReport cityReport;
    static countryLanguagesReport languagesReport;
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
    }

    @Test
    void displayCountriesNull() {
        countryReport.displayCountries(null);
        countryReport.displayCountriesContinent(null);
        countryReport.displayCountriesRegion(null);
        countryReport.storeIntoArraylist(null, null);
    }
    @Test
    void displayCountriesTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.displayCountries(country);
        countryReport.displayCountriesContinent(country);
        countryReport.displayCountriesRegion(country);
        countryReport.storeIntoArraylist(country, qry);
        countryReport.humanReadableFormat(0);
    }
    @Test
    void displayCountries()     {
        try{
            ArrayList<Country> country = new ArrayList<Country>();
            Country c = new Country();
            c.setCode("MYN");
            c.setName("Myanmar");
            c.setContinent("Asia");
            c.setRegion("Southeast Asia");
            c.setPopulation(54593833);
            c.setCapital("Yangon");
            country.add(c);
            countryReport.displayCountries(country);
            countryReport.displayCountriesContinent(country);
            countryReport.displayCountriesRegion(country);
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 5";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            countryReport.storeIntoArraylist(country, qry);
            countryReport.getCountries(app.con, 3);
            countryReport.getCountriesContinent(app.con, 3);
            countryReport.getCountriesRegion(app.con, 3);
            countryReport.getCountries(app.con, 0);
            countryReport.getCountriesContinent(app.con, 0);
            countryReport.getCountriesRegion(app.con, 0);
            countryReport.humanReadableFormat(1000);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void displayCitiesNull() {
        cityReport.displayCities(null);
        cityReport.displayCityContinents(null);
        cityReport.displayCityCountries(null);
        cityReport.displayCityRegion(null);
        cityReport.displayCityDistrict(null);
        cityReport.nullChecker(null);
    }
    @Test
    void displayCitiesTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCities(city);
        cityReport.displayCityContinents(city);
        cityReport.displayCityCountries(city);
        cityReport.displayCityRegion(city);
        cityReport.displayCityDistrict(city);
        cityReport.nullChecker("");
    }
    @Test
    void displayCities()     {
        try{
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setDistrict("Yangon");
            ct.setPopulation(5434678);
            city.add(ct);
            cityReport.displayCities(city);
            cityReport.displayCityContinents(city);
            cityReport.displayCityCountries(city);
            cityReport.displayCityRegion(city);
            cityReport.displayCityDistrict(city);
            cityReport.nullChecker("Not Null");

            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 5";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            cityReport.getCityPop(app.con, 3);
            cityReport.getCityPopByDistrict(app.con, 3);
            cityReport.getCityPopByContinent(app.con, 3);
            cityReport.getCityPopByRegion(app.con, 3);
            cityReport.getCityPopByCountry(app.con, 3);
            cityReport.getCityPop(app.con, 0);
            cityReport.getCityPopByDistrict(app.con, 0);
            cityReport.getCityPopByContinent(app.con, 0);
            cityReport.getCityPopByRegion(app.con, 0);
            cityReport.getCityPopByCountry(app.con, 0);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void displayLanguageReportNull()
    {
        languagesReport.displayLanguagesPopulation(null);
    }
    @Test
    void displayLanguageReportContainsNull()
    {
        ArrayList<Language> language = new ArrayList<>();
        language.add(null);
        languagesReport.displayLanguagesPopulation(language);
        languagesReport.humanReadableFormat(0);
    }
    @Test
    void displayLanguageReport()     {
        try{
            ArrayList<Language> language = new ArrayList<>();
            Language ln = new Language();
            ln.setLanguage("Burmese");
            ln.setTotal_Population(54000000);
            ln.setPercentage(68.35);
            language.add(ln);
            languagesReport.displayLanguagesPopulation(language);
            languagesReport.humanReadableFormat(54000000);

            String strSelect = "SELECT countrylanguage.Language AS Language, "
                    + "SUM(country.Population) AS TotalPopulation, "
                    + "(SUM(country.Population) / (SELECT SUM(country.Population) FROM country)) * 100 AS Percentage "
                    + "FROM countrylanguage JOIN country ON countrylanguage.CountryCode = country.Code "
                    + "WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + "GROUP BY Language ORDER BY TotalPopulation DESC";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            languagesReport.getLanguagesReport(app.con);


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //app.disconnect();

}
