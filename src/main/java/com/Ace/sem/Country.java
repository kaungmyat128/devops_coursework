package com.Ace.sem;

/**
 * Declares variables to be used for country related reports
 * Creates methods for displaying reports
 */
public class Country {
    // Declare Variables related to Country Information and Capital City Names

    /**
     * variable for total population
     * */
    private long genPop;
    /**
     * variable to store country code
     * */
    private String code;
    /**
     * variable to store country name
     * */
    private String name;
    /**
     * variable to store continent
     * */
    private String continent;
    /**
     * variable to store region
     * */
    private String region;
    /**
     * variable to store country population
     * */
    private int population;
    /**
     * variable to store country capital
     * */
    private String capital;

    // Use Encapsulation :
    // Getter & Setter Method for each variable initialized in above
    public long getGenPop() {
        return genPop;
    }

    public void setGenPop(final long genPop) {
        this.genPop = genPop;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(final String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(final int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(final String capital) {
        this.capital = capital;
    }

}
