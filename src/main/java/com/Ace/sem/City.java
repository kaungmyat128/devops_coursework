package com.Ace.sem;

/**
 * Declares variables to be used for cities related reports
 * Creates methods for displaying reports
 */
public class City {

    /**
     * genPop variable to store total population
     */
    private long genPop;
    /**
     * variable to store city name
     */
    private String cityName;
    /**
     * variable to store district
     */
    private String district;
    /**
     * variable to store city population
     */
    private int population;
    /**
     * variable to store country name
     */
    private String countryName;
    /**
     * variable to store continent
     */
    private String continents;
    /**
     * variable to store region
     */
    private String region;
    /**
     * variable to store total population
     */
    private long totalPopulation;
    /**
     * variable to store total population in cities
     */
    private long totalRuralPop;
    /**
     * variable to store total population in not cities
     */
    private long totalUrbanPop;

    public long getGenPop() {
        return genPop;
    }

    public void setGenPop(final long genPop) {
        this.genPop = genPop;
    }
    // Getter method for CityName
    public String getCityName() {
        return cityName;
    }

    // Setter method for CityName
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    // Getter method for District
    public String getDistrict() {
        return district;
    }

    // Setter method for District
    public void setDistrict(final String district) {
        this.district = district;
    }

    // Getter method for Population
    public int getPopulation() {
        return population;
    }

    // Setter method for Population
    public void setPopulation(final int population) {
        this.population = population;
    }

    // Getter method for CountryName
    public String getCountryName() {
        return countryName;
    }

    // Setter method for CountryName
    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    // Getter method for Continents
    public String getContinents() {
        return continents;
    }

    // Setter method for Continents
    public void setContinents(final String continents) {
        this.continents = continents;
    }

    // Getter method for Region
    public String getRegion() {
        return region;
    }

    // Setter method for Region
    public void setRegion(final String region) {
        this.region = region;
    }

    // Getter method for Total Population
    public long getTotalPopulation() {
        return totalPopulation;
    }

    // Setter method for Total Population
    public void setTotalPopulation(final long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    // Getter method for Total Population
    public long getTotalCitiesPopulation() {
        return totalUrbanPop;
    }

    // Setter method for Total Population
    public void setTotalCitiesPopulation(final long totalUrbanPop) {
        this.totalUrbanPop = totalUrbanPop;
    }
    // Getter method for Total Population
    public long getTotalNotCitiesPopulation() {
        return totalRuralPop;
    }

    // Setter method for Total Population
    public void setTotalNotCitiesPopulation(final long totalRuralPop) {
        this.totalRuralPop = totalRuralPop;
    }
}



