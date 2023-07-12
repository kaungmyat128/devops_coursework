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
    public int ID;
    /**
     * City Name
     */
    public String CityName;

    /**
     * City CountryCode
     */
    public String CountryCode;

    /**
     * City District
     */
    public String District;

    /**
     * City Population
     */
    public int Population;

    /**
     * CountryName
     */
    public String CountryName;

    public String Continents;

    public String Region;

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
                            cityR.CityName, cityR.CountryName, cityR.District, cityR.Population);
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
            if(!cityR.Continents.equals(currentContinent)){
                System.out.println("\n Cities sorted by Population in " + cityR.Continents + " Continents");
                System.out.println("===========================================");
                currentContinent = cityR.Continents;
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "Continent", "District", "Population"));
            }
            String continent_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.Continents, cityR.District, cityR.Population);
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
            if(!cityR.Region.equals(currentRegion)){
                System.out.println("\n Cities sorted by Population in " + cityR.Region + " Region");
                System.out.println("===========================================");
                currentRegion = cityR.Region;
                System.out.println(String.format("%-40s %-30s %-30s %-30s %-20s", "City", "Country", "District", "Region", "Population"));
            }
            String region_info =
                    String.format("%-40s %-30s %-30s %-30s %-20s",
                            cityR.CityName, cityR.CountryName, cityR.District,cityR.Region, cityR.Population);
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
            if (!cty.CountryName.equals(currentCountry)){
                System.out.println("\n Cities sorted by Population in " + cty.CountryName + " Country");
                System.out.println("===========================================");
                currentCountry = cty.CountryName;
                System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cty.CityName, cty.CountryName, cty.District, cty.Population);
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
            if (!cty.District.equals(currentDistrict)){
                System.out.println("\n Cities sorted by Population in " + cty.District + " District");
                System.out.println("===========================================");
                currentDistrict = cty.District;
                System.out.println(String.format("%-40s %-30s %-30s %-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s %-30s %-30s %-20s",
                            cty.CityName, cty.CountryName, cty.District, cty.Population);
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}



