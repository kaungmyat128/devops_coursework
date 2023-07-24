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
public class UnitTest
{
    private static CountryReport countryReport;
    private static CityReport cityReport;
    private static CountryLanguagesReport languagesReport;
    private static SummaryReport summaryReport;
    private static CapitalReport capitalReport;
    private static RuralUrbanReport ruReport;
    private static App app;

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
        final ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountries(country);

    }

    /**
     * checks the response of display country based on continent if arraylist is null
     */
    @Test
    void displayCountriesContinentTestContainsNull()
    {
        final ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesContinent(country);
    }

    /**
     * checks the response of display country based on region if arraylist is null
     */
    @Test
    void displayCountriesRegionTestContainsNull()
    {
        final ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesRegion(country);

    }

    /**
     * checks the response if null value is stored in arraylist
     */
    @Test
    void storeIntoArrayListTestContainsNull()
    {
        final ArrayList<Country> country = new ArrayList<>();
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
            final ArrayList<Country> country = new ArrayList();
            final Country cou = new Country();
            cou.setCode("MYN");
            cou.setName("Myanmar");
            cou.setContinent("Asia");
            cou.setRegion("Southeast Asia");
            cou.setPopulation(54_593_833);
            cou.setCapital("Yangon");
            country.add(cou);
            countryReport.displayCountries(country);

    }

    /**
     * checks if the display country based on continent method works based on give parameters
     */
    @Test
    void displayCountriesContinent()     {
        final ArrayList<Country> country = new ArrayList();
        final Country cou = new Country();
        cou.setCode("MYN");
        cou.setName("Myanmar");
        cou.setContinent("Asia");
        cou.setRegion("Southeast Asia");
        cou.setPopulation(54_593_833);
        cou.setCapital("Yangon");
        country.add(cou);
        countryReport.displayCountriesContinent(country);

    }
    /**
     * checks if the display country based on region method works based on give parameters
     */
    @Test
    void displayCountriesRegion()     {
        final ArrayList<Country> country = new ArrayList();
        final Country cou = new Country();
        cou.setCode("MYN");
        cou.setName("Myanmar");
        cou.setContinent("Asia");
        cou.setRegion("Southeast Asia");
        cou.setPopulation(54_593_833);
        cou.setCapital("Yangon");
        country.add(cou);
        countryReport.displayCountriesRegion(country);

    }

    /**
     * checks if storing into arraylist works
     */
    @Test
    void storeIntoArrayListNotNull()     {
        try{
            final ArrayList<Country> country = new ArrayList();
            final Country cou = new Country();
            cou.setCode("MYN");
            cou.setName("Myanmar");
            cou.setContinent("Asia");
            cou.setRegion("Southeast Asia");
            cou.setPopulation(54_593_833);
            cou.setCapital("Yangon");
            country.add(cou);
            final String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country INNER JOIN city ON country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT 5";

            final Statement stmt = app.con.createStatement();
            final ResultSet qry = stmt.executeQuery(strSelect);
            countryReport.storeIntoArraylist(country, qry);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * checks if country data based on different categories can be gathered with and without limit
     */
    @Test
    void countriesFetch()     {
            countryReport.getCountries(app.con, 3);
            countryReport.getCountries(app.con, 0);
    }
    @Test
    void countriesContinentFetch()     {
        countryReport.getCountriesContinent(app.con, 3);
        countryReport.getCountriesContinent(app.con, 0);
    }
    @Test
    void countriesRegionFetch()     {
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
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCities(city);
    }
    @Test
    void displayCityContinentsTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityContinents(city);
    }
    @Test
    void displayCityCountriesCountriesTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityCountries(city);
    }
    @Test
    void displayCityRegionTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        cityReport.displayCityRegion(city);
    }
    @Test
    void displayCitiesDistrictContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
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

            final ArrayList<City> city = new ArrayList<>();
            final City ct1 = new City();
            ct1.setCityName("Yangon");
            ct1.setCountryName("Myanmar");
            ct1.setContinents("Asia");
            ct1.setRegion("Southeast Asia");
            ct1.setDistrict("Yangon");
            ct1.setPopulation(5_434_678);
            city.add(ct1);
            cityReport.displayCities(city);
    }
    @Test
    void displayCityContinents()     {

        final ArrayList<City> city = new ArrayList<>();
        final City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5_434_678);
        city.add(ct1);
        cityReport.displayCityContinents(city);
    }
    @Test
    void displayCityCountries()     {

        final ArrayList<City> city = new ArrayList<>();
        final City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5_434_678);
        city.add(ct1);
        cityReport.displayCityCountries(city);

    }
    @Test
    void displayCityRegion()     {

        final ArrayList<City> city = new ArrayList<>();
        final City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5_434_678);
        city.add(ct1);
        cityReport.displayCityRegion(city);
    }
    @Test
    void displayCityDistrict()     {

        final ArrayList<City> city = new ArrayList<>();
        final City ct1 = new City();
        ct1.setCityName("Yangon");
        ct1.setCountryName("Myanmar");
        ct1.setContinents("Asia");
        ct1.setRegion("Southeast Asia");
        ct1.setDistrict("Yangon");
        ct1.setPopulation(5_434_678);
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
    void cityPopFetch()     {
        cityReport.getCityPop(app.con, 3);
        cityReport.getCityPop(app.con, 0);
    }
    @Test
    void cityPopByDistrictFetch()     {
        cityReport.getCityPopByDistrict(app.con, 3);
        cityReport.getCityPopByDistrict(app.con, 0);
    }
    @Test
    void cityPopByContinentFetch()     {
        cityReport.getCityPopByContinent(app.con, 3);
        cityReport.getCityPopByContinent(app.con, 0);
    }
    @Test
    void cityPopByRegionFetch()     {
        cityReport.getCityPopByRegion(app.con, 3);
        cityReport.getCityPopByRegion(app.con, 0);
    }
    @Test
    void cityPopByCountryFetch()     {
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
        final ArrayList<Language> language = new ArrayList<>();
        language.add(null);
        languagesReport.displayLanguagesPopulation(language);
    }

    /**
     * testing converter
     */
    @Test
    void humanReadableFormatDouble(){
        languagesReport.humanReadableFormat(54_000_000);

    }

    /**
     * display langauge report based on give parameters
     */
    @Test
    void displayLanguageReport()     {
            final ArrayList<Language> language = new ArrayList<>();
            final Language lan = new Language();
            lan.setLanguage("Burmese");
            lan.setTotalPopulation(54_000_000);
            lan.setPercentage(68.35);
            language.add(lan);
            languagesReport.displayLanguagesPopulation(language);
    }

    /**
     * checks if langauge data can be gathered
     */
    @Test
    void languageReportFetch(){
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
        capitalReport.capitalArrList(null, null);
    }

    /**
     * testing the response of capital display methods with the null give arraylist
     */
    @Test
    void displayCapitalsTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapital(city);
    }

    @Test
    void displayCapitalsContTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapitalContinent(city);
    }
    @Test
    void displayCapitalsRegTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        capitalReport.displayCapitalRegion(city);
    }
    /**
     * storing null data in arraylist
     */
    @Test
    void arrayListCapitalTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ResultSet qry = null;
        capitalReport.capitalArrList(city, qry);
    }

    /**
     * displaying given values in capital display methods
     */
    @Test
    void displayCapitals()     {
            final ArrayList<City> city = new ArrayList<>();
            final City cty = new City();
            cty.setCityName("Yangon");
            cty.setCountryName("Myanmar");
            cty.setContinents("Asia");
            cty.setRegion("Southeast Asia");
            cty.setPopulation(5_434_678);
            city.add(cty);
            capitalReport.displayCapital(city);
    }

    @Test
    void displayCapitalsCont()     {
            final ArrayList<City> city = new ArrayList<>();
            final City cty = new City();
            cty.setCityName("Yangon");
            cty.setCountryName("Myanmar");
            cty.setContinents("Asia");
            cty.setRegion("Southeast Asia");
            cty.setPopulation(5_434_678);
            city.add(cty);
            capitalReport.displayCapitalContinent(city);
        }

    @Test
    void displayCapitalsReg()     {
            final ArrayList<City> city = new ArrayList<>();
            final City cty = new City();
            cty.setCityName("Yangon");
            cty.setCountryName("Myanmar");
            cty.setContinents("Asia");
            cty.setRegion("Southeast Asia");
            cty.setPopulation(5_434_678);
            city.add(cty);
            capitalReport.displayCapitalRegion(city);
        }

    /**
     * storing actual values in arraylists
     */
    @Test
    void arrayListCapitals()     {
        try{
            final ArrayList<City> city = new ArrayList<>();
            final City cty = new City();
            cty.setCityName("Yangon");
            cty.setCountryName("Myanmar");
            cty.setContinents("Asia");
            cty.setRegion("Southeast Asia");
            cty.setPopulation(5_434_678);
            city.add(cty);
            final String strSelect =
                    "SELECT city.Name AS CapitalName, country.Name AS CountryName, country.Continent AS Continent, country.Region AS Region, city.Population AS CapitalPop " +
                            "FROM `city` JOIN country ON country.Capital = city.ID " +
                            "ORDER BY city.Population DESC";

            final Statement stmt = app.con.createStatement();
            final ResultSet qry = stmt.executeQuery(strSelect);
            capitalReport.capitalArrList(city, qry);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * checks if capital data can be gathered based on multiple categories
     * with or without limit
     */
    @Test
    void capitalFetch()     {
        capitalReport.getCapitalPopByWorld(app.con, 3);
        capitalReport.getCapitalPopByWorld(app.con, 0);
    }

    @Test
    void capitalContFetch()     {
        capitalReport.getCapitalPopByContinent(app.con, 3);
        capitalReport.getCapitalPopByContinent(app.con, 0);
    }

    @Test
    void capitalRegFetch()     {
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
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayContinentPopulation(city);
    }
    @Test
    void displayRuralUrbanRegTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ruReport.displayRegionPopulation(city);
    }
    @Test
    void displayRuralUrbanCouTestContainsNull()
    {
        final ArrayList<City> city = new ArrayList<>();
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

        ruReport.humanReadableFormat(1_000_000_000);
    }

    /**
     * display rural and urban based on actual data
     */
    @Test
    void displayRuralUrbanContPop() {
        final ArrayList<City> city = new ArrayList<>();
        final City cty = new City();
        cty.setCountryName("Myanmar");
        cty.setContinents("Asia");
        cty.setRegion("Southeast Asia");
        cty.setTotalCitiesPopulation(2_200_000);
        cty.setTotalNotCitiesPopulation(3_000_000);
        cty.setTotalPopulation(5_200_000);
        city.add(cty);
        ruReport.displayContinentPopulation(city);
    }

    @Test
    void displayRuralUrbanRegPop()     {
        final ArrayList<City> city = new ArrayList<>();
        final City cty = new City();
        cty.setCountryName("Myanmar");
        cty.setContinents("Asia");
        cty.setRegion("Southeast Asia");
        cty.setTotalCitiesPopulation(2_200_000);
        cty.setTotalNotCitiesPopulation(3_000_000);
        cty.setTotalPopulation(5_200_000);
        city.add(cty);
        ruReport.displayRegionPopulation(city);
    }

    @Test
    void displayRuralUrbanCouPop()     {
        final ArrayList<City> city = new ArrayList<>();
        final City cty = new City();
        cty.setCountryName("Myanmar");
        cty.setContinents("Asia");
        cty.setRegion("Southeast Asia");
        cty.setTotalCitiesPopulation(2_200_000);
        cty.setTotalNotCitiesPopulation(3_000_000);
        cty.setTotalPopulation(5_200_000);
        city.add(cty);
        ruReport.displayCountryPopulation(city);

    }

    /**
     * gather rural and urban data based on multiple categories
     */
    @Test
    void ruralUrbanContopFetch() {
        ruReport.getContinentPopulation(app.con);
    }

    @Test
    void ruralUrbanRegtopFetch() {
        ruReport.getRegionPopulation(app.con);
    }

    @Test
    void ruralUrbanCoutopFetch() {
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
        final ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumWorldPop(couSum);
    }

    @Test
    void displaySummaryContTestContainsNull() {
        final ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumContPop(couSum);
    }
    @Test
    void displaySummaryRegTestContainsNull()
    {
        final ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumRegPop(couSum);
    }

    @Test
    void displaySummaryCouTestContainsNull()
    {
        final ArrayList<Country> couSum = new ArrayList<>();
        couSum.add(null);
        summaryReport.displaySumCouPop(couSum);
    }

    @Test
    void displaySummaryDistTestContainsNull()
    {
        final ArrayList<City> citySum = new ArrayList<>();
        citySum.add(null);
        summaryReport.displaySumDistPop(citySum);
    }

    @Test
    void displaySummaryCityTestContainsNull()
    {
        final ArrayList<City> citySum = new ArrayList<>();
        citySum.add(null);
        summaryReport.displaySumCityPop(citySum);
    }

    /**
     * display method is tested given actual values
     */
    @Test
    void displaySummaryWorld()
    {
            final ArrayList<Country> couSum = new ArrayList<>();
            final Country cou = new Country();
            cou.setGenPop(600_000_000);
            couSum.add(cou);

            summaryReport.displaySumWorldPop(couSum);
    }

    @Test
    void displaySummaryCont()
    {
        final ArrayList<Country> couSum = new ArrayList<>();
        final Country cou = new Country();
        cou.setContinent("Asia");
        cou.setGenPop(50_000_000);
        couSum.add(cou);

        summaryReport.displaySumContPop(couSum);
    }
    @Test
    void displaySummaryReg()
    {
        final ArrayList<Country> couSum = new ArrayList<>();
        final Country cou = new Country();
        cou.setRegion("Southeast Asia");
        cou.setGenPop(10_000_000);
        couSum.add(cou);

        summaryReport.displaySumRegPop(couSum);
    }
    @Test
    void displaySummaryCou()
    {
        final ArrayList<Country> couSum = new ArrayList<>();
        final Country cou = new Country();
        cou.setName("Timor");
        cou.setGenPop(50_000);
        couSum.add(cou);

        summaryReport.displaySumCouPop(couSum);
    }
    @Test
    void displaySummaryDist()
    {
        final ArrayList<City> citySum = new ArrayList<>();
        final City cty = new City();
        cty.setCityName("Fife");
        cty.setGenPop(100_000);
        citySum.add(cty);

        summaryReport.displaySumDistPop(citySum);
    }
    @Test
    void displaySummaryCity()
    {
        final ArrayList<City> citySum = new ArrayList<>();
        final City cty = new City();
        cty.setCityName("Auchtermuchty");
        cty.setPopulation(50_000);
        citySum.add(cty);

        summaryReport.displaySumCityPop(citySum);
    }

    /**
     * tested get methods to see if data can be gathered
     */
    @Test
    void summaryWorldFetch() {
        summaryReport.sumWorldPop(app.con);
    }
    @Test
    void summaryContFetch() {
        summaryReport.sumContPop(app.con, 1);
    }
    @Test
    void summaryRegFetch() {
        summaryReport.sumRegPop(app.con, 1);
    }
    @Test
    void summaryCouFetch() {
        summaryReport.sumCouPop(app.con, 1);
    }
    @Test
    void summaryDistFetch() {
        summaryReport.sumDistPop(app.con, 1);
        }
    @Test
    void summaryCityFetch() {
        summaryReport.sumCityPop(app.con, 1);
    }

    @AfterAll
    static void disconnect(){
        app.disconnect();
    }

}
