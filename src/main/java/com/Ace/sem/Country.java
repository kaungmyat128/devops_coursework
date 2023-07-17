package com.Ace.sem;

/**
     * Declares variables to be used for country related reports
     * Creates methods for displaying reports
     */
public class Country {
    // Declare Variables related to Country Information and Capital City Names

    private long worldPop;
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private int Population;
    private String Capital;

    // Use Encapsulation : Getter & Setter Method for each variable initialized in above
    public long getWorldPop() {
        return worldPop;
    }

    public void setWorldPop(long worldPop) {
        this.worldPop = worldPop;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String Capital) {
        this.Capital = Capital;
    }

}
