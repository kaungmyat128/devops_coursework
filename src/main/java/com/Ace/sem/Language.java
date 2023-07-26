package com.Ace.sem;

public class Language {
    private String languages;
    private long totalPopulation;
    private double percentage;

    // Use Encapsulation :
    // Getter & Setter Method for each variable initialized in above
    public String getLanguage() {
        return languages;
    }

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
