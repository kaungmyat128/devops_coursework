package com.Ace.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class unitTesting
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
        countryReport.displayCountries(country);

    }
    @Test
    void displayCountriesContinentTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesContinent(country);
    }
    @Test
    void displayCountriesRegionTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<>();
        country.add(null);
        countryReport.displayCountriesRegion(country);

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
        String nullString = null;
        cityReport.nullChecker(nullString);
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
            ArrayList<Language> language = new ArrayList<>();
            Language ln = new Language();
            ln.setLanguage("Burmese");
            ln.setTotal_Population(54000000);
            ln.setPercentage(68.35);
            language.add(ln);
            languagesReport.displayLanguagesPopulation(language);
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
    }

    @Test
    void displayCaptialContinentNull(){
        capitalReport.displayCapitalContinent(null);
    }

    @Test
    void displayCaptialRegionNull(){;
        capitalReport.displayCapitalRegion(null);
    }

    @Test
    void arraylistCapitalNull(){
        capitalReport.CapitalArrList(null, null);
    }

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
    @Test
    void arrayListCapitalTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<>();
        city.add(null);
        ResultSet qry = null;
        capitalReport.CapitalArrList(city, qry);
    }

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
    @Test
    void humanReadableFormatofRUzero()
    {
        ruReport.humanReadableFormat(0);
    }

    @Test
    void humanReadableFormatofRU()
    {

        ruReport.humanReadableFormat(1000000000);
    }

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
