package com.Ace.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * the class created for the purpose of unit testing
 * all the individual methods are included
 */
public class unitTesting
{
    static CountryReport countryReport;
    static CityReport cityReport;
    static CountryLanguagesReport languagesReport;
    static SummaryReport summaryReport;
    static CapitalReport capitalReport;
    static RuralUrbanReport ruReport;
    static App app;

    /**
     * created objects to be reused in the testing
     */
    @BeforeAll
    static void init()
    {
        //------------Creating Object for Each Java Class------------
        app = new App();
        app.connect();
        countryReport = new CountryReport();
        cityReport = new CityReport();
        languagesReport = new CountryLanguagesReport();
        summaryReport = new SummaryReport();
        capitalReport = new CapitalReport();
        ruReport = new RuralUrbanReport();
    }

    /**
     * country report starts here
     * checks the response of display country if it is null
     */
    @Test
    void displayCountriesNull() {
            countryReport.displayCountries(null);
    }

    /**
     * checks the response of display country based on continent if it is null
     */
    @Test
    void displayCountriesContinentNull() {
        countryReport.displayCountriesContinent(null);
    }

    /**
     * checks the response of display country based on region if it is null
     */
    @Test
    void displayCountriesCountriesRegionNull() {
        countryReport.displayCountriesRegion(null);
    }

    /**
     * checks the response if null value is stored in arraylist
     */
    @Test
    void storeIntoArrayListNull() {
        countryReport.storeIntoArraylist(null, null);
    }

