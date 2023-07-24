package com.Ace.sem;

/**
 * Declares variables to be used for cities related reports
 * Creates methods for displaying reports
 */
public class City {

    // Declare Variables related to City Information, Country Code, District, Population, Country & Region .

    private long genPop;
    private String cityName;
    private String district;
    private int population;
    private String countryName;
    private String continents;
    private String region;
    private long totalPopulation;
    private long totalCitiesPopulation;
    private long totalNotCitiesPopulation;

    public long getGenPop() {
        return genPop;
    }

    public void setGenPop(long genPop) {
        this.genPop = genPop;
    }
    // Getter method for CityName
    public String getCityName() {
        return cityName;
    }

    // Setter method for CityName
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    // Getter method for District
    public String getDistrict() {
        return district;
    }

    // Setter method for District
    public void setDistrict(String district) {
        this.district = district;
    }

    // Getter method for Population
    public int getPopulation() {
        return population;
    }

    // Setter method for Population
    public void setPopulation(int population) {
        this.population = population;
    }

    // Getter method for CountryName
    public String getCountryName() {
        return countryName;
    }

    // Setter method for CountryName
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    // Getter method for Continents
    public String getContinents() {
        return continents;
    }

    // Setter method for Continents
    public void setContinents(String continents) {
        this.continents = continents;
    }

    // Getter method for Region
    public String getRegion() {
        return region;
    }

    // Setter method for Region
    public void setRegion(String region) {
        this.region = region;
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



