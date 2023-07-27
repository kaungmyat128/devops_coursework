package com.Ace.sem;
/**
 * Declares variables to be used for language report
 * Encapsulation : Creates getter & setter methods for displaying reports
 */
public class Language {
    /**
     * variable to store language name
     * */
    private String languages;
    /**
     * variable to store total population of people who speak that language
     * */
    private long totalPopulation;
    /**
     * variable to store population percentage of people who speak that language
     * */
    private double percentage;

    /**
     * Getter Method for each variable initialized in above
     **/
    public String getLanguage() {
        return languages;
    }
    /**
     * Setter Method for each variable initialized in above
     **/
    public void setLanguage(final String language) {
        this.languages = language;
    }

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(final long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(final double percentage) {
        this.percentage = percentage;
    }
}
