package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class City {
    public static void main(String[] args) {

    }
    /**
     * City ID
     */
    private int ID;
    /**
     * City Name
     */
    private String CityName;

    /**
     * City CountryCode
     */
    private String CountryCode;

    /**
     * City District
     */
    private String District;

    /**
     * City Population
     */
    private int Population;

    /**
     * City's CountryName
     */
    private String CountryName;

    /**
     * City Continents
     */
    private String Continents;

    /**
     * City Region
     */
    private String Region;

    // Getter method for ID
    public int getID() {
        return ID;
    }

    // Setter method for ID
    public void setID(int ID) {
        this.ID = ID;
    }

    // Getter method for CityName
    public String getCityName() {
        return CityName;
    }

    // Setter method for CityName
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    // Getter method for District
    public String getDistrict() {
        return District;
    }

    // Setter method for District
    public void setDistrict(String District) {
        this.District = District;
    }

    // Getter method for CountryCode
    public String getCountryCode() {
        return CountryCode;
    }

    // Setter method for CountryCode
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    // Getter method for Population
    public int getPopulation() {
        return Population;
    }

    // Setter method for Population
    public void setPopulation(int Population) {
        this.Population = Population;
    }

    // Getter method for CountryName
    public String getCountryName() {
        return CountryName;
    }

    // Setter method for CountryName
    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    // Getter method for Continents
    public String getContinents() {
        return Continents;
    }

    // Setter method for Continents
    public void setContinents(String Continents) {
        this.Continents = Continents;
    }

    // Getter method for Region
    public String getRegion() {
        return Region;
    }

    // Setter method for Region
    public void setRegion(String Region) {
        this.Region = Region;
    }

    //Method to Display Cities in the world
    public void displayCities(ArrayList<City> cities_list)
    {
        // Print header

        System.out.println("============================================================");

        System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
        // Loop over all cities population in the list
        for (City cityR : cities_list)
        {
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getDistrict(), cityR.getPopulation());
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    //Method to Display Cities in Each Continent
    public void displayCityContinents(ArrayList<City> continent_list)
    {
        // Print header
        System.out.println("============================================================");

        // Initialize Current Continent variable
        String currentContinent = null;

        // Loop over all continents and cities population in the list
        for (City cityR : continent_list)
        {
            if(!cityR.getContinents().equals(currentContinent)){
                System.out.println("\n Cities sorted by Population in " + cityR.getContinents() + " Continents");
                System.out.println("===========================================");
                currentContinent = cityR.getContinents();
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "Continent", "District", "Population"));
            }
            String continent_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getContinents(),
                            cityR.getDistrict(), cityR.getPopulation());
            System.out.println(continent_info);
        }
        System.out.println("============================================================");
    }

    //Method to Display Cities in Each Region
    public void displayCityRegion(ArrayList<City> region_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Region variable
        String currentRegion = null;

        // Loop over all region population in the list
        for (City cityR : region_list){
            if(!cityR.getRegion().equals(currentRegion)){
                System.out.println("\n Cities sorted by Population in " + cityR.getRegion() + " Region");
                System.out.println("===========================================");
                currentRegion = cityR.getRegion();
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "District", "Region", "Population"));
            }
            String region_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getDistrict(),
                            cityR.getRegion(), cityR.getPopulation());
            System.out.println(region_info);
        }
        System.out.println("============================================================");
    }

    //Method to Display Cities in Each Country
    public void displayCityCountries(ArrayList<City> countries_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Country variable
        String currentCountry = null;

        // Loop over all countries population in the list
        for (City cty : countries_list){
            if (!cty.getCountryName().equals(currentCountry)){
                System.out.println("\n Cities sorted by Population in " + cty.getCountryName() + " Country");
                System.out.println("===========================================");
                currentCountry = cty.getCountryName();
                System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cty.getCityName(), cty.getCountryName(), cty.getDistrict(), cty.getPopulation());
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    //Method to Display Cities in Each District
    public void displayCityDistrict(ArrayList<City> districts_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Country variable
        String currentDistrict = null;

        for (City cty : districts_list){
            if (!cty.getDistrict().equals(currentDistrict)){
                System.out.println("\n Cities sorted by Population in " + cty.getDistrict() + " District");
                System.out.println("===========================================");
                currentDistrict = cty.getDistrict();
                System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cty.getCityName(), cty.getCountryName(), cty.getDistrict(), cty.getPopulation());
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}



