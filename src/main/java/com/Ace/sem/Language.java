package com.Ace.sem;

public class Language {
    private String language;
    private long totalPopulation;
    private double percentage;

    // Use Encapsulation : Getter & Setter Method for each variable initialized in above
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getTotal_Population() {
        return totalPopulation;
    }

    public void setTotal_Population(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
