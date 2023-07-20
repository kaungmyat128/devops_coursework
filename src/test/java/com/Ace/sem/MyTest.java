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

public class MyTest
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

    /**
     * country report starts here
     */
    @Test
    void displayCountriesNull() {
        countryReport.displayCountries(null);
    }

    @Test
    void displayCountriesContinentNull() {
        countryReport.displayCountriesContinent(null);
    }

    @Test
    void displayCountriesCountriesRegionNull() {
        countryReport.displayCountriesRegion(null);
    }

    @Test
    void storeIntoArrayListNull() {
        countryReport.storeIntoArraylist(null, null);
    }

    @Test
    void displayCountriesTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.displayCountries(country);

    }
    @Test
    void displayCountriesContinentTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.displayCountriesContinent(country);
    }
    @Test
    void displayCountriesRegionTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.displayCountriesRegion(country);
        countryReport.storeIntoArraylist(country, qry);
        countryReport.humanReadableFormat(0);
    }
    @Test
    void storeIntoArrayListTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.storeIntoArraylist(country, qry);
    }
    @Test
    void humanReadableFormatInteger()
    {
        countryReport.humanReadableFormat(0);
    }
    @Test
    void displayCountries()     {
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

    }
    @Test
    void displayCountriesContinent()     {
        ArrayList<Country> country = new ArrayList<Country>();
        Country c = new Country();
        c.setCode("MYN");
        c.setName("Myanmar");
        c.setContinent("Asia");
        c.setRegion("Southeast Asia");
        c.setPopulation(54593833);
        c.setCapital("Yangon");
        country.add(c);
        countryReport.displayCountriesContinent(country);

    }
    @Test
    void displayCountriesRegion()     {
        ArrayList<Country> country = new ArrayList<Country>();
        Country c = new Country();
        c.setCode("MYN");
        c.setName("Myanmar");
        c.setContinent("Asia");
        c.setRegion("Southeast Asia");
        c.setPopulation(54593833);
        c.setCapital("Yangon");
        country.add(c);
        countryReport.displayCountriesRegion(country);

    }

    @Test
    void storeIntoArrayListNotNull()     {
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
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 5";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            countryReport.storeIntoArraylist(country, qry);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getCountries()     {
            countryReport.getCountries(app.con, 3);
            countryReport.getCountries(app.con, 0);
    }
    @Test
    void getCountriesContinent()     {
        countryReport.getCountriesContinent(app.con, 3);
        countryReport.getCountriesContinent(app.con, 0);
    }
    @Test
    void getCountriesRegion()     {
        countryReport.getCountriesRegion(app.con, 3);
        countryReport.getCountriesRegion(app.con, 0);
    }
    @Test
    void humanReadableFormat()     {
        countryReport.humanReadableFormat(1000);
    }
    /**
     * city reports start here
     */
    @Test
    void displayCitiesNull() {
        cityReport.displayCities(null);
    }
    @Test
    void displayCityContinentsNull() {
        cityReport.displayCityContinents(null);
    }
    @Test
    void displayCityCountriesNull() {
        cityReport.displayCityCountries(null);
    }
    @Test
    void displayCityRegionNull() {
        cityReport.displayCityRegion(null);
    }
    @Test
    void displayCityDistrictNull() {
        cityReport.displayCityDistrict(null);

    }
    @Test
    void nullCheckerNull() {
        cityReport.nullChecker(null);
    }
    @Test
    void displayCitiesTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCities(city);
    }
    @Test
    void displayCityContinentsTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityContinents(city);
    }
    @Test
    void displayCityCountriesCountriesTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityCountries(city);
    }
    @Test
    void displayCityRegionTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityRegion(city);
    }
    @Test
    void displayCitiesDistrictContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityDistrict(city);
    }
    @Test
    void nullCheckerContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.nullChecker("");
    }
    @Test
    void displayCities()     {

            ArrayList<City> city = new ArrayList<>();
            City ct1 = new City();
            ct1.setCityName("Yangon");
            ct1.setCountryName("Myanmar");
            ct1.setContinents("Asia");
            ct1.setRegion("Southeast Asia");
            ct1.setDistrict("Yangon");
            ct1.setPopulation(5434678);
            city.add(ct1);
            cityReport.displayCities(city);
    }
    @Test
    void displayCityContinents()     {

        ArrayList<City> city = new ArrayList<>();
        City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5434678);
        city.add(ct1);
        cityReport.displayCityContinents(city);
    }
    @Test
    void displayCityCountries()     {

        ArrayList<City> city = new ArrayList<>();
        City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5434678);
        city.add(ct1);
        cityReport.displayCityCountries(city);

    }
    @Test
    void displayCityRegion()     {

        ArrayList<City> city = new ArrayList<>();
        City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5434678);
        city.add(ct1);
        cityReport.displayCityRegion(city);
    }
    @Test
    void displayCityDistrict()     {

        ArrayList<City> city = new ArrayList<>();
        City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5434678);
        city.add(ct1);
        cityReport.displayCityDistrict(city);
    }
    @Test
    void nullChecker()     {

        ArrayList<City> city = new ArrayList<>();
        City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5434678);
        city.add(ct1);
        cityReport.nullChecker("Not Null");
    }
    @Test
    void getCityPop()     {
        cityReport.getCityPop(app.con, 3);
        cityReport.getCityPop(app.con, 0);
    }
    @Test
    void getCityPopByDistrict()     {
        cityReport.getCityPopByDistrict(app.con, 3);
        cityReport.getCityPopByDistrict(app.con, 0);
    }
    @Test
    void getCityPopByContinent()     {
        cityReport.getCityPopByContinent(app.con, 3);
        cityReport.getCityPopByContinent(app.con, 0);
    }
    @Test
    void getCityPopByRegion()     {
        cityReport.getCityPopByRegion(app.con, 3);
        cityReport.getCityPopByRegion(app.con, 0);
    }
    @Test
    void getCityPopByCountry()     {
        cityReport.getCityPopByCountry(app.con, 3);
        cityReport.getCityPopByCountry(app.con, 0);
    }
    /**
     * language report starts here
     */
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
    }

    @Test
    void humanReadableFormatDouble(){
        languagesReport.humanReadableFormat(54000000);

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

            String strSelect = "SELECT countrylanguage.Language AS Language, "
                    + "SUM(country.Population) AS TotalPopulation, "
                    + "(SUM(country.Population) / (SELECT SUM(country.Population) FROM country)) * 100 AS Percentage "
                    + "FROM countrylanguage JOIN country ON countrylanguage.CountryCode = country.Code "
                    + "WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + "GROUP BY Language ORDER BY TotalPopulation DESC";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void getLanguageReport(){
        languagesReport.getLanguagesReport(app.con);
    }
    /**
     * capital city testing starts here
     */
    @Test
    void displayCapitalNull() {
        capitalReport.displayCapital(null);
        capitalReport.displayCapitalContinent(null);
        capitalReport.displayCapitalRegion(null);
        capitalReport.CapitalArrList(null, null);
    }
    @Test
    void displayCapitalsTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ResultSet qry = null;
        capitalReport.displayCapital(city);
        capitalReport.displayCapitalContinent(city);
        capitalReport.displayCapitalRegion(city);
        capitalReport.CapitalArrList(city, qry);
    }

    @Test
    void displayCapitals()     {
        try{
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setPopulation(5434678);
            city.add(ct);
            capitalReport.displayCapital(city);
            capitalReport.displayCapitalContinent(city);
            capitalReport.displayCapitalRegion(city);

            String strSelect =
                    "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM `city` JOIN country ON country.Capital = city.ID " +
                            "ORDER BY city.Population DESC";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            capitalReport.CapitalArrList(city, qry);
            capitalReport.getCapitalPopByWorld(app.con, 3);
            capitalReport.getCapitalPopByContinent(app.con, 3);
            capitalReport.getCapitalPopByRegion(app.con, 3);
            capitalReport.getCapitalPopByWorld(app.con, 0);
            capitalReport.getCapitalPopByContinent(app.con, 0);
            capitalReport.getCapitalPopByRegion(app.con, 0);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Rural and Urban report testing starts here
     */
    @Test
    void displayRuralUrbanNull() {
        ruReport.displayContinentPopulation(null);
        ruReport.displayRegionPopulation(null);
        ruReport.displayCountryPopulation(null);
    }
    @Test
    void displayRuralUrbanTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayContinentPopulation(city);
        ruReport.displayRegionPopulation(city);
        ruReport.displayCountryPopulation(city);
        ruReport.humanReadableFormat(0);
    }
    @Test
    void displayRuralUrbanPop()     {
        try{
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setTotalCitiesPopulation(2200000);
            ct.setTotalNotCitiesPopulation(3000000);
            ct.setTotalPopulation(5200000);
            city.add(ct);
            ruReport.displayContinentPopulation(city);
            ruReport.displayRegionPopulation(city);
            ruReport.displayCountryPopulation(city);
            ruReport.humanReadableFormat(1000000000);

            ruReport.getContinentPopulation(app.con);
            ruReport.getRegionPopulation(app.con);
            ruReport.getCountryPopulation(app.con);


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Summary report testing starts here
     */
    @Test
    void displaySummaryNull() {
        summaryReport.displaySumWorldPop(null);
        summaryReport.displaySumContPop(null);
        summaryReport.displaySumRegPop(null);
        summaryReport.displaySumCouPop(null);
        summaryReport.displaySumDistPop(null);
        summaryReport.displaySumCityPop(null);
    }

    @Test
    void displaySummaryTestContainsNull()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        ArrayList<City> citySum = new ArrayList<>();
        couSum.add(null);
        citySum.add(null);
        ResultSet qry = null;
        summaryReport.displaySumWorldPop(couSum);
        summaryReport.displaySumContPop(couSum);
        summaryReport.displaySumRegPop(couSum);
        summaryReport.displaySumCouPop(couSum);
        summaryReport.displaySumDistPop(citySum);
        summaryReport.displaySumCityPop(citySum);
        summaryReport.humanReadableFormatLong(0);
    }

    @Test
    void displaySummary()
    {
        try{
            ArrayList<Country> couSum = new ArrayList<>();
            ArrayList<City> citySum = new ArrayList<>();
            Country c = new Country();
            c.setName("Myanmar");
            c.setContinent("Asia");
            c.setRegion("Southeast Asia");
            c.setPopulation(54593833);
            c.setCapital("Yangon");
            c.setGenPop(1000000);
            couSum.add(c);

            City ci = new City();
            ci.setCityName("Yangon");
            ci.setDistrict("Yangon-D");
            ci.setGenPop(10000);
            ci.setPopulation(453467000);
            citySum.add(ci);
            summaryReport.displaySumWorldPop(couSum);
            summaryReport.displaySumContPop(couSum);
            summaryReport.displaySumRegPop(couSum);
            summaryReport.displaySumCouPop(couSum);
            summaryReport.displaySumDistPop(citySum);
            summaryReport.displaySumCityPop(citySum);

            summaryReport.sumWorldPop(app.con);
            summaryReport.sumContPop(app.con, 1);
            summaryReport.sumRegPop(app.con, 1);
            summaryReport.sumCouPop(app.con, 1);
            summaryReport.sumDistPop(app.con, 1);
            summaryReport.sumCityPop(app.con, 1);
            countryReport.humanReadableFormat(1000);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @AfterAll
    static void disconnect(){
        app.disconnect();
    }

}
