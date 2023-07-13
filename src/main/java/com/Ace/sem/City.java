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

}