    /**
     * checks the response of display country if arraylist is null
     */
    @Test
    void displayCountriesTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountries(country);

    }

    /**
     * checks the response of display country based on continent if arraylist is null
     */
    @Test
    void displayCountriesContinentTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesContinent(country);
    }

    /**
     * checks the response of display country based on region if arraylist is null
     */
    @Test
    void displayCountriesRegionTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesRegion(country);

    }

    /**
     * checks the response if null value is stored in arraylist
     */
    @Test
    void storeIntoArrayListTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        ResultSet qry = null;
        countryReport.storeIntoArraylist(country, qry);
    }
    /**
     * checks if the human readable format method of int works
     */
    @Test
    void humanReadableFormatInteger()
    {
        countryReport.humanReadableFormat(0);
    }

    /**
     * checks if the display country method works based on give parameters
     */
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

    /**
     * checks if the display country based on continent method works based on give parameters
     */
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
    /**
     * checks if the display country based on region method works based on give parameters
     */
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

    /**
     * checks if storing into arraylist works
     */
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

    /**
     * checks if country data based on different categories can be gathered with and without limit
     */
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

    /**
     * checks if human readable format works.
     */
    @Test
    void humanReadableFormat()     {
        countryReport.humanReadableFormat(1000);
    }
    /**
     * city reports start here
     * checks the response of display city methods if the intput is null
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

    /**
     * the method that converts null or space to -, checking that method
     */
    @Test
    void nullCheckerNull() {
        cityReport.nullChecker(null);
    }

    /**
     * checks reponse of display city methods if the give array is null
     */
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

    /**
     * check the response of nullchecker if the input string is null
     */
    @Test
    void nullCheckerContainsNull()
    {
        String nullString = null;
        cityReport.nullChecker(nullString);
    }

    /**
     * testing display city based on multiple categories with given parameters
     */
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

    /**
     * testing null checker with actual values
     */
    @Test
    void nullChecker()     {
        cityReport.nullChecker("Not Null");
    }

    /**
     * testing if the city population data can be gathered based on multiple categories
     * with or without limit
     */
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
     * display language with null data
     */
    @Test
    void displayLanguageReportNull()
    {
        languagesReport.displayLanguagesPopulation(null);
    }

    /**
     * display language with null arraylist
     */
    @Test
    void displayLanguageReportContainsNull()
    {
        ArrayList<Language> language = new ArrayList<>();
        language.add(null);
        languagesReport.displayLanguagesPopulation(language);
    }

    /**
     * testing converter
     */
    @Test
    void humanReadableFormatDouble(){
        languagesReport.humanReadableFormat(54000000);

    }

    /**
     * display langauge report based on give parameters
     */
    @Test
    void displayLanguageReport()     {
            ArrayList<Language> language = new ArrayList<>();
            Language ln = new Language();
            ln.setLanguage("Burmese");
            ln.setTotal_Population(54000000);
            ln.setPercentage(68.35);
            language.add(ln);
            languagesReport.displayLanguagesPopulation(language);
    }

    /**
     * checks if langauge data can be gathered
     */
    @Test
    void getLanguageReport(){
        languagesReport.getLanguagesReport(app.con);
    }

    /**
     * capital city testing starts here
     * testing the response of capital display methods with the null give data
     */
    @Test
    void displayCapitalNull() {
        capitalReport.displayCapital(null);
    }

    @Test
    void displayCapitalContinentNull(){
        capitalReport.displayCapitalContinent(null);
    }

    @Test
    void displayCapitalRegionNull(){
        capitalReport.displayCapitalRegion(null);
    }

    /**
     * storing null data in arraylist
     */
    @Test
    void arraylistCapitalNull(){
        capitalReport.CapitalArrList(null, null);
    }

    /**
     * testing the response of capital display methods with the null give arraylist
     */
    @Test
    void displayCapitalsTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapital(city);
    }

    @Test
    void displayCapitalsContTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapitalContinent(city);
    }
    @Test
    void displayCapitalsRegTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapitalRegion(city);
    }
    /**
     * storing null data in arraylist
     */
    @Test
    void arrayListCapitalTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ResultSet qry = null;
        capitalReport.CapitalArrList(city, qry);
    }

    /**
     * displaying given values in capital display methods
     */
    @Test
    void displayCapitals()     {
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setPopulation(5434678);
            city.add(ct);
            capitalReport.displayCapital(city);
    }

    @Test
    void displayCapitalsCont()     {
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setPopulation(5434678);
            city.add(ct);
            capitalReport.displayCapitalContinent(city);
        }

    @Test
    void displayCapitalsReg()     {
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setPopulation(5434678);
            city.add(ct);
            capitalReport.displayCapitalRegion(city);
        }

    /**
     * storing actual values in arraylists
     */
    @Test
    void arrayListCapitals()     {
        try{
            ArrayList<City> city = new ArrayList<>();
            City ct = new City();
            ct.setCityName("Yangon");
            ct.setCountryName("Myanmar");
            ct.setContinents("Asia");
            ct.setRegion("Southeast Asia");
            ct.setPopulation(5434678);
            city.add(ct);
            String strSelect =
                    "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM `city` JOIN country ON country.Capital = city.ID " +
                            "ORDER BY city.Population DESC";

            Statement stmt = app.con.createStatement();
            ResultSet qry = stmt.executeQuery(strSelect);
            capitalReport.CapitalArrList(city, qry);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * checks if capital data can be gathered based on multiple categories
     * with or without limit
     */
    @Test
    void getCapital()     {
        capitalReport.getCapitalPopByWorld(app.con, 3);
        capitalReport.getCapitalPopByWorld(app.con, 0);
    }

    @Test
    void getCapitalCont()     {
        capitalReport.getCapitalPopByContinent(app.con, 3);
        capitalReport.getCapitalPopByContinent(app.con, 0);
    }

    @Test
    void getCapitalReg()     {
        capitalReport.getCapitalPopByRegion(app.con, 3);
        capitalReport.getCapitalPopByRegion(app.con, 0);
    }

    /**
     * Rural and Urban report testing starts here
     * checks the response of display of rural and urban population data if it is null
     */
    @Test
    void displayRuralUrbanContNull() {
        ruReport.displayContinentPopulation(null);
    }
    @Test
    void displayRuralUrbanRegNull() {
        ruReport.displayRegionPopulation(null);
    }
    @Test
    void displayRuralUrbanCouNull() {
        ruReport.displayCountryPopulation(null);
    }

    /**
     * checks the response of display of rural and urban population data if arraylist is null
     */
    @Test
    void displayRuralUrbanContTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayContinentPopulation(city);
    }
    @Test
    void displayRuralUrbanRegTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayRegionPopulation(city);
    }
    @Test
    void displayRuralUrbanCouTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayCountryPopulation(city);
    }

    /**
     * human readable format converter if it is given zero
     */
    @Test
    void humanReadableFormatofRUzero()
    {
        ruReport.humanReadableFormat(0);
    }

    /**
     * human readable format converter if it is given actual value
     */
    @Test
    void humanReadableFormatofRU()
    {

        ruReport.humanReadableFormat(1000000000);
    }

    /**
     * display rural and urban based on actual data
     */
    @Test
    void displayRuralUrbanContPop() {
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
    }

    @Test
    void displayRuralUrbanRegPop()     {
        ArrayList<City> city = new ArrayList<>();
        City ct = new City();
        ct.setCountryName("Myanmar");
        ct.setContinents("Asia");
        ct.setRegion("Southeast Asia");
        ct.setTotalCitiesPopulation(2200000);
        ct.setTotalNotCitiesPopulation(3000000);
        ct.setTotalPopulation(5200000);
        city.add(ct);
        ruReport.displayRegionPopulation(city);
    }

    @Test
    void displayRuralUrbanCouPop()     {
        ArrayList<City> city = new ArrayList<>();
        City ct = new City();
        ct.setCountryName("Myanmar");
        ct.setContinents("Asia");
        ct.setRegion("Southeast Asia");
        ct.setTotalCitiesPopulation(2200000);
        ct.setTotalNotCitiesPopulation(3000000);
        ct.setTotalPopulation(5200000);
        city.add(ct);
        ruReport.displayCountryPopulation(city);

    }

    /**
     * gather rural and urban data based on multiple categories
     */
    @Test
    void getRuralUrbanContop() {
        ruReport.getContinentPopulation(app.con);
    }

    @Test
    void getRuralUrbanRegtop() {
        ruReport.getRegionPopulation(app.con);
    }

    @Test
    void getRuralUrbanCoutop() {
        ruReport.getCountryPopulation(app.con);
    }



    /**
     * Summary report testing starts here
     * display method is tested given null values
     */
    @Test
    void displaySummaryWorldNull() {
        summaryReport.displaySumWorldPop(null);
    }
    @Test
    void displaySummaryContNull() {
        summaryReport.displaySumContPop(null);
    }
    @Test
    void displaySummaryRegNull() {
        summaryReport.displaySumRegPop(null);
    }
    @Test
    void displaySummaryCouNull() {
        summaryReport.displaySumCouPop(null);
    }
    @Test
    void displaySummaryDistNull() {
        summaryReport.displaySumDistPop(null);
    }
    @Test
    void displaySummaryCityNull() {
        summaryReport.displaySumCityPop(null);
    }

    @Test
    void humanRedable() {

        summaryReport.humanReadableFormatLong(0);
        countryReport.humanReadableFormat(1000);
    }

    /**
     * display method is tested given null arrays
     */
    @Test
    void displaySummaryWorldTestContainsNull()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumWorldPop(couSum);
    }

    @Test
    void displaySummaryContTestContainsNull() {
        ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumContPop(couSum);
    }
    @Test
    void displaySummaryRegTestContainsNull()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumRegPop(couSum);
    }

    @Test
    void displaySummaryCouTestContainsNull()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumCouPop(couSum);
    }

    @Test
    void displaySummaryDistTestContainsNull()
    {
        ArrayList<City> citySum = new ArrayList<>();
        citySum.add(null);
        summaryReport.displaySumDistPop(citySum);
    }

    @Test
    void displaySummaryCityTestContainsNull()
    {
        ArrayList<City> citySum = new ArrayList<>();
        citySum.add(null);
        summaryReport.displaySumCityPop(citySum);
    }

    /**
     * display method is tested given actual values
     */
    @Test
    void displaySummaryWorld()
    {
            ArrayList<Country> couSum = new ArrayList<>();
            Country c = new Country();
            c.setGenPop(600000000);
            couSum.add(c);

            summaryReport.displaySumWorldPop(couSum);
    }

    @Test
    void displaySummaryCont()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        Country c = new Country();
        c.setContinent("Asia");
        c.setGenPop(50000000);
        couSum.add(c);

        summaryReport.displaySumContPop(couSum);
    }
    @Test
    void displaySummaryReg()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        Country c = new Country();
        c.setRegion("Southeast Asia");
        c.setGenPop(10000000);
        couSum.add(c);

        summaryReport.displaySumRegPop(couSum);
    }
    @Test
    void displaySummaryCou()
    {
        ArrayList<Country> couSum = new ArrayList<>();
        Country c = new Country();
        c.setName("Timor");
        c.setGenPop(50000);
        couSum.add(c);

        summaryReport.displaySumCouPop(couSum);
    }
    @Test
    void displaySummaryDist()
    {
        ArrayList<City> citySum = new ArrayList<>();
        City c = new City();
        c.setCityName("Fife");
        c.setGenPop(100000);
        citySum.add(c);

        summaryReport.displaySumDistPop(citySum);
    }
    @Test
    void displaySummaryCity()
    {
        ArrayList<City> citySum = new ArrayList<>();
        City c = new City();
        c.setCityName("Auchtermuchty");
        c.setPopulation(50000);
        citySum.add(c);

        summaryReport.displaySumCityPop(citySum);
    }

    /**
     * tested get methods to see if data can be gathered
     */
    @Test
    void getSummaryWorld() {
        summaryReport.sumWorldPop(app.con);
    }
    @Test
    void getSummaryCont() {
        summaryReport.sumContPop(app.con, 1);
    }
    @Test
    void getSummaryReg() {
        summaryReport.sumRegPop(app.con, 1);
    }
    @Test
    void getSummaryCou() {
        summaryReport.sumCouPop(app.con, 1);
    }
    @Test
    void getSummaryDist() {
        summaryReport.sumDistPop(app.con, 1);
        }
    @Test
    void getSummaryCity() {
        summaryReport.sumCityPop(app.con, 1);
    }

    @AfterAll
    static void disconnect(){
        app.disconnect();
    }

}
