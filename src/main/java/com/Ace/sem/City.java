package com.Ace.sem;

/**
 * Declares variables to be used for cities related reports
 * Creates methods for displaying reports
 */
public class City {

    // Declare Variables related to City Information, Country Code, District, Population, Country & Region .
    private String CityName;
    private String CountryCode;
    private String District;
    private int Population;
    private String CountryName;
    private String Continents;
    private String Region;

    private long totalPopulation;
    private long totalCitiesPopulation;
    private long totalNotCitiesPopulation;

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

    // Getter method for Total Population
    public long getTotalPopulation() {
        return totalPopulation;
    }

    // Setter method for Total Population
    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    // Getter method for Total Population
    public long getTotalCitiesPopulation() {
        return totalCitiesPopulation;
    }

    // Setter method for Total Population
    public void setTotalCitiesPopulation(long totalCitiesPopulation) {
        this.totalCitiesPopulation = totalCitiesPopulation;
    }
    // Getter method for Total Population
    public long getTotalNotCitiesPopulation() {
        return totalNotCitiesPopulation;
    }

    // Setter method for Total Population
    public void setTotalNotCitiesPopulation(long totalNotCitiesPopulation) {
        this.totalNotCitiesPopulation = totalNotCitiesPopulation;
    }
}



